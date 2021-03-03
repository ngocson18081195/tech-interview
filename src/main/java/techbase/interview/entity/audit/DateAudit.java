package techbase.interview.entity.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description:
 * The DateAudit class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Data
@MappedSuperclass
@JsonIgnoreProperties(
        value = {"createdDate", "modifiedDate"},
        allowGetters = true,
        allowSetters = true
)
@EntityListeners(AuditingEntityListener.class)
public class DateAudit implements Serializable {

    @CreatedDate
    @Column(nullable = false, name = "created_date")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(nullable = false, name = "modified_date")
    private LocalDateTime modifiedDate;
}
