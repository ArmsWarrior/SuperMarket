package cn.tarena.ht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("list")
	public String findAll(Model model){
		model.addAttribute("modules",moduleService.findAll());
		return "/sysadmin/module/jModuleList";
	}
	
	@RequestMapping("/stop")
	public String stop(@RequestParam(value="moduleId",required=false)String[] moduleIds){
		if(moduleIds!=null){
			moduleService.changeState(0,moduleIds);
		}
		return "redirect:/sysadmin/module/list";
	}
	@RequestMapping("/start")
	public String start(@RequestParam(value="moduleId",required=false)String[] moduleIds){
		if(moduleIds!=null){
			moduleService.changeState(1,moduleIds);
		}
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="moduleId",required=false)String[] moduleIds){
		if(moduleIds!=null){
			moduleService.delete(moduleIds);
		}
		return "redirect:/sysadmin/module/list";
	}
	@RequestMapping("/tocreate")	
	public String create(Model model){
		model.addAttribute("modules", moduleService.findAll());
		return "/sysadmin/module/create";
	}
	
	@RequestMapping("/save")
	public String save(Module module){
		moduleService.save(module);
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("/toupdate")
	public String toUpdate(String moduleId,Model model){
		if(moduleId!=null&&moduleId!=""){
			model.addAttribute("module", moduleService.findOne(moduleId));
			
		}
		model.addAttribute("modules",moduleService.findAll());
		return "/sysadmin/module/update";
	}
	
	@RequestMapping("/update")
	public String update(Module module){
		moduleService.update(module);
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("/toview")
	public String view(String moduleId,Model model){
		model.addAttribute("module",moduleService.findOne(moduleId) );
		return "sysadmin/module/view";
	}
	
}
