package techbase.interview.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import techbase.interview.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Description:
 * The Users class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Users extends BaseEntity {

    private String username;
    private String password;
    private Long roleId;

    @Builder
    public Users(Long id, String name, Boolean isActive, String username, String password, Long roleId) {
        super(id, name, isActive);
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }
}
