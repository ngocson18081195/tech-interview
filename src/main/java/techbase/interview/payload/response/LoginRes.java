package techbase.interview.payload.response;

import lombok.Data;

/**
 * Description:
 * The LoginRes class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Data
public class LoginRes {
    private String accessToken;
    private String fullName;
}
