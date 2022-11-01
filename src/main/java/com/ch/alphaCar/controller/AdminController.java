package com.ch.alphaCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.service.MemberService;

@Controller
public class AdminController {
	@Autowired
	private MemberService ms;
	
	@RequestMapping("/admin/adminMain.do")
	public String adminMain() {
		return "admin/adminMain";
	}
}
