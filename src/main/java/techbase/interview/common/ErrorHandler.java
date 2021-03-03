package techbase.interview.common;

import org.springframework.stereotype.Component;

/**
 * Description:
 * The ErrorHandler class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Component
public class ErrorHandler {

    public ApiResponse handlerError(Exception ex, long start) {
        long took = System.currentTimeMillis() - start;
        return new ApiResponse(AppConstants.ERROR_CODE, AppConstants.ERROR, ex.getMessage(), took);
    }

}
