package com.ch.alphaCar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Faq;
import com.ch.alphaCar.dto.Member;
import com.ch.alphaCar.service.FaqService;
import com.ch.alphaCar.service.MemberService;

@Controller
public class FaqController {
	@Autowired
	private FaqService fs;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("faq.do")
	public String ways(Model model, HttpSession session, Faq faq) {
		String id = (String)session.getAttribute("id");
		if (id != null && !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		List<Faq> faqList = fs.list();
		model.addAttribute("faqList",faqList);
		return "/faq/faq";
	}
	@RequestMapping("faqInsertForm.do")
	private String faqInsertForm() {
		return "/faq/faqInsertForm";
	}
	@RequestMapping("faqInsert.do")
	private String faqInser(Model model, Faq faq, HttpSession session ) {
		int result=0;
		String id = (String)session.getAttribute("id");	
		faq.setId(id);
		result = fs.insert(faq);
		model.addAttribute("result",result);
		return "/faq/faqInsert";
	}
	@RequestMapping("faqManagement.do")
	private String faqManagement(Model model, Faq faq) {
		List<Faq> faqList = fs.list();
		model.addAttribute("faqList",faqList);
		return "/faq/faqManagement";
	}
	@RequestMapping("faqSelect.do")
	private String waysSelect(Model model, String faqTitle) {
		Faq faq = fs.select(faqTitle);
		model.addAttribute("faq",faq);
		return "/faq/faqSelect";
	}
	@RequestMapping("faqUpdateForm.do")
	private String faqUpdateForm(String faqTitle, Model model) {
		Faq faq = fs.select(faqTitle);
		model.addAttribute("faq", faq);
		return "/faq/faqUpdatefrom";
	}
	
	@RequestMapping("faqUpdate.do")
	private String faqUpdate(Model model, Faq faq) {
		int result = fs.update(faq);
		model.addAttribute("result", result);
		return "/faq/faqUpdate";
	}
	@RequestMapping("faqDelete.do")
	private String faqDelete(String faqTitle, Model model) {
		Faq faq = fs.select(faqTitle);
		int result = fs.delete(faqTitle);
		model.addAttribute("result",result);
		model.addAttribute("faq",faq);
		return "/faq/faqDelete";
	}
}
