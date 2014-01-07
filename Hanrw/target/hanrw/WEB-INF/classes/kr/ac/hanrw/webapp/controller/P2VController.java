package kr.ac.hanrw.webapp.controller;

import kr.ac.hanrw.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: ndevelop
 * Date: 13. 8. 30
 * Time: 오후 2:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class P2VController extends AbstractHanrwController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/view/p2v/list", method=RequestMethod.GET)
    public String login(HttpServletResponse response) {
        return "p2v/list";
    }

    @RequestMapping(value="/view/p2v/view", method=RequestMethod.GET)
    public String view(HttpServletResponse response){
        return "p2v/view";
    }

    @RequestMapping(value="/view/p2v/write", method=RequestMethod.GET)
    public String write(HttpServletResponse response){
        return "p2v/write";
    }

}
