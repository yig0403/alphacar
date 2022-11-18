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
import com.ch.alphaCar.dto.Report;
import com.ch.alphaCar.dto.Story;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.PagingBean;
import com.ch.alphaCar.service.StoryService;

@Controller
public class StoryController {
	@Autowired
	private StoryService ss;
	@Autowired
	private MemberService ms;
	
	@RequestMapping("storyList.do")
	private String storyList(Story story, String pageNum, Model model, HttpSession session ) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals(""))
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = ss.getTotal(story);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		story.setStartRow(startRow);
		story.setEndRow(endRow);
		List<Story> list = ss.list(story);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);		
		String id = (String) session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		model.addAttribute("Story", story);
		model.addAttribute("num", num);
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
		return "/story/storyList";
	}
	@RequestMapping("storyInsertForm.do")
	public String insertForm(int stNo, String pageNum, Model model, HttpSession session) {		
		String id = (String) session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		model.addAttribute("stNo", stNo);
		model.addAttribute("pageNum", pageNum);		
		return "/story/storyInsertForm";		
	}
	@RequestMapping("storyInsert.do")
	private String storyInsert(Story story, Model model, String pageNum, HttpSession session) throws IOException {
				// 사진 포함 입력
				Integer result = 0;
				String fileName = story.getFile().getOriginalFilename();
				if (fileName != null && !fileName.equals("")) {
					story.setSfileName(fileName);
					String real = "src/main/resources/static/sUpload";
					FileOutputStream fos = new FileOutputStream(new File(real + "/" + fileName));
					fos.write(story.getFile().getBytes());
					fos.close();
				} else story.setSfileName(null);
				// 게시글 생성
				// 게시글 번호 구하기
				int number = ss.getMaxNum();				
				story.setStNo(number);
				result = ss.insert(story);
				model.addAttribute("result", result);
				model.addAttribute("pageNum", pageNum);		
		
		return "/story/storyInsert";
	}
	@RequestMapping("storySelect.do")
	private String reportSelect(Integer stNo, Model model, String pageNum, HttpSession session) {
		String id = (String)session.getAttribute("id");
		if (id != null || !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		ss.updaterpRead(stNo);
		Story story = ss.select(stNo);		
		model.addAttribute("story", story);
		model.addAttribute("pageNum", pageNum);
		return "/story/storySelect";
	}
	@RequestMapping("storyDelete.do")
	private String storyDelete(Model model, Integer stNo) {
		Story story = ss.select(stNo);
		int result = ss.delete(stNo);
		model.addAttribute("result", result);
		model.addAttribute("story", story);
		return "/story/storyDelete";
	}
	@RequestMapping("storyUpdateForm.do")
	private String storyUpdateForm(Integer stNo, String pageNum, Model model) {
		Story story = ss.select(stNo);		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("story", story);
		return "/story/storyUpdateForm";
	}
	@RequestMapping("storyUpdate.do")
	private String storyUpdate(Story story, String pageNum, Model model) {
		int result = ss.update(story);
		model.addAttribute("result",result);
		model.addAttribute("pageNum",pageNum);		
		return "/story/storyUpdate";
	}
}
