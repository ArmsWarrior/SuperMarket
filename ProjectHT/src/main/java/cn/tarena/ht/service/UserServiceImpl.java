package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoMapper userInfoMapper; 
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

	@Override
	public void changeState(int i,String[] userIds) {
		// TODO Auto-generated method stub
		userMapper.changeState(i,userIds);
	}

	@Override
	public void delete(String[] userIds) {
		// TODO Auto-generated method stub
		userMapper.delete(userIds);
		//在业务层添加方法以便回滚操作
		userInfoMapper.delete(userIds);
		//删除用户和角色的关联关系
		roleMapper.deleteByUserId(userIds);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		String userId=UUID.randomUUID().toString();
		user.setUserId(userId);
		UserInfo userInfo=user.getUserInfo();
		userInfo.setUserInfoId(userId);
		Date date=new Date();
		user.setCreateTime(date);
		//保存用户表数据
		userMapper.save(user);
		//保存扩展表信息
		userInfoMapper.save(user.getUserInfo());
	}

	@Override
	public User findOne(String userId) {
		// TODO Auto-generated method stub
		return userMapper.findOne(userId);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
		userInfoMapper.update(user.getUserInfo());
	}

	@Override
	public void saveUserAndRole(String userId, String[] roleIds) {
		// TODO Auto-generated method stub
		userMapper.deleteRoles(userId);
		if(roleIds.length>0){
			userMapper.saveUserAndRole(userId,roleIds);
		}
	}

	@Override
	public List<String> findRoles(String userId) {
		// TODO Auto-generated method stub
		return userMapper.findRoles(userId);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userMapper.login(username,password);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByUsername(username);
	}

	@Override
	public List<String> findModuleById(String userId) {
		return userMapper.findModuleById(userId);
	}
	

}
