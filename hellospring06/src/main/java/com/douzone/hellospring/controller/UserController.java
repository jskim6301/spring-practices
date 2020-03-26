package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.hellospring.vo.UserVO;

/*
 *  RequestMapping
 *  Class + Method
 * 
 */

@Controller
@RequestMapping("/user")
public class UserController {
	

	
	
//	@ResponseBody
	@RequestMapping(value= {"/join","/j"},method=RequestMethod.GET)  // http://localhost:8088/hellospring/user/join 또는 http://localhost:8088/hellospring/user/j
	public String join() {
		return "join";
	}	



	@ResponseBody
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute UserVO userVO) {
		System.out.println(userVO.getName());

		return "redirect:/main";
	}	

	
	
	@ResponseBody
	@RequestMapping(value="/update") //http://localhost:8088/hellospring/user/update?n=kim
	public String update(@RequestParam("n") String name) {
		/*
		 * 만일 n이라는 이름으로 파라미터가 없는 경우 400요청 에러가 난다.
		 * 
		 */
		System.out.println(name);
		return "UserController:update";
	}
	
	@ResponseBody
	@RequestMapping(value="/update2") //http://localhost:8088/hellospring/user/update2?n=kim&a=10
	public String update2(
			@RequestParam(value="n",required=true, defaultValue="") String name,
			@RequestParam(value="a",required=true, defaultValue="") int age) {
		/*
		 * 만일 n이라는 이름으로 파라미터가 없는 경우 400요청 에러가 난다.
		 * 
		 */
		System.out.println("----"+name+"----"+age+"----");
		return "UserController:update2";
	}
}
