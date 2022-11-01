package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("member")
public class Member {
	private String id;
	private String password;
	private String name;
	private String address;
	private String tel;
	private String email;
	private String birth;
	private String gender;
	private String del;
	private Date regdate;
	private String mfileName;
	private String ad;
	// upload용
	private MultipartFile file; //opop
	private int startRow; // asd asdasdasd
	
}
