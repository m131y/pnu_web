package pnu.user.dao.impl;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import pnu.user.dao.UserDAO;
import pnu.user.vo.UserVO;

@Repository
public class UserDAOImpl extends EgovAbstractMapper implements UserDAO {
	
	@Override
	public String selectPwd(String userId) {
		return selectOne("User.selectPwd", userId);
	}

	@Override
	public int insertUser(UserVO user) {
		return insert("User.insertUser", user);
	}

	@Override
	public UserVO selectUserInfo(String userId) {
		return selectOne("User.selectUserInfo", userId);
	}

	@Override
	public int updateUser(UserVO user) {
		return update("User.updateUser", user);
	}
	
}
