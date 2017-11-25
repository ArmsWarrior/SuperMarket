package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.tarena.ht.pojo.Role;


public interface RoleMapper {
	
//	@Select mybatis的注解形式——会自动把数据封装成返回值的类型
//	@Insert 一般单表的增删改查可以使用，如果使用注解，需要把mapper里面的sql去掉
//	@Update
//	@Delete
	
	@Select("select * from role_p order by order_no")
	public List<Role> findAll();
	
	public void delete(String[] roleIds);
	@Insert("insert into role_p (role_id,name,remarks,order_no,create_time) values (#{roleId},#{name},#{remarks},#{orderNo},#{createTime})")
	public void save(Role role);
	
	public Role findOne(String roleId);
	
	@Update("update role_p set name=#{name},remarks=#{remarks},order_no=#{orderNo} where role_id=#{roleId}")
	public void update(Role role);

	public void saveModuleRole(@Param("roleId")String roleId, @Param("moduleIds")String[] moduleIds);
	
	@Select("select module_id from role_module_p where role_id=#{roleId}")
	public List<String> findModuleIds(String roleId);
	@Delete("delete from role_module_p where role_id=#{roleId}")
	public void deleteModuleRole(String roleId);
	
	
	public void deleteByUserId(String[] userIds);

	public void deleteByRoleId(String[] roleIds);

	public void deleteModuleByRoleId(String[] roleIds);

}
