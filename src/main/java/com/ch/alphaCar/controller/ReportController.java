package com.ch.alphaCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService rs;
	@Autowired
	private MemberService ms;
	
}
