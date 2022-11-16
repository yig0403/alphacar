package com.ch.alphaCar.controller;

import java.io.File;
import java.io.FileNotFoundException;
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
import com.ch.alphaCar.dto.Report;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.PagingBean;
import com.ch.alphaCar.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService rs;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("reportList.do")
	private String questionList(Report report, String pageNum, Model model, HttpSession session ) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = rs.getTotal(report);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		report.setStartRow(startRow);
		report.setEndRow(endRow);
		List<Report> list = rs.list(report);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);		
		String id = (String) session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		model.addAttribute("Report", report);
		model.addAttribute("num", num);
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
		return "/report/reportList";
	}
	@RequestMapping("reportInsertForm.do")
	public String insertForm(int rpNo, String pageNum, Model model, HttpSession session) {		
		String id = (String) session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		model.addAttribute("rpNo", rpNo);
		model.addAttribute("pageNum", pageNum);		
		return "/report/reportInsertForm";
		
	}
	@RequestMapping("reportInsert.do")
	private String reportInsert(Report report, Model model, String pageNum, HttpSession session) throws IOException {
				// 사진 포함 입력
				Integer result = 0;
				String fileName = report.getFile().getOriginalFilename();
				if (fileName != null && !fileName.equals("")) {
					report.setRpfileName(fileName);
					String real = "src/main/resources/static/rUpload";
					FileOutputStream fos = new FileOutputStream(new File(real + "/" + fileName));
					fos.write(report.getFile().getBytes());
					fos.close();
				} else report.setRpfileName(null);
				// 게시글 생성
				// 게시글 번호 구하기
				int number = rs.getMaxNum();				
				report.setRpNo(number);
				result = rs.insert(report);
				model.addAttribute("result", result);
				model.addAttribute("pageNum", pageNum);		
		
		return "/report/reportInsert";
	}
	@RequestMapping("reportSelect.do")
	private String reportSelect(Integer rpNo, Model model, String pageNum, HttpSession session) {
		String id = (String)session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		rs.updaterpRead(rpNo);
		Report report = rs.select(rpNo);		
		model.addAttribute("report", report);
		model.addAttribute("pageNum", pageNum);
		return "/report/reportSelect";
	}
	@RequestMapping("reportDelete.do")
	private String reportDelete(Model model, Integer rpNo) {
		Report report = rs.select(rpNo);
		int result = rs.delete(rpNo);
		model.addAttribute("result", result);
		model.addAttribute("report", report);
		return "/report/reportDelete";
	}
	@RequestMapping("reportUpdateForm.do")
	private String reportUpdateForm(Integer rpNo, String pageNum, Model model) {
		Report report = rs.select(rpNo);		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("report", report);
		return "/report/reportUpdateForm";
	}
	@RequestMapping("reportUpdate.do")
	private String reportUpdate(Report report, String pageNum, Model model) {
		int result = rs.update(report);
		model.addAttribute("result",result);
		model.addAttribute("pageNum",pageNum);		
		return "/report/reportUpdate";
	}
	
}
