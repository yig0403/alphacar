package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.Report;

public interface ReportService {

	int getTotal(Report report);

	List<Report> list(Report report);

	int getMaxNum();

	Integer insert(Report report);

	Report select(Integer rpNo);

	int delete(Integer rpNo);

	int update(Report report);

	void updaterpRead(Integer rpNo);

}
