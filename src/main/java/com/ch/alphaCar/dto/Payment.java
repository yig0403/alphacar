package com.ch.alphaCar.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("payment")
public class Payment {
 private int payNo;       //결제번호
 private Date payDate;    //결제일
 private int pay;         //요금
 private String carNo;    
 private String id;
}
