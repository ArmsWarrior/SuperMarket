package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {
	public List<Dept> findAll();
	//mapper默认只能传递一个参数，多个需要封装到对象或者map中
	//加入注解后会把参数自动封装到Map中
	public void changeState(@Param("state")int i, @Param("deptIds")String[] deptIds);
	public void deleteDept(String[] deptIds);
	public void saveDept(Dept dept);
	public Dept viewDept(String deptId);
	public void updateDept(Dept dept);
}
