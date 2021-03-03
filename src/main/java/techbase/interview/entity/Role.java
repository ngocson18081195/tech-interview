package techbase.interview.entity;

import lombok.Data;
import techbase.interview.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Description:
 * The Role class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Entity
@Table(name = "role")
@Data
public class Role extends BaseEntity {
}
