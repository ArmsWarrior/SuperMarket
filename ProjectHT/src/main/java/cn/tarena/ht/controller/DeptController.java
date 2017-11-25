package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller("deptController")
@RequestMapping("/sysadmin/dept")//部门管理统一前置路径提取
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/list")
	public String deptList(Model model){
		model.addAttribute("deptList", deptService.findAll());
		return "sysadmin/dept/jDeptList";
	}
	
	
	//单个启用的操作
//	@RequestMapping("/sysadmin/dept/stop")
//	public String stopAction(String deptId){
//		deptService.changeState(0,deptId);
//		//继续显示当前页面
//		//通过重定向来访问
//		return "redirect:/sysadmin/dept/list";
//	}
	@RequestMapping("/stop")
	public String stopAction(@RequestParam(value="deptId",required=false)String[] deptIds){
		if(deptIds!=null){
			
			deptService.changeState(0,deptIds);
		}
		//继续显示当前页面
		//通过重定向来访问
		return "redirect:/sysadmin/dept/list";
	}
	@RequestMapping("/start")
	public String startAction(@RequestParam(value="deptId",required=false)String[] deptIds){
		if(deptIds!=null){
			
			deptService.changeState(1,deptIds);
		}
		
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/delete")
	public String deleteAction(@RequestParam(value="deptId",required=false)String[] deptIds){
		if(deptIds!=null){
			
			deptService.deleteDept(deptIds);
		}
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/tocreate")
	public String createDept(Model model){
		model.addAttribute("depts", deptService.findAll());
		return "/sysadmin/dept/create";
	}
	@RequestMapping("/save")
	public String saveDept(Dept dept){
		deptService.saveDept(dept);
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("/toview")
	public String searchDept(String deptId,Model model){
		if(deptId!=null){
			model.addAttribute("depts",deptService.viewDept(deptId));
		}
		return "sysadmin/dept/view";
	}
	@RequestMapping("/toupdate")
	public String updateDept(String deptId,Model model){
		Dept dept=deptService.viewDept(deptId);
		//为了下拉列表查询所有的部门
		List<Dept> depts=deptService.findAll();
		model.addAttribute("dept", dept);
		model.addAttribute("depts", depts);
		return "sysadmin/dept/update";
	}
	@RequestMapping("/update")
	public String updateDept(Dept dept){
		deptService.updateDept(dept);
		return "redirect:/sysadmin/dept/list";
	}
	
	
}
