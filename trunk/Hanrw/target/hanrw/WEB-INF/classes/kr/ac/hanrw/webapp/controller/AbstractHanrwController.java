package kr.ac.hanrw.webapp.controller;

import kr.ac.hanrw.webapp.common.LoginUserThreadLocal;
import kr.ac.hanrw.webapp.dto.HanrwError;
import kr.ac.hanrw.webapp.dto.User;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 8. 30
 * Time: 오후 2:42
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractHanrwController {

    protected ObjectMapper mapper;

    public AbstractHanrwController() {
        super();
        this.mapper = new ObjectMapper();
    }

    public void ErrorHandler(HanrwError error, HttpServletResponse res, int httpStatusCode) throws JsonGenerationException, JsonMappingException, IOException {
        res.setStatus(httpStatusCode);

        String payload = null;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writeValue(out,error);
        payload = out.toString("UTF-8");

        ServletOutputStream os = res.getOutputStream();
        os.write(payload.getBytes("UTF-8"));
        res.setContentLength(payload.getBytes("UTF-8").length);
        res.setContentType("application/json");
        res.setHeader("Content-Type", "application/json");
        res.setContentType("application/json");
        res.flushBuffer();
        return;
    }

    public String getLoginId()
    {
        User user = LoginUserThreadLocal.get();
        if ( user == null) {
            return null;
        }else {
            return user.getUserId();
        }
    }



    public User getLoginUser()
    {
        return LoginUserThreadLocal.get();
    }
}
