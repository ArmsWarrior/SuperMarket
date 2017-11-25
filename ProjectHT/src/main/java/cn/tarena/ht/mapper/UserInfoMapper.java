package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoMapper {

	public void delete(String[] userIds);

	public List<UserInfo> findAll();

	public void save(UserInfo userInfo);

	public void update(UserInfo userInfo);

}
