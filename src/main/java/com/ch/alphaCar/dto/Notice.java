package com.ch.alphaCar.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("notice")
public class Notice {
	
	private int noNo;
	private String noTitle;
	private String noContent;
	private String regdate;
	private String del;
	// 회원 id
	private String id;
	// member 테이블 조인
	private Member member;

}
