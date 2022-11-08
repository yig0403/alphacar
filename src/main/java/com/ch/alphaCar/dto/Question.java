package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
@Alias("question")
public class Question {
	private int qNo;
	private String id;
	private String qTitle;
	private String qContent;
	private Date regdate;
	private int qRef;
	private int qRe_level;
	private int qRe_step;
	private String qfileName;
	private String del;
//	paging용
	private int startRow;
	private int endRow;
// 업로드
	private MultipartFile file;
	
}
