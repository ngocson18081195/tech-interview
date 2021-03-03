package techbase.interview.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import techbase.interview.dto.UserDto;
import techbase.interview.entity.Users;
import techbase.interview.exception.SMIllegalArgumentException;
import techbase.interview.payload.request.LoginRequest;
import techbase.interview.payload.response.LoginRes;
import techbase.interview.payload.response.PagingRes;
import techbase.interview.repository.UsersRepository;
import techbase.interview.security.CustomUserDetails;
import techbase.interview.security.JwtTokenProvider;
import techbase.interview.service.UserService;
import techbase.interview.util.Assert;
import techbase.interview.util.ObjectMapperUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * The UserServiceImpl class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Transactional
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final UsersRepository usersRepository;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor
     * @param authenticationManager
     * @param usersRepository
     * @param tokenProvider
     * @param passwordEncoder
     */
    @Autowired
    public UserServiceImpl(AuthenticationManager authenticationManager, UsersRepository usersRepository,
                           JwtTokenProvider tokenProvider, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Method Login
     * @param loginRequest
     * @return the LoginRes
     */
    @Override
    public LoginRes login(LoginRequest loginRequest) {
        Users user = this.usersRepository.findByUsername(loginRequest.getUsername());
        Assert.notNull(user, String.format("User not found with username=%s", loginRequest.getUsername()));
        if (!this.passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new SMIllegalArgumentException("Wrong password");
        }
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        LoginRes loginRes = new LoginRes();
        loginRes.setAccessToken(jwt);
        loginRes.setFullName(user.getName());
        return loginRes;
    }

    /**
     * Get List User
     * @param pageable
     * @return The PagingRes
     */
    @Override
    public PagingRes listUsers(Pageable pageable) {
        Page<Users> users = this.usersRepository.findAll(pageable);
        List<Users> usersList = users.getContent();
        List<UserDto> userDtos = new LinkedList<>();
        if (null != usersList && !usersList.isEmpty()) {
            usersList.forEach(users1 -> {
                UserDto userDto = ObjectMapperUtils.map(users1, UserDto.class);
                userDtos.add(userDto);
            });
        }
        PagingRes pagingRes = new PagingRes();
        pagingRes.setDataList(userDtos);
        pagingRes.setTotal(users.getTotalElements());
        return pagingRes;
    }

}
