package com.ch.alphaCar.dto;

import java.util.Date;

import lombok.Data;
@Data
public class Reservation {
 private int rsNo;
 private Date regDate;
 private Date startDate;
 private Date endDate;
 private String del;
 private String carNo;
 private String id;
 
}
