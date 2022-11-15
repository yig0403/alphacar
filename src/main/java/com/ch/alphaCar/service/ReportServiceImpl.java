package com.ch.alphaCar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.mapper.ReportDao;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao rd;
}
