package techbase.interview.service;

import org.springframework.data.domain.Pageable;
import techbase.interview.payload.request.LoginRequest;
import techbase.interview.payload.response.LoginRes;
import techbase.interview.payload.response.PagingRes;

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
public interface UserService {

    LoginRes login(LoginRequest loginRequest);

    PagingRes listUsers(Pageable pageable);

}
