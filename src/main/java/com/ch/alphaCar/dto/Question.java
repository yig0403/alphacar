package com.ch.alphaCar.dto;

import java.sql.Date;

import lombok.Data;

@Data
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
}
