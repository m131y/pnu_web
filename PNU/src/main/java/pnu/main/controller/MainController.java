package pnu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pnu.user.service.UserService;
import pnu.user.vo.UserVO; 

@Controller
public class MainController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/main.do", method = RequestMethod.GET)
	public String mainPage() {
		return "main.jsp";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVO user) {
		
		String userId = user.getUserId();
		String pwd = user.getPwd();
		
		if(userService.selectPwd(userId, pwd)) {
			return "main.jsp";
		} else {
			return "login.jsp"; 
		}
		
		
	}
	
	@RequestMapping(value="/loginPage.do", method = RequestMethod.GET)
	public String loginPage() {
		return "login.jsp";
	}
	
	
}
