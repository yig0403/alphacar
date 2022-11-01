package com.ch.alphaCar.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ch.alphaCar.service.SessionChk;
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	@Bean   // fileupload setting
	public CommonsMultipartResolver multiResolver() {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setDefaultEncoding("utf-8");
		cmr.setMaxUploadSize(10*1024*1024); // 최대 10M
		return cmr;
	}
	// sessionChk
		public void addInterceptors(InterceptorRegistry registory) {
			registory.addInterceptor(new SessionChk())
				.excludePathPatterns("/**/joinForm.do","/**/join.do","/**/idChk.do",
					"/**/loginForm.do","/**/login.do","/**/joinForm2.do","/**/join2.do")
				.addPathPatterns("/**/*.do");
		}
	
	// spring 암호화
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}