package com.ch.alphaCar.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("car")
public class Car {
	private String carNo; // 차량번호
	private String carName; // 차 이름
	private String carRank; // 차량 등급(경차, 소형, 중형, 준대형, 대형, SUV/RV, 승합, 수입차, 전기차)
	private String carKind; // 제조사/차종 (쉐보레, 현대, 기아, 쌍용, 테슬라 등등)
	private String carType; // 연료(디젤, 전기, 가솔린, LPG, 하이브리드, 기타)
	private String carYear; // 연식
	private int fee; // 기본요금
	private String carColor; // 차 색깔
	private String carRegion; // 지역
	private String del;
	private String filename; // 차 사진
	private String carRes; // 차 예약 여부
	private String id; // 관리자 아이디만 접근

	// paging용
	private int startRow;
	private int endRow;
	// 검색용
	private String search;
	private String keyword;
	// 업로드
	private MultipartFile file;

}
