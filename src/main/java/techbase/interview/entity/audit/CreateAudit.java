package techbase.interview.entity.audit;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Description:
 * The CreateAudit class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class CreateAudit extends DeleteAudit {

    @CreatedBy
    @Column(name = "created_user", updatable = false)
    private Long createdUser;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate;
}
