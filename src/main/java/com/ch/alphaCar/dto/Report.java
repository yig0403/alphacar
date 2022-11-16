package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("report")
public class Report {
	private int rpNo;
	private String id;
	private String rpTitle;
	private String rpContent;
	private int rpRead;
	private String del;
	private Date regdate;
	private String rpfileName;
	private String rType;
	// 페이지 생성
	private int startRow;
	private int endRow;
	// 업로드
	private MultipartFile file;
	// member 테이블 조인
	private Member member;
}
