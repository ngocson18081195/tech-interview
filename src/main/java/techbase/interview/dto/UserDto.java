package techbase.interview.dto;

import lombok.Data;
import techbase.interview.dto.base.BaseDto;

/**
 * Description:
 * The UserDto class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/2/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/2/2021
 */
@Data
public class UserDto extends BaseDto {

    private String username;
    private String password;
    private Long roleId;
}
