package com.ch.alphaCar.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
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
	private JavaMailSender jms;
	@Autowired
	private MemberService ms;
	@Autowired
	private BCryptPasswordEncoder bpe; // 비밀번호를 암호화
	private String emailChk;
		
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
			member.setFileName(fileName);
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
	
	@RequestMapping("update.do")
	public String update(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		result = ms.update(member);
		model.addAttribute("result", result);
		return "/member/update";
	}
	
	@RequestMapping("updatePassword.do")
	public String updatePassword(Member member, Model model, HttpSession session) throws IOException {
		int result = 0;
		String encPass = bpe.encode(member.getPassword()); // 비밀번호 암호화
		member.setPassword(encPass);
		result = ms.updatePassword(member);
		model.addAttribute("result", result);
		return "/member/updatePassword";
	}
	
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "/member/loginForm";
	}
	
	@RequestMapping("myPage.do")
	public String myPage(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");		
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "/member/myPage";
	}
	
	@RequestMapping("updatePasswordForm.do")
	public String updatePasswordForm(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");		
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "/member/updatePasswordForm";
	}
	
	@RequestMapping("delete.do")
	public String delete(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");
		int result = ms.delete(id);
		if (result > 0) session.invalidate();
		model.addAttribute("result", result);
		return "/member/delete";
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
	
	@RequestMapping("searchForm.do")
	public String searchForm(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");		
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "/member/searchForm";
	}
	@RequestMapping("updateForm.do")
	public String updateForm(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");		
		Member member = ms.select(id);
		model.addAttribute("member", member);
		return "/member/updateForm";
	}
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/member/logout";
	}
	
	@RequestMapping("main2.do")
	public String main2(Model model, HttpSession session) {
		String id = (String)session.getAttribute("id");		
		if (id != null && !id.equals("")) {
			Member member = ms.select(id);
			model.addAttribute("member", member);
		}
		return "/member/main2";
	}
	@RequestMapping({"/member/main.do","main.do"})
	public String main() {
		return "/member/main";
	}
//	@RequestMapping(value = "emailChk.do", produces = "text/html;charset=utf-8")
//	@ResponseBody   // jsp로 가지말고 바로 본문을 전달
//	public String emailChk2(String email, Model model) {
//		System.out.println("1");
//		String msg = "";
//		System.out.println("msg 1 = "+msg);
////		Member member = ms.selectEmail(email);
////		if(member == null) {
////			MailSendService mailsend = new MailSendService();
////			emailChk = mailsend.joinEmail(email, jms);
////			System.out.println("Controller에 넘어온 인증코드 : " + emailChk);
////		} else {
////			msg = "중복된 이메일입니다";
////		}
//		System.out.println("msg 2 = "+msg);
//		return msg;
//	}
	@RequestMapping(value = "idChk.do", produces = "text/html;charset=utf-8")
	@ResponseBody   // jsp로 가지말고 바로 본문을 전달
	public String idChk(String id, Model model) {
		String msg = "";
		Member member = ms.select(id);
		if (member == null) msg = "\n사용가능한 아이디입니다";
		else msg = "\n이미 사용중이니 다른 아이디를 사용하세요";
		return msg;
	}
	
}