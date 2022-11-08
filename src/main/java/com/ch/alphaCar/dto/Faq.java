package com.ch.alphaCar.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("faq")
public class Faq {
	private String faqTitle;
	private String id;
	private String faqContents;
	private String del;
	
	private Member member;
}
