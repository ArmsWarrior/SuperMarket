package cn.tarena.ht.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

//自定义的加密匹配器
public class AuthCredentialMatcher extends SimpleCredentialsMatcher{
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		// TODO Auto-generated method stub
		//如果自己的密码有加密过程，要对自己的密码加密
//		UsernamePasswordToken loginToken=(UsernamePasswordToken)token;
//		String password=String.valueOf(loginToken.getPassword());
//		password=md5Utils.getMd5(password,loginToken.getUsername());
//		loginToken.setPassword(password.toCharArray());
		return super.doCredentialsMatch(token, info);
	}
}
