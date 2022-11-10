package pnu.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value="/pwdConfirmPage.do", method = RequestMethod.GET)
	public String pwdConfirmPage() {
		return "user/pwdConfirm.jsp";
	}
	
	@RequestMapping(value="/userUpdatePage.do", method = RequestMethod.POST)
	public ModelAndView userUpdatePage(@ModelAttribute UserVO user) {
		if(userService.selectPwd(user.getUserId(), user.getPwd())) {
			ModelAndView mav = new ModelAndView("user/userUpdate.jsp");
			List<DeptVO> dept = deptService.selectDeptList();
			mav.addObject("dept", dept);
			
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("main.jsp");
			return mav;			
		}
	}
	
	@RequestMapping(value="/userUpdate.do", method = RequestMethod.POST)
	public String updateUser(HttpSession session, @ModelAttribute UserVO user) {
		userService.updateUser(user);
		userService.setSession(session, user.getUserId());
		
		return "main.jsp";
	}

	@RequestMapping(value="/userDelete.do")
	public String userDelete(HttpSession session) {
		UserVO userInfo = (UserVO) session.getAttribute("USER");
		
		userService.deleteUser(userInfo.getUserId());
		
		session.removeAttribute("USER");
		
		return "redirect:/loginPage.do";
	}
	
}
