package kr.ac.hanrw.webapp.interceptor;

import kr.ac.hanrw.webapp.common.AccessTokenHandler;
import kr.ac.hanrw.webapp.common.LoginUserThreadLocal;
import kr.ac.hanrw.webapp.dto.AccessToken;
import kr.ac.hanrw.webapp.dto.HttpErrorObject;
import kr.ac.hanrw.webapp.dto.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yhlee
 * Date: 13. 8. 30
 * Time: 오후 2:22
 */
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);


    @Value("#{T(java.util.Arrays).asList(authUrlFilter['url.noauth'])}")
    private List<String> EXCEPTOPN_URI_LIST;

    @Value("#{authUrlFilter['req.ajax']}")
    private String REQ_AJAX_URL;

    @Value("#{authUrlFilter['req.view']}")
    private String REQ_VIEW_URL;

    @Value("#{authUrlFilter['redirect.login.url']}")
    private String LOGIN_URL;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        String reqUri = req.getRequestURI();

        logger.debug("AuthInterceptor PreHandle Process Start!");
        for(int i=0 ; i<EXCEPTOPN_URI_LIST.size();i++){
            if ( reqUri.contains(EXCEPTOPN_URI_LIST.get(i)) )
            {
                logger.info("[AuthInterceptor] Auth Exclude URL : " + reqUri);
                return true;
            }
        }

        String token = null;

        if (reqUri.contains(REQ_VIEW_URL)) {
            Cookie reqCookie = WebUtils.getCookie(req, "access_token");
            if (reqCookie != null) {
                token = reqCookie.getValue();
                token = URLDecoder.decode(token, "UTF-8");
            }
        }else {
            token = req.getHeader("access_token");
        }

        if (!StringUtils.hasText(token)) {
            if (reqUri.contains(REQ_AJAX_URL)) {
                logger.warn("[" + reqUri + " ] rejected");
                HttpErrorObject error = new HttpErrorObject();
                error.setErrorCode(HttpErrorObject.ERROR_USER_NOT_LOGIN);
                error.setErrorMessage("Invalid Access Token");

                res.setStatus(HttpStatus.UNAUTHORIZED.value());

                String payload = null;

                ObjectMapper mapper = new ObjectMapper();
                payload = mapper.writeValueAsString(error);

                ServletOutputStream os = res.getOutputStream();
                os.write(payload.getBytes("UTF-8"));
                res.setContentLength(payload.getBytes("UTF-8").length);
                res.setHeader("Content-Type", "application/json; charset=UTF-8");
                res.setContentType("application/json; charset=UTF-8");
                res.flushBuffer();
            }else {
                res.sendRedirect(LOGIN_URL);
            }
            return false;
        }

        try {
            User loginUser = new User();

            AccessToken at = new AccessToken();
            at.setAccessToken(token);

            loginUser = AccessTokenHandler.parseAccessToken(at);
            LoginUserThreadLocal.set(loginUser);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        LoginUserThreadLocal.unSet();
    }
}
