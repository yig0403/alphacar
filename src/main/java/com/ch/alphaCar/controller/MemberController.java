package com.ch.alphaCar.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.alphaCar.dto.Member;
import com.ch.alphaCar.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	@Autowired
	private BCryptPasswordEncoder bpe; // 비밀번호를 암호화
	
	@RequestMapping("joinForm.do")
	public String joinForm() {
		return "/member/joinForm";
	}
	
	@RequestMapping("join.do")
	public String join(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면 입력한 데이터, member2 Db에 있는 데이터 중복여부 체크
		Member member2 = ms.select(member.getId());
		if (member2 == null) {
			String fileName = member.getFile().getOriginalFilename();
			// 파일명을 변경하고 싶으면 UUID 또는 long으로 날짜 데이터
			member.setMfileName(fileName);
			String real ="src/main/resources/static/upload";
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+fileName));
			fos.write(member.getFile().getBytes());
			fos.close();
			String encPass = bpe.encode(member.getPassword()); // 비밀번호 암호화
			member.setPassword(encPass);
			result = ms.insert(member);
		} else result = -1;  // 이미 있으니 입력하지마
		model.addAttribute("result", result);
		return "/member/join";
	}
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "/member/loginForm";
	}
	
	@RequestMapping("login.do")
	public String login(Member member, Model model, HttpSession session) {
		int result = 0;
		Member member2 = ms.select(member.getId());
		if (member2 == null || member2.getDel().equals("y")) result = -1; // 없는 id
//		bpe.matches 두개다 암호화 한 상태로 같은 데이터인가 
		else if (bpe.matches(member.getPassword(), member2.getPassword())) {
			result = 1; // 성공 id와 password가 일치
			session.setAttribute("id", member.getId());
		}
		model.addAttribute("result", result);
		return "/member/login";
	}
	@RequestMapping("main1.do")
	public String main(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");		
		if (id != null && !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		return "/member/main1";
	}
	@RequestMapping("main.do")
	public String main() {
		return "/member/main";
	}
	
		
	@RequestMapping(value = "idChk.do", produces = "text/html;charset=utf-8")
	@ResponseBody   // jsp로 가지말고 바로 본문을 전달
	public String idChk(String id, Model model) {
		String msg = "";
		Member member = ms.select(id);
		if (member == null) msg = "사용가능한 아이디입니다";
		else msg = "이미 사용중이니 다른 아이디를 사용하세요";
		return msg;
	}
}