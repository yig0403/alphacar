package com.ch.alphaCar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Member;
import com.ch.alphaCar.dto.Notice;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("/notice/noticeMain.do")
	public String noticeMain() {		
		return "notice/noticeMain";
	}
	
	@RequestMapping("/notice/noticeList.do")
	public String noticeList(Notice notice, Model model) {		
		List<Notice> noticeList = ns.list();
		model.addAttribute("noticeList",noticeList);		
		return "notice/noticeList";
	}
	
	@RequestMapping("/notice/noticeSelect.do")
	public String noticeSelect(int noNo,  Model model, HttpSession session) {
		Notice notice = ns.select(noNo);		
		String id = (String)session.getAttribute("id");	
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member",member);
		}		
		model.addAttribute("notice",notice);
		
		return "notice/noticeSelect";
	}
	@RequestMapping("/notice/noticeDelete.do")
	public String noticeDelete(int noNo, Model model) {
		Notice notice = ns.select(noNo);
		int result = ns.delete(noNo);
		model.addAttribute("result", result);
		model.addAttribute("notice", notice);
		return "notice/noticeDelete";
	}
	@RequestMapping("/notice/noticeInsertForm.do")
	public String noticeInsertForm(Model model) {		
		return "notice/noticeInsertForm";
	}
	@RequestMapping("/notice/noticeInsert.do")
	public String noticeInsert(Notice notice, Model model, HttpSession session ) {
		int result=0;
		int number = ns.getMaxNum();
		String id = (String)session.getAttribute("id");	
		notice.setNoNo(number);
		notice.setId(id);
		result = ns.insert(notice);
		model.addAttribute("result",result);
		
		return "notice/noticeInsert";
	}
	@RequestMapping("/notice/noticeUpdateForm.do")
	public String noticeUpdateForm(int noNo, Model model) {
		Notice notice = ns.select(noNo);
		model.addAttribute("notice", notice);		
		return "notice/noticeUpdateForm";
	}
	@RequestMapping("/notice/noticeUpdate.do")
	public String noticeUpdate(Model model, Notice notice) {
		int result = ns.update(notice);
		model.addAttribute("result",result);
		return "notice/noticeUpdate";
	}
	
}
