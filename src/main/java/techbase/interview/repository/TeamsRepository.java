package techbase.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techbase.interview.entity.Teams;

/**
 * Description:
 * The TeamsRepository class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {
}
