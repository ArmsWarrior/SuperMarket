package cn.tarena.ht.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserInfoService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private RoleService roleService;
	
	
	
	@RequestMapping("/list")
	public String userList(Model model){
		List<User> users=userService.findAll();
		model.addAttribute("users",users );
		return "/sysadmin/user/jUserList";
	}
	
	@RequestMapping("/stop")
	public String stop(@RequestParam(value="userId",required=false)String[] userIds){
		if(userIds!=null){
			userService.changeState(0,userIds);
		}
		return "redirect:/sysadmin/user/list";
	}
	@RequestMapping("/start")
	public String start(@RequestParam(value="userId",required=false)String[] userIds){
		if(userIds!=null){
			userService.changeState(1,userIds);
		}
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="userId",required=false)String[] userIds){
		if(userIds!=null){
			//当删除user_p表时，userInfo也要同时删除
			userService.delete(userIds);
		}
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/tocreate")
	public String create(Model model){
		model.addAttribute("users",userInfoService.findAll());
		model.addAttribute("depts",deptService.findAll());
		return "/sysadmin/user/create";
	}
	
	@RequestMapping("/save")
	public String save(User user){
		
		userService.save(user);
		return "redirect:/sysadmin/user/list";
	}
	@RequestMapping("/toupdate")
	public String update(String userId,Model model){
		model.addAttribute("user",userService.findOne(userId));
		model.addAttribute("users",userInfoService.findAll());
		model.addAttribute("depts",deptService.findAll());
		return "/sysadmin/user/update";
	}
	@RequestMapping("/update")
	public String refresh(User user){
		
		userService.update(user);
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("/toview")
	public String view(String userId,Model model){
		model.addAttribute("user", userService.findOne(userId));
//		model.addAttribute("users",userService.findAll());
//		model.addAttribute("dept", deptService.findAll());
		return "/sysadmin/user/view";
	}
	
	@RequestMapping("/role")
	public String role(String userId,Model model) throws JsonProcessingException{
		
		//得到传递过来的用户对应的所有角色
		List<String> userRoles=userService.findRoles(userId);
		//获取所有的角色
		List<Role> roles=roleService.findAll();
		//遍历所有角色，如果是用户拥有的则让checked=true
		for(Role role:roles){
			if(userRoles.contains(role.getRoleId())){
					role.setChecked(true);
			}
		}
		//把对象转化成json字符串依赖于get方法
		ObjectMapper mapper=new ObjectMapper();
		String jsonString=mapper.writeValueAsString(roles);
		//将字符串传过去
		model.addAttribute("zTreeJson",jsonString);
		
		model.addAttribute("id", userId);
		
		return "/sysadmin/user/role";
	}
	
	@RequestMapping("/saveUserRole")
	public String role(String userId,String[] roleIds){
		//保存用户角色关系到中间关系表中
		if(userId!=null&&userId!=""&&roleIds!=null){
			userService.saveUserAndRole(userId,roleIds);
		}
		return "redirect:/sysadmin/user/list";
	}
}
