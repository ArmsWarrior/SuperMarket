package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		
		return roleMapper.findAll();
	}

	@Override
	public void delete(String[] roleIds) {
		// TODO Auto-generated method stub
		roleMapper.delete(roleIds);
		//删除角色和用户关联关系表中数据
		roleMapper.deleteByRoleId(roleIds);
		//删除角色和模块的关系表中数据
		roleMapper.deleteModuleByRoleId(roleIds);
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		role.setRoleId(UUID.randomUUID().toString());
		Date date=new Date();
		role.setCreateTime(date);
		roleMapper.save(role);
	}

	@Override
	public Role findOne(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.findOne(roleId);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleMapper.update(role);
	}

	@Override
	public void saveModuleRole(String roleId, String[] moduleIds) {
		roleMapper.deleteModuleRole(roleId);
		if(moduleIds.length>0){
			roleMapper.saveModuleRole(roleId,moduleIds);
		}
	}

	@Override
	public List<String> findModuleIds(String roleId) {
		// TODO Auto-generated method stub
		return roleMapper.findModuleIds(roleId);
	}
	
}
