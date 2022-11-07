package pnu.user.service.impl;

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
	public Boolean selectPwd(String userId, String pwd) {
		return pwd.equals(userDAO.selectPwd(userId));
	}

	@Override
	public int insertUser(UserVO user) {
		return userDAO.insertUser(user);
	}
}
