package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("reportreply")
public class ReportReply {
	private int rrNo;	
	private int rpNo;
	private String id;
	private String rprContent;
	private Date regdate;
	private String del;
}
