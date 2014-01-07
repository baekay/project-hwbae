package kr.ac.hanrw.webapp.controller.Mock;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import kr.ac.hanrw.webapp.common.AccessTokenHandler;
import kr.ac.hanrw.webapp.dto.AccessToken;
import kr.ac.hanrw.webapp.dto.User;
import kr.ac.hanrw.webapp.service.UserService;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value="/app/user")
public class MockUserController{

	@RequestMapping(value="/{userId:.+}", method=RequestMethod.GET)
	@ResponseBody
	public User inquiry(@PathVariable String userId,HttpServletResponse res) throws JsonGenerationException, JsonMappingException, IOException
	{
        User user = new User();
        user.setUserId(userId);
        user.setEmail("yhlee@gmail.com");
        user.setTelNo("01052130417");

			
		return user;
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	@ResponseBody
	public AccessToken regist(@RequestBody User user, HttpServletResponse res) throws Exception, JsonMappingException, IOException
	{

		AccessToken token = new AccessToken();
        token = AccessTokenHandler.generate(user);
        return token;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public AccessToken login(@RequestBody User loginUser,HttpServletResponse res) throws IOException
	{
        AccessToken token = new AccessToken();
        token = AccessTokenHandler.generate(loginUser);
        return token;

	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public boolean update(@RequestBody User user,HttpServletResponse res) throws IOException
	{
        return true;
	}
}
