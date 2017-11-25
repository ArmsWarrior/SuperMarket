package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.Dept;

@Service("DeptService")
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptMapper mapper;
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public void changeState(int i, String[] deptIds) {
		// TODO Auto-generated method stub
		mapper.changeState(i,deptIds);
	}

	@Override
	public void deleteDept(String[] deptIds) {
		userMapper.deleteDept(deptIds);
		mapper.deleteDept(deptIds);
		
	}

	@Override
	public void saveDept(Dept dept) {
		// TODO Auto-generated method stub
		mapper.saveDept(dept);
	}

	@Override
	public Dept viewDept(String deptId) {
		// TODO Auto-generated method stub
		return mapper.viewDept(deptId);
	}

	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		mapper.updateDept(dept);
	}

}
