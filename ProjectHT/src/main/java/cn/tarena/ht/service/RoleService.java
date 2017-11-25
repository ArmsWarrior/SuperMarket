package cn.tarena.ht.service;

import java.util.List;


import cn.tarena.ht.pojo.Role;

public interface RoleService {
	public List<Role> findAll();

	public void delete(String[] roleIds);

	public void save(Role role);

	public Role findOne(String roleId);

	public void update(Role role);

	public void saveModuleRole(String roleId, String[] moduleIds);

	public List<String> findModuleIds(String roleId);
}
