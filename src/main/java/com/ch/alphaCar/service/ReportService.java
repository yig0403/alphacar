package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.Report;

public interface ReportService {

	int getTotal(Report report);

	List<Report> list(Report report);

	int getMaxNum();

	int insert(Report report);

}
