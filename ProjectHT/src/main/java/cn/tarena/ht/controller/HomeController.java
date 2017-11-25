package cn.tarena.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	
	
	//转向欢迎页面
	@RequestMapping("/home")
	public String home(){
		return "/home/fmain";
	}
	
	//转向tilte标题栏页面
	@RequestMapping("/title")
	public String title(){
		return "/home/title";
	}
	
	//转向home的左侧页面
	@RequestMapping("/homeLeft")
	public String homeLeft(){
		return "/home/left";
	}
	
	//转向home的操作页面
	@RequestMapping("/homeMain")
	public String homeMain(){
		return "/home/main";
	}
	
	
	//RestFul通过地址传递参数的一种方式,利用这种方式可以减少重复代码
	@RequestMapping("/{model}/Left")
	public String Left(@PathVariable String model){
		return "/"+model+"/left";
	}
	
	@RequestMapping("/{model}/Main")
	public String sysadminMain(@PathVariable String model){
		return "/"+model+"/main";
	}
	
//	@RequestMapping("/baseinfoLeft")
//	public String baseinfoLeft(){
//		return "/baseinfo/left";
//	}
//	
//	@RequestMapping("/baseinfoMain")
//	public String baseinfoMain(){
//		return "/baseinfo/main";
//	}
//	@RequestMapping("/cargoLeft")
//	public String cargoLeft(){
//		return "/cargo/left";
//	}
//	
//	@RequestMapping("/cargoMain")
//	public String cargoMain(){
//		return "/cargo/main";
//	}
	
	
}
