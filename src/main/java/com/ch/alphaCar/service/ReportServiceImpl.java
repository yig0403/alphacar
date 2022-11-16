package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Report;
import com.ch.alphaCar.mapper.ReportDao;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao rd;

	public int getTotal(Report report) {
		return rd.getTotal(report);
	}
	public List<Report> list(Report report) {
		return rd.list(report);
	}
	public int getMaxNum() {
		return rd.getMaxNum();
	}
	public Integer insert(Report report) {
		return rd.insert(report);
	}
	public Report select(Integer rpNo) {
		return rd.select(rpNo);
	}
	public int delete(Integer rpNo) {
		return rd.delete(rpNo);
	}
	public int update(Report report) {
		return rd.update(report);
	}
	public void updaterpRead(Integer rpNo) {
		rd. updaterpRead(rpNo);
	}
}
