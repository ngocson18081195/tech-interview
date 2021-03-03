package techbase.interview.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import techbase.interview.entity.Users;
import techbase.interview.repository.UsersRepository;

/**
 * Description:
 * The UserService class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Service
public class UserService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.usersRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    public UserDetails loadUserById(Long userId) {
        Users user = this.usersRepository.findById(userId).orElse(null);
        return new CustomUserDetails(user);
    }
}
