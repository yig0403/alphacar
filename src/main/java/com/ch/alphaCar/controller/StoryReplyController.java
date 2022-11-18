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
import com.ch.alphaCar.dto.Story;
import com.ch.alphaCar.dto.StoryReply;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.StoryReplyService;
import com.ch.alphaCar.service.StoryService;

@Controller
public class StoryReplyController {
	@Autowired
	private StoryReplyService srs;
	@Autowired
	private StoryService ss;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("/story/strList.do")
	private String strList(Model model, Integer stNo, HttpSession session) {
		String id = (String)session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		Story story = ss.select(stNo);
		List<StoryReply> strList = srs.list(stNo);
		model.addAttribute("strList",strList);
		model.addAttribute("story",story);
		
		return "story/strList";
	}
	
	@RequestMapping("strInsert.do")
	private String srInsert(StoryReply str, Model model, Story story, Integer stNo) {		
		srs.insert(str);
		story = ss.select(stNo);
		Integer num = story.getStNo();
		model.addAttribute("stNo",num);
		model.addAttribute("str",str);
		return "redirect:/story/strList.do?stNo="+stNo;
	}
	@RequestMapping("sDelete.do")
	private String sDelete(Integer strNo, Model model ) {		
		StoryReply str = srs.select2(strNo);
		Integer stNo = str.getStNo();
		model.addAttribute("stNo",stNo);
		srs.delete(strNo);		
		return "redirect:/story/strList.do?stNo="+stNo;
	}
	@RequestMapping("sUpdate.do")
	private String sUpdate(Model model, StoryReply str) {	
		StoryReply str2 = srs.select2(str.getStrNo());
		Integer stNo2 = str2.getStNo();		
		model.addAttribute("stNo",stNo2);				
		srs.update(str);
		return "redirect:/story/strList.do?stNo="+stNo2;
	}
}
