package pnu.user.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnu.user.dao.UserDAO;
import pnu.user.service.UserService;
import pnu.user.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public String selectUsed(String userId) {
		return userDAO.selectUsed(userId);
	}
	
	@Override
	public Boolean selectPwd(String userId, String pwd) {
		return pwd.equals(userDAO.selectPwd(userId));
	}

	@Override
	public int insertUser(UserVO user) {
		return userDAO.insertUser(user);
	}

	@Override
	public UserVO selectUserInfo(String userId) {
		return userDAO.selectUserInfo(userId);
	}

	@Override
	public Boolean setSession(HttpSession session, String userId) {
		UserVO userInfo = userDAO.selectUserInfo(userId);
		
		if(userInfo != null) {
			session.setAttribute("USER", userInfo);
		}
		
		return userInfo != null;
	}

	@Override
	public int updateUser(UserVO user) {
		return userDAO.updateUser(user);
	}

	@Override
	public int deleteUser(String userId) {
		return userDAO.deleteUser(userId);
	}

}
