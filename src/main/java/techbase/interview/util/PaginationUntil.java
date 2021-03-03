package techbase.interview.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

/**
 * Description:
 * The PaginationUntil class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/2/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/2/2021
 */
public class PaginationUntil {
    public static Pageable validatePagination(int page, int size, String sort) {
        Pageable pageable = null;
        if (page == -1 && size == 1) {
            pageable = PageRequest.of(0,Integer.MAX_VALUE);
        }else {
            if (StringUtils.isEmpty(sort)) {
                pageable = PageRequest.of(page -1,size);
            } else {
                pageable = PageRequest.of(page -1,size, Sort.by(sort).ascending());
            }
        }
        return pageable;
    }
}
