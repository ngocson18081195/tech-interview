package techbase.interview.entity.audit;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Description:
 * The DeleteAudit class.
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
public class DeleteAudit {

    @Column(name = "delete_flag", updatable = false)
    private Boolean delFlag;
}
