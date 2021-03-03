package techbase.interview.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import techbase.interview.entity.audit.AuditEntity;

import javax.persistence.*;

/**
 * Description:
 * The BaseEntity class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity extends AuditEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7081852960248959797L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;
}
