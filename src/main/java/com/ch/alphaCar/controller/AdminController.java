package com.ch.alphaCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.WaysService;

@Controller
public class AdminController {
	@Autowired
	private MemberService ms;
	@Autowired
	private WaysService ws;
	
	@RequestMapping("adminMain.do")
	public String adminMain() {
		return "/admin/adminMain";
	}
	
	@RequestMapping("serviceCenter.do")
	public String serviceCenter() {
		return "/sc/serviceCenter";
	}
	
}
