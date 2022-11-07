package pnu.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pnu.dept.service.DeptService;
import pnu.dept.vo.DeptVO;
import pnu.user.service.UserService;
import pnu.user.vo.UserVO;

import java.util.List;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	DeptService deptService;
	
	@RequestMapping(value="/signUpPage.do", method = RequestMethod.GET)
	public ModelAndView signUpPage() {
		ModelAndView mav = new ModelAndView("user/signUp.jsp");
		List<DeptVO> dept = deptService.selectDeptList();
		mav.addObject("dept", dept);
		
		return mav;
		
	}
	
	@RequestMapping(value="/signUp.do", method = RequestMethod.POST)
	public String signUp(@ModelAttribute UserVO user) {
		
		userService.insertUser(user);
		
		return "redirect:/loginPage.do";
		
	}
}
