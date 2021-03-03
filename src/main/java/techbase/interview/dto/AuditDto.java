package techbase.interview.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Description:
 * The AuditDto class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/2/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/2/2021
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuditDto extends CreateAuditDto {
    private Long modifiedUser;
    private LocalDateTime modifiedDate;
    private LocalDateTime deleteDate;
}
