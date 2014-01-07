package kr.ac.hanrw.webapp.controller;

import kr.ac.hanrw.webapp.dto.AccessToken;
import kr.ac.hanrw.webapp.dto.HanrwError;
import kr.ac.hanrw.webapp.dto.SearchCondition;
import kr.ac.hanrw.webapp.dto.User;
import kr.ac.hanrw.webapp.service.UserService;
import org.codehaus.jackson.JsonGenerationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 8. 30
 * Time: 오후 2:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController extends AbstractHanrwController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/view/user/login")
    public String login(HttpServletResponse response) {
        return "user/login";
    }

    @RequestMapping(value = "/view/user", method = RequestMethod.GET)
    public String list(HttpServletResponse response) {
        return "user/list";
    }

    @RequestMapping(value = "/app/user/regist", method = RequestMethod.POST)
    @ResponseBody
    public AccessToken regist(@RequestBody User user, HttpServletResponse response) throws IOException {
        AccessToken accessToken = new AccessToken();
        try {
            accessToken = userService.registUser(user);
        } catch (Exception e) {
            HanrwError error = new HanrwError();
            error.setErrorCode(HanrwError.ERROR_WRONG_PARAM);
            error.setErrorMessage("회원등록에 실패하였습니다.");
            super.ErrorHandler(error, response, HttpStatus.NOT_FOUND.value());
            e.printStackTrace();
            return null;

        }
        return accessToken;
    }

    @RequestMapping(value = "/app/user/login", method = RequestMethod.POST)
    @ResponseBody
    public AccessToken login(@RequestBody User loginUser, HttpServletResponse response) throws IOException {
        String password = loginUser.getPassword();
        String loginUserId = loginUser.getUserId();
        User savedUser = null;
        User reqUser = new User();
        reqUser.setUserId(loginUserId);
        reqUser.setPassword(password);

        //boolean isSucc = userService.loginUser(reqUser);
        savedUser = userService.getUserBy(reqUser.getUserId());

        if (savedUser != null) {
            if (userService.loginUser(reqUser)) {
                return userService.genAccessToken(savedUser);
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                HanrwError error = new HanrwError();
                error.setErrorCode(HanrwError.ERROR_INVALID_PASSWORD);
                error.setErrorMessage("잘못된 패스워드입니다.");
                super.ErrorHandler(error, response, HttpStatus.NOT_FOUND.value());
                return null;
            }
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            HanrwError error = new HanrwError();
            error.setErrorCode(HanrwError.ERROR_USER_NOT_EXIST);
            error.setErrorMessage(loginUserId + " 은(는) 존재하지 않습니다. 회원 가입후 사용하세요.");
            super.ErrorHandler(error, response, HttpStatus.NOT_FOUND.value());
            return null;
        }

    }

    @RequestMapping(value = "/app/user/{userId:.+}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable String userId, HttpServletResponse response) {
        String loginUserId = super.getLoginId();
        if (!loginUserId.equals(userId)) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
        }
        User user = userService.getUserBy(userId);
        return user;
    }

    @RequestMapping(value = "/app/user/list", method = RequestMethod.GET)
    @ResponseBody
    public List<User> list(HttpServletRequest request, HttpServletResponse response) {
        String qPage = request.getParameter("page");
        String qPageSize = request.getParameter("pageSize");
        String qColumn = request.getParameter("column");
        String qQstr = request.getParameter("qstr");
        int page = qPage.isEmpty() ? 1 : Integer.parseInt(qPage);
        int pageSize = qPageSize.isEmpty() ? 10 : Integer.parseInt(qPageSize);

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setColumn(qColumn);
        searchCondition.setQueryString(qQstr);
        searchCondition.setLimitStart((page - 1) * pageSize);
        searchCondition.setLimitEnd(pageSize);

        List<User> userList = userService.getUserList(searchCondition);
        return userList;
    }

    @RequestMapping(value="/app/user/list/total", method=RequestMethod.GET)
    @ResponseBody
    public int getUserTotalCnt(HttpServletRequest request, HttpServletResponse response) {
        String qColumn = request.getParameter("column");
        String qQstr = request.getParameter("qstr");

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setColumn(qColumn);
        searchCondition.setQueryString(qQstr);

        return userService.getUserTotalCnt(searchCondition);
    }

    @RequestMapping(value = "/app/user/update", method = RequestMethod.POST)
    public void update(@RequestBody User user, HttpServletResponse response) throws IOException {
        try {
            userService.updateUser(user);
            response.setStatus(HttpStatus.OK.value());

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.NOT_FOUND.value());
            HanrwError error = new HanrwError();
            error.setErrorCode(HanrwError.ERROR_WRONG_PARAM);
            error.setErrorMessage("사용자 정보를 수정하지 못하였습니다.");
            super.ErrorHandler(error, response, HttpStatus.BAD_REQUEST.value());
        }
    }

    @RequestMapping(value = "/app/user/delete", method = RequestMethod.GET)
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            User user = userService.getUserBy(super.getLoginId());
            String userIDs = request.getParameter("userIDs");

            if (user.getRoleId().equals("ADMIN")) {
                userService.deleteUsers(userIDs);
                response.setStatus(HttpStatus.OK.value());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                HanrwError error = new HanrwError();
                error.setErrorCode(HanrwError.ERROR_SUCCESS);
                error.setErrorMessage("사용권한이 없습니다.");
                super.ErrorHandler(error, response, HttpStatus.BAD_REQUEST.value());
            }

        } catch (Exception e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            HanrwError error = new HanrwError();
            error.setErrorCode(HanrwError.ERROR_SUCCESS);
            error.setErrorMessage("사용자 정보를 삭제하지 못하였습니다.");
            super.ErrorHandler(error, response, HttpStatus.BAD_REQUEST.value());
        }
    }
}

