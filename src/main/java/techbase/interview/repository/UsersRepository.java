package techbase.interview.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import techbase.interview.entity.Users;

/**
 * Description:
 * The UsersRepository class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Repository
public interface UsersRepository extends PagingAndSortingRepository<Users, Long> {
    Users findByUsername(String username);
}
