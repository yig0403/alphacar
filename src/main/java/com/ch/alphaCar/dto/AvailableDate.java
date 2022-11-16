package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("availableDate")
public class AvailableDate {
	private Date bkdate;
	private Date rtdate;
	private String carNo;
	private int rsNo;
}
