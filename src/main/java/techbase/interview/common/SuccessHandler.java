package techbase.interview.common;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

/**
 * Description:
 * The SuccessHandler class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Component
public class SuccessHandler {

    public ApiResponse handlerSuccess(Object data, long start) {
        long took = System.currentTimeMillis() - start;
        return new ApiResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS, Strings.EMPTY, took, data);
    }
}
