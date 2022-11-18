package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("str")
public class StoryReply {
	private int strNo;
	private int stNo;
	private String id;
	private String strContent;
	private Date regdate;
	private String del;
}
