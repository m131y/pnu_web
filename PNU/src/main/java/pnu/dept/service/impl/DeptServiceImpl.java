package pnu.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnu.dept.dao.DeptDAO;
import pnu.dept.service.DeptService;
import pnu.dept.vo.DeptVO;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDAO deptDAO;
	
	
	@Override
	public List<DeptVO> selectDeptList() {
		return deptDAO.selectDeptList();
	}

}
