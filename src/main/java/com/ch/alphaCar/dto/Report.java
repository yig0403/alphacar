package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("report")
public class Report {
	private int rpNo;
	private String id;
	private String rpTitle;
	private String rpContent;
	private String rpRead;
	private String del;
	private Date regdate;
	private String rpfileName;
	// 페이지 생성
	private int startRow;
	private int endRow;
}
