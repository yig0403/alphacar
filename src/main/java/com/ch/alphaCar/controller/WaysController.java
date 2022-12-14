package com.ch.alphaCar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Member;
import com.ch.alphaCar.dto.Ways;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.WaysService;

@Controller
public class WaysController {
	@Autowired
	private WaysService ws;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("ways.do")
	public String ways(Model model, HttpSession session, Ways ways) {
		String id = (String)session.getAttribute("id");
		if (id != null && !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		List<Ways> waysList = ws.list();
		model.addAttribute("waysList",waysList);
		return "/ways/ways";
	}
	
	@RequestMapping("waysInsertForm.do")
	private String waysInsertForm(Model model) {
		return "/ways/waysInsertForm";
	}
	@RequestMapping("waysInsert.do")
	private String waysInsert(Ways ways, Model model, HttpSession session) {
		int result=0;
		String id = (String)session.getAttribute("id");	
		ways.setId(id);
		result = ws.insert(ways);
		model.addAttribute("result",result);
		
		return "/ways/waysInsert";
	}
	@RequestMapping("waysUpdateForm.do")
	private String waysUpdateForm(String waysTitle, Model model) {
		Ways ways = ws.select(waysTitle);
		model.addAttribute("ways", ways);
		return "/ways/waysUpdatefrom";
	}
	@RequestMapping("waysUpdate.do")
	private String waysUpdate(Model model, Ways ways) {
		int result = ws.update(ways);
		model.addAttribute("result", result);
		return "/ways/waysUpdate";
	}
	@RequestMapping("waysDelete.do")
	private String waysDelete(String waysTitle, Model model) {
		Ways ways = ws.select(waysTitle);
		int result = ws.delete(waysTitle);
		model.addAttribute("result",result);
		model.addAttribute("ways",ways);
		return "/ways/waysDelete";
	}
	
	@RequestMapping("waysManagement.do")
	private String waysManagement(Model model, Ways ways) {
		List<Ways> waysList = ws.list();
		model.addAttribute("waysList",waysList);
		return "/ways/waysManagement";
	}
	@RequestMapping("waysSelect.do")
	private String waysSelect(Model model, String waysTitle ) {
		Ways ways = ws.select(waysTitle);
		model.addAttribute("ways",ways);
		return "/ways/waysSelect";
	}
}
