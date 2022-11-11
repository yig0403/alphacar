package com.ch.alphaCar.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("datetime")
public class DateTime {
	private int dateId;
	private Date totalDate;
	private int totalTime;
	private String carNo;
	private int rsNo;
}