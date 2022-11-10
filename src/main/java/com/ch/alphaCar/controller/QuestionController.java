package com.ch.alphaCar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Member;
import com.ch.alphaCar.dto.Question;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.PagingBean;
import com.ch.alphaCar.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService qs;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("/question/questionList.do")
	private String questionList(Question question, String pageNum, Model model) {
		int rowPerPage = 10; // 한 페이지에 보여줄 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = qs.getTotal(question);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		
		question.setStartRow(startRow);
		question.setEndRow(endRow);
		List<Question> list = qs.list(question);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		
		model.addAttribute("question", question);
		model.addAttribute("num", num);
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
		return "question/questionList";
	}
	
	@RequestMapping("/question/questionInsertForm.do")
	public String insertForm(Integer qNo, String pageNum, Model model, HttpSession session) {
		int qRef=0, qRe_level=0, qRe_step=0;
		if (qNo != 0 ) { // 답변글
			Question question = qs.select(qNo);
			qRef = question.getQRef();
			qRe_level = question.getQRe_level();
			qRe_step = question.getQRe_step();
		}
		String id = (String)session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member",member);
		}
		model.addAttribute("qNo",qNo);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("qRef",qRef);
		model.addAttribute("qRe_level",qRe_level);
		model.addAttribute("qRe_step",qRe_step);
		return "question/questionInsertForm";
	}
}
