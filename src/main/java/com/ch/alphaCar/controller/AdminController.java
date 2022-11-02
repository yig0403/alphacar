package com.ch.alphaCar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Member;
import com.ch.alphaCar.dto.Notice;
import com.ch.alphaCar.dto.Ways;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.WaysService;

@Controller
public class AdminController {
	@Autowired
	private MemberService ms;
	@Autowired
	private WaysService ws;
	
	@RequestMapping("/admin/adminMain.do")
	public String adminMain() {
		return "admin/adminMain";
	}
	
	@RequestMapping("/admin/serviceCenter.do")
	public String serviceCenter() {
		return "sc/serviceCenter";
	}
	
}
