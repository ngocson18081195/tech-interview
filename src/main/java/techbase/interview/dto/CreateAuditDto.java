package techbase.interview.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description:
 * The CreateAuditDto class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/2/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/2/2021
 */
@Data
public class CreateAuditDto {
    private Long createdUser;
    private LocalDateTime createdDate;
}
