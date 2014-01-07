package kr.ac.hanrw.webapp.controller;

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

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 9. 14
 * Time: 오후 6:35
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("UserControllerTests-context.xml")
public class UserControllerTests {
    MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }
    @Test
    public void testRegistUser() throws Exception {
        mockMvc.perform(post("/app/user/regist")
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest req) {
                        String message = "{\"password\":\"12345\",\"userId\":\"testid1\"}";

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

    /*
    @Test
    public void testgetUserBy() throws Exception {
        mockMvc.perform(get("/app/user/testid")).andExpect(status().isUnauthorized());
    }
    */
}
