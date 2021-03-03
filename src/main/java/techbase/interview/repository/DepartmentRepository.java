package techbase.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techbase.interview.entity.Departments;

/**
 * Description:
 * The DepartmentRepository class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Long> {
}
