package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.User;

public interface UserService {
	public List<User> findAll();

	public void changeState(int i, String[] userIds);

	public void delete(String[] userIds);

	public void save(User user);

	public User findOne(String userId);

	public void update(User user);

	public void saveUserAndRole(String userId, String[] roleIds);

	public List<String> findRoles(String userId);

	public User login(String username, String password);

	public User findByUsername(String username);

	public List<String> findModuleById(String userId);

}
