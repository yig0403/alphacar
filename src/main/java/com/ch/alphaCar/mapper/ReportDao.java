package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Report;

@Mapper
public interface ReportDao {

	int getTotal(Report report);

	List<Report> list(Report report);

	int getMaxNum();

	int insert(Report report);
	
}
