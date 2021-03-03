package techbase.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import techbase.interview.common.ApiResponse;
import techbase.interview.common.AppConstants;
import techbase.interview.common.ErrorHandler;
import techbase.interview.common.SuccessHandler;
import techbase.interview.payload.response.PagingRes;
import techbase.interview.service.UserService;
import techbase.interview.util.PaginationUntil;


/**
 * Description:
 * The UserController class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final SuccessHandler successHandler;
    private final ErrorHandler errorHandler;


    @Autowired
    public UserController(UserService userService, SuccessHandler successHandler, ErrorHandler errorHandler) {
        this.userService = userService;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
    }

    @GetMapping()
    public ApiResponse getListUsers(@RequestParam(name = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
                                    @RequestParam(name = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        long took = System.currentTimeMillis();
        try {
            Pageable pageable = PaginationUntil.validatePagination(page,size,"");
            PagingRes pagingRes = this.userService.listUsers(pageable);
            return this.successHandler.handlerSuccess(pagingRes, took);
        } catch (Exception ex) {
            return this.errorHandler.handlerError(ex, took);
        }
    }
}
