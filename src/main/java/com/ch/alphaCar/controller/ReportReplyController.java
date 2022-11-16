package com.ch.alphaCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Report;
import com.ch.alphaCar.dto.ReportReply;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.ReportReplyService;
import com.ch.alphaCar.service.ReportService;

@Controller
public class ReportReplyController {
	@Autowired
	private ReportReplyService rrs;
	@Autowired
	private ReportService rs;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("rprInsert.do")
	private String rprInsert(ReportReply rpr, Model model, Report report, int rpNo) {
		rrs.insert(rpr);		
		report = rs.select(rpNo);
		int num = report.getRpNo();
		model.addAttribute("rpNo",num);
		model.addAttribute("rpr",rpr);
		return "redirect:/report/rprList";
	}
	
}
