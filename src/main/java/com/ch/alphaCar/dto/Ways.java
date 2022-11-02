package com.ch.alphaCar.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ways")
public class Ways {
	private String waysTitle;
	private String id;
	private String waysContents;
	private String del;
	
	private Member member;
}
