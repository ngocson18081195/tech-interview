package techbase.interview.dto.base;

import lombok.Data;
import techbase.interview.dto.AuditDto;

/**
 * Description:
 * The BaseDto class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/2/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/2/2021
 */
@Data
public class BaseDto extends AuditDto {
    private Long id;
}
