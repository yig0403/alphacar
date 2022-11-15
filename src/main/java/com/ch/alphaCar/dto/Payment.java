package com.ch.alphaCar.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("payment")
public class Payment {
 private int pay;
 private String carNo;
 private String id;
}
