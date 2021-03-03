package techbase.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import techbase.interview.common.ApiResponse;
import techbase.interview.common.ErrorHandler;
import techbase.interview.common.SuccessHandler;
import techbase.interview.payload.request.LoginRequest;
import techbase.interview.payload.response.LoginRes;
import techbase.interview.service.UserService;

/**
 * Description:
 * The AuthController class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;
    private final SuccessHandler successHandler;
    private final ErrorHandler errorHandler;

    @Autowired
    public AuthController(UserService userService, SuccessHandler successHandler, ErrorHandler errorHandler) {
        this.userService = userService;
        this.successHandler = successHandler;
        this.errorHandler = errorHandler;
    }

    @PostMapping("/authentication")
    public ApiResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        long took = System.currentTimeMillis();
        try {
            LoginRes loginRes = this.userService.login(loginRequest);
            return successHandler.handlerSuccess(loginRes, took);
        }catch (Exception ex) {
            return errorHandler.handlerError(ex, took);
        }
    }

}
