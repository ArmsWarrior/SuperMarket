package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.pojo.UserInfo;
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		return userInfoMapper.findAll();
	}

}
