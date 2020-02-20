package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello") //http://localhost:8088/hellospring/hello
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2") // http://localhost:8088/hellospring/hello2
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}
	
	@RequestMapping("/hello3") // http://localhost:8088/hellospring/hello3
	public ModelAndView hello3(String name) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name",name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		//mav.getModelMap()=>웹에서 이걸로 자동으로 푼다(?) 
		return mav;
	}
	
	@RequestMapping("/hello4") // http://localhost:8088/hellospring/hello4
	public String hello4(String name,Model model) {
		model.addAttribute("name",name);
		return "/WEB-INF/views/hello4.jsp";
	}		
}
