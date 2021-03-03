package techbase.interview.payload.request;

import lombok.Data;

/**
 * Description:
 * The LoginRequest class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Data
public class LoginRequest {

    private String username;
    private String password;

}
