package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
@Alias("reservation")
public class Reservation {
 private int rsNo;                //예약번호
 private Date regDate;            //예약날짜
 private Date startDate;          //렌트날짜 
 private Date endDate;            //반납날짜
 private int amount;
 private String cancel;           //취소여부
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
