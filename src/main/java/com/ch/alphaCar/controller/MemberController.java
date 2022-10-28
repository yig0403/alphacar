package com.ch.alphaCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.alphaCar.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
}
