package techbase.interview.entity.audit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Description:
 * The AuditEntity class.
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
@EqualsAndHashCode(callSuper = true)
public abstract class AuditEntity extends CreateAudit {

    @LastModifiedBy
    @Column(name = "modified_user")
    private Long modifiedUser;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime modifiedDate;
}
