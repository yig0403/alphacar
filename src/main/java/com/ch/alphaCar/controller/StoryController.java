package com.ch.alphaCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.StoryService;

@Controller
public class StoryController {
	@Autowired
	private StoryService ss;
	@Autowired
	private MemberService ms;
	
}
