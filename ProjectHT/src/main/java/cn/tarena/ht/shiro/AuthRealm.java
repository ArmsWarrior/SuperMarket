package cn.tarena.ht.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

@Component
//shiro的原材料
public class AuthRealm extends SimpleAccountRealm{
	@Autowired
	private UserService userService;
	//登陆证明
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//提供正确的登录信息
		//得到用户名
		UsernamePasswordToken loginToken=(UsernamePasswordToken)token;
		//给info准备信息
		//得到正确的用户信息
		User user=userService.findByUsername(loginToken.getUsername());
		/**
		 * principals：代表正确的对象
		 * credentials：代表正确的密码
		 * realmName:原材料对象的名字
		 */
		AuthenticationInfo info=new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
	
		return info;
	}
	//权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//准备当前登录用户的权限列表
//		List<String> privileges=new ArrayList<String>();
//		privileges.add("货运管理");
//		privileges.add("基础信息");
//		privileges.add("系统管理");
		User user=(User) principals.getPrimaryPrincipal();
		List<String> privileges=userService.findModuleById(user.getUserId());
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addStringPermissions(privileges);
		return super.doGetAuthorizationInfo(principals);
	}
}
