package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVO;

@Controller
public class GuestbookController {
	@Autowired
	public GuestbookRepository guestbookRepository;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(Model model) { 
		List<GuestbookVO> list = guestbookRepository.findAll();
		model.addAttribute("list",list);
		return "index";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(GuestbookVO vo,Model model) { 
		guestbookRepository.insert(vo);

		return "redirect:/";
	}	
	
	@RequestMapping(value="/deleteform/{no}",method=RequestMethod.GET)
	public String deleteform(@PathVariable("no") Long no,Model model) {
		System.out.println(no);
		model.addAttribute("no",no);
		return "deleteform";
	}
	
	@RequestMapping(value="/delete/{no}",method=RequestMethod.POST)
	public String delete(@PathVariable("no") Long no, @RequestParam("password") String password) {
		System.out.println(no);
		System.out.println(password);
		guestbookRepository.delete(no,password);
		return "redirect:/";
	}
	
	
}
