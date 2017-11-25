package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;

@Controller
@RequestMapping("/sysadmin/role")
public class RoleController extends BaseController{
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		model.addAttribute("roles",roleService.findAll());
		return "/sysadmin/role/jRoleList";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="roleId",required=false)String[] roleIds,Model model){
		if(roleIds!=null){
			roleService.delete(roleIds);
		}
		return "redirect:/sysadmin/role/list";
	}
	
	@RequestMapping("/tocreate")
	public String create(){
		return "/sysadmin/role/create";
	}
	@RequestMapping("/save")
	public String save(Role role){
		roleService.save(role);
		return "redirect:/sysadmin/role/list";
	}
	@RequestMapping("/toview")
	public String view(Model model,String roleId){
		model.addAttribute("role",roleService.findOne(roleId));
		return "/sysadmin/role/view";
	}
	@RequestMapping("/toupdate")
	public String update(Model model,String roleId){
		model.addAttribute("role",roleService.findOne(roleId));
		return "/sysadmin/role/update";
	}
	@RequestMapping("/update")
	public String toUpdate(Role role){
		roleService.update(role);
		return "redirect:/sysadmin/role/list";
	}
	@RequestMapping("/module")
	public String module(Model model, String roleId) throws JsonProcessingException{
		if(roleId!=null&&roleId!=""){
			List<String> roleModuleIds=roleService.findModuleIds(roleId);
			List<Module> modules=moduleService.findAll();
			for(Module module:modules){
				if(roleModuleIds.contains(module.getModuleId())){
					module.setChecked(true);
				}
			}
			ObjectMapper mapper=new ObjectMapper();
			String jsonTree=mapper.writeValueAsString(modules);
			
			model.addAttribute("id", roleId);
			model.addAttribute("zTreeJson", jsonTree);
			return "sysadmin/role/module";
		}else{
			return "redirect:/sysadmin/role/list";
		}
	}
	@RequestMapping("/saveModuleRole")
	public String saveModuleRole(String roleId,String[] moduleIds){
		roleService.saveModuleRole(roleId,moduleIds);
		return "redirect:/sysadmin/role/list";
	}
	
}
