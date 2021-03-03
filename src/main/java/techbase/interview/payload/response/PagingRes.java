package techbase.interview.payload.response;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * The PagingRes class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/2/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/2/2021
 */
@Data
public class PagingRes {
    private List<?> dataList = new LinkedList<>();
    private long total;
}
