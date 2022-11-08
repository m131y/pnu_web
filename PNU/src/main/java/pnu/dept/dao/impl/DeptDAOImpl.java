package pnu.dept.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import pnu.dept.dao.DeptDAO;
import pnu.dept.vo.DeptVO;

@Repository
public class DeptDAOImpl extends EgovAbstractMapper implements DeptDAO {

	@Override
	public List<DeptVO> selectDeptList() {
		return selectList("Dept.selectDeptList");
	}

}
