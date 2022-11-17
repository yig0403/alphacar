package com.ch.alphaCar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Member;
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
	
	@RequestMapping("/report/rprList.do")
	private String replyList(Model model, Integer rpNo, HttpSession session) {
		String id = (String)session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		Report report = rs.select(rpNo);
		List<ReportReply> rprList = rrs.list(rpNo);
		model.addAttribute("rprList",rprList);
		model.addAttribute("report",report);
		
		return "report/rprList";
	}
	
	@RequestMapping("rprInsert.do")
	private String rprInsert(ReportReply rpr, Model model, Report report, Integer rpNo) {		
		rrs.insert(rpr);
		report = rs.select(rpNo);
		Integer num = report.getRpNo();
		model.addAttribute("rpNo",num);
		model.addAttribute("rpr",rpr);
		return "redirect:/report/rprList.do?rpNo="+rpNo;
	}
	
	@RequestMapping("rDelete.do")
	private String rDelete(Integer rrNo, Model model ) {		
		ReportReply rpr = rrs.select2(rrNo);
		Integer rpNo = rpr.getRpNo();
		model.addAttribute("rpNo",rpNo);
		rrs.delete(rrNo);
		
		return "redirect:/report/rprList.do?rpNo="+rpNo;
	}
	@RequestMapping("rUpdate.do")
	private String rUpdate(Integer rrNo, Model model ) {		
		ReportReply rpr = rrs.select2(rrNo);
		Integer rpNo = rpr.getRpNo();
		model.addAttribute("rpNo",rpNo);
		rrs.update(rrNo);
		
		return "redirect:/report/rprList.do?rpNo="+rpNo;
	}
	
}
