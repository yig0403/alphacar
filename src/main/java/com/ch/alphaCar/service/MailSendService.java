package com.ch.alphaCar.service;

import java.util.Random;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSendService {
		private JavaMailSender jms;
		private int authNumber;
		
		public void makeRandomNumber() {
			Random r = new Random();
			int checkNum = r.nextInt(888888) + 111111;
			authNumber = checkNum;
		}
		
		public String joinEmail(String email, JavaMailSender jms) {
			makeRandomNumber();
			this.jms=jms;
			System.out.println("인증받을 이메일 : " + email);
			String setForm = ".com";
			String toMail = email;
			String title = "알파카 인증 이메일 입니다.";
			String content = "인증 번호는 " + authNumber + "입니다.";
			mailSend(jms, setForm, toMail, title, content);
			
			return Integer.toString(authNumber);
		}
		
		public void mailSend(JavaMailSender jms, String setForm, String toMail, String title, String content) {
			MimeMessage mm = jms.createMimeMessage();
			try {
					MimeMessageHelper mmh = new MimeMessageHelper(mm, true, "utf-8");
					mmh.setFrom("nhgt5801@naver.com");
					mmh.setTo(toMail);
					mmh.setSubject(title);
					mmh.setText(content, true);
					jms.send(mm);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
