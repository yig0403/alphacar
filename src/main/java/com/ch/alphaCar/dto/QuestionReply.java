package com.ch.alphaCar.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class QuestionReply {
	private int qrNo;
	private int qNo;
	private String id;
	private String qrContent;
	private Date regdate;
	private String del;
}
