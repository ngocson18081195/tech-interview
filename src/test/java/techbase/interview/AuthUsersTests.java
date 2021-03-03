package techbase.interview;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import techbase.interview.common.ApiResponse;
import techbase.interview.controller.AuthController;
import techbase.interview.controller.UserController;
import techbase.interview.payload.request.LoginRequest;
import techbase.interview.payload.response.LoginRes;
import techbase.interview.payload.response.PagingRes;
import techbase.interview.util.ObjectMapperUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Description:
 * The string util class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/3/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/3/2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthUsersTests {

    @InjectMocks
    @Autowired
    private AuthController authController;

    @InjectMocks
    @Autowired
    private UserController userController;

    @Test
    public void testLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("sonnn");
        loginRequest.setPassword("sonnn@123");
        ApiResponse apiResponse = this.authController.authenticateUser(loginRequest);
        LoginRes loginRes = ObjectMapperUtils.map(apiResponse.getData(), LoginRes.class);
        Assert.assertNotNull("Not null", loginRes.getAccessToken());
    }

    @Test
    public void testListUser() {
        ApiResponse listUsers = this.userController.getListUsers(1, 10);
        PagingRes pagingRes = ObjectMapperUtils.map(listUsers.getData(), PagingRes.class);
        Assert.assertNotNull("Not null", pagingRes.getDataList());
        Assert.assertNotEquals(0, pagingRes.getDataList().size());
        Assert.assertNotEquals(0, pagingRes.getTotal());
    }
}
