package kr.ac.hanrw.webapp.interceptor;

import kr.ac.hanrw.webapp.common.AccessTokenHandler;
import kr.ac.hanrw.webapp.dto.AccessToken;
import kr.ac.hanrw.webapp.dto.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 9. 14.
 * Time: 오후 1:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("AuthInterceptorTest-context.xml")
public class AuthInterceptorTest {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }


    @Test
    public void testNoAuthAjaxPreHandle() throws Exception {

        /*
         인증이 필요없는 페이지 테스트
         로그인 페이지와 사용자 등록 페이지는 로그인 필요없으므로 요청시 200 OK 나와야 함
         */
        mockMvc.perform(post("/app/user/login")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        String message = "{\"password\":\"12345\",\"userId\":\"yhlee\"}";

                        try {
                            req.setMethod("POST");
                            req.setRequestURI("/app/user/login");
                            req.setContent(message.getBytes("UTF-8"));
                            req.addHeader("Content-Type", "application/json");
                            req.addHeader("Content-Length", message.getBytes("UTF-8").length);
                        } catch (UnsupportedEncodingException e) {
                            return null;
                        }
                        return req;
                    }
                }))
                .andExpect(status().isOk());

        mockMvc.perform(post("/app/user/regist")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        String message = "{\"password\":\"12345\",\"userId\":\"yhlee\"}";

                        try {
                            req.setMethod("POST");
                            req.setRequestURI("/app/user/regist");
                            req.setContent(message.getBytes("UTF-8"));
                            req.addHeader("Content-Type", "application/json");
                            req.addHeader("Content-Length", message.getBytes("UTF-8").length);
                        } catch (UnsupportedEncodingException e) {
                            return null;
                        }
                        return req;
                    }
                }))
                .andExpect(status().isOk());
    }

    @Test
    public void testAuthAjaxPreHandle() throws Exception {
        mockMvc.perform(get("/app/user/yhlee"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testAuthAjaxWithTokenPreHandle() throws Exception {
        mockMvc.perform(post("/app/user/update")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        String message = "{\"password\":\"12345\",\"userId\":\"yhlee\"}";

                        try {
                            req.setMethod("POST");
                            req.addHeader("access_token", "dummytoken");
                            req.setRequestURI("/app/user/regist");
                            req.setContent(message.getBytes("UTF-8"));
                            req.addHeader("Content-Type", "application/json");
                            req.addHeader("Content-Length", message.getBytes("UTF-8").length);
                        } catch (UnsupportedEncodingException e) {
                            return null;
                        }
                        return req;
                    }
                }))
                .andExpect(status().isOk());

    }

    @Test
    public void testNoAuthViewPreHandle() throws Exception {
        mockMvc.perform(get("/view/user/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("/view/user/login"));
    }

    @Test
    public void testAuthViewPreHandle() throws Exception {
        mockMvc.perform(get("/view/user/list"))
                .andExpect(status().isMovedTemporarily());

    }

    @Test
    public void testAuthViewWithTokenPreHandle() throws Exception {


        mockMvc.perform(get("/view/user/list")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        String token = null;
                        User user = new User();
                        user.setUserId("yhlee");
                        user.setEmail("yhlee@gmail.com");
                        user.setPassword("password");

                        AccessToken ac = AccessTokenHandler.generate(user);
                        token = ac.getAccessToken();

                        req.setMethod("GET");
                        req.setCookies(new Cookie("access_token", token));
                        req.addHeader("access_token", "dummytoken");
                        req.setRequestURI("/view/user/list");
                        return req;
                    }
                }))
                .andExpect(status().isOk())
                .andExpect(view().name("/view/user/list"));
    }

    @Test
    public void testAfterCompletion() throws Exception {

    }
}
