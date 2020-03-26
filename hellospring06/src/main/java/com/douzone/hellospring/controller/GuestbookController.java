package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMpping
 * Class 단독 매핑
 */
@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping("/list") //메소드이름으로 접근하능 => http://localhost:8088/hellospring/guestbook/list
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping("/delete") //메소드이름으로 접근하능 => http://localhost:8088/hellospring/guestbook/delete
	public String delete() {
		return "GuestbookController:delete";
	}
}
