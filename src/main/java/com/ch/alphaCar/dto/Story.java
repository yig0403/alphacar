package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
@Alias("story")
public class Story {
	private int stNo;
	private String id;
	private String stTitle;
	private String stContent;
	private int stReadcount;
	private Date regdate;
	private String sfileName;
	private String del;
	// 페이지 생성
	private int startRow;
	private int endRow;
	// 업로드
	private MultipartFile file;
	// member 테이블 조인
	private Member member;
}
