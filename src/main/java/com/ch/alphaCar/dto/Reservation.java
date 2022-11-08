package com.ch.alphaCar.dto;

import java.util.Date;

import lombok.Data;
@Data
public class Reservation {
 private int rsNo;                //예약번호
 private Date regDate;            //예약날짜
 
 private String year;
 private String month;
 private String day;
 
 private String startDate;        //렌트날짜 
 private String endDate;          //반납날짜
 private String cancel;           //취소여부
 private int amount;
 private String del;              //목록 삭제 
 private String carNo;            //차량번호
 private String id;               //아이디
 
 
	// paging용
	private int startRow;
	private int endRow;
	// 검색용
	private String search;
	private String keyword;
}
