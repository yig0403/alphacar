package com.ch.alphaCar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Member;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.NoticeService;
import com.ch.alphaCar.service.WaysService;

@Controller
public class AdminController {
	@Autowired
	private MemberService ms;
	@Autowired
	private WaysService ws;
	
	@RequestMapping("adminMain.do")
	public String adminMain(HttpSession session) {		
		String id = (String)session.getAttribute("id");		
		if (id == null || !id.equals("admin")) {
			return "/member/main2";
		} else return "/admin/adminMain";
	}
	
	@RequestMapping("serviceCenter.do")
	public String serviceCenter() {
		return "/sc/serviceCenter";
	}

}
