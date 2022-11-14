package com.ch.alphaCar.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

	@RequestMapping("questionList.do")
	private String questionList(Question question, String pageNum, Model model, HttpSession session ) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = qs.getTotal(question);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		question.setStartRow(startRow);
		question.setEndRow(endRow);
		List<Question> list = qs.list(question);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		
		String id = (String) session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}

		model.addAttribute("question", question);
		model.addAttribute("num", num);
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
		return "/question/questionList";
	}

	@RequestMapping("questionInsertForm.do")
	public String insertForm(Integer qNo, String pageNum, Model model, HttpSession session) {
		int qRef = 0, qRe_level = 0, qRe_step = 0;
		if (qNo != 0) { // 답변글
			Question question = qs.select(qNo);
			qRef = question.getQRef();
			qRe_level = question.getQRe_level();
			qRe_step = question.getQRe_step();
		}
		String id = (String) session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		model.addAttribute("qNo", qNo);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("qRef", qRef);
		model.addAttribute("qRe_level", qRe_level);
		model.addAttribute("qRe_step", qRe_step);
		return "/question/questionInsertForm";
	}

	@RequestMapping("questionInsert.do")
	public String upload(Question question, Model model, HttpSession session, String pageNum) throws IOException {
		// 사진 포함 입력
		Integer result = 0;
		String fileName = question.getFile().getOriginalFilename();
		if (fileName != null && !fileName.equals("")) {
			question.setQfileName(fileName);
			String real = "src/main/resources/static/qUpload";
			FileOutputStream fos = new FileOutputStream(new File(real + "/" + fileName));
			fos.write(question.getFile().getBytes());
			fos.close();
		} else question.setQfileName(null);
		// 게시글 생성
		Integer number = qs.getMaxNum();
		if (question.getQNo() != 0) { // 답변글
			// ref가 같고 re_step이 읽은 글의 re_step보다 크면 re_step을 1증가
			qs.updateStep(question);
			question.setQRe_level(question.getQRe_level() + 1);
			question.setQRe_step(question.getQRe_step() + 1);
		} else
			question.setQRef(number);
		question.setQNo(number);

		result = qs.insert(question);

		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);

		return "/question/questionInsert";
	}
	
	@RequestMapping("questionSelect.do")
	private String questionSelect(Integer qNo, Model model, String pageNum, HttpSession session) {		
		String id = (String) session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		Question question = qs.select(qNo);
		model.addAttribute("question", question);
		model.addAttribute("pageNum", pageNum);
	 
		return "/question/questionSelect"; 
	}
	
}
