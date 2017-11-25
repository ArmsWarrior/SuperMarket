package cn.tarena.ht.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;


@Controller
public class LogController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/tologin")
	public String tologin(){
		return "sysadmin/login/login";
	}
	
//	@RequestMapping("/login")
//	public String login(Model model,String username,String password,HttpSession session){
//		
//		if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
//			model.addAttribute("errorInfo", "用户名密码不能为空");
//			return "sysadmin/login/login";
//		}
//		
//		User user=userService.login(username,password);
//		if(user==null){
//			model.addAttribute("errorInfo", "用户名密码不正确");
//			return "sysadmin/login/login";
//		}
//		//把登录信息放入session域中
//		session.setAttribute("_CURRENT_USER", user);
//		
//		//登陆成功跳转到首页
//		return "redirect:/home";
//	}
//	
	@RequestMapping("logout")
	public String loginout(HttpSession session){
		session.removeAttribute("_CURRENT_USER");
		//退出需要通知shiro管理器
		Subject subject =SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			subject.logout();
		}
		return "sysadmin/login/logout";
	}
	//shiro框架进行登录校验操作
	///1.导入jar包，创建shiro配置文件
	
	@RequestMapping("login")
	public String logIn(Model model,String username,String password,HttpSession session){
		//获取subject对象
		Subject subject=SecurityUtils.getSubject();
		//创建一个用户名和密码的令牌
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
			//得到正确的用户
			User user=(User) subject.getPrincipal();
			session.setAttribute("_CURRENT_USER", user);
			//登录成功跳转到首页
			return "redirect:/home";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorInfo", "用户名密码不正确");
			return "sysadmin/login/login";
		}
	}
}
