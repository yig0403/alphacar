package com.ch.alphaCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Question;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService qs;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("/question/questionList")
	private String questionList(Question question, String pageNum, Model model) {
		int rowPerPage = 10; // 한 페이지에 보여줄 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = qs.getTotal(question);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		
		
		return "question/questionList";
	}
}
