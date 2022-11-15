package com.ch.alphaCar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.mapper.ReportReplyDao;

@Service
public class ReportReplyServiceImpl implements ReportReplyService {
	@Autowired
	private ReportReplyDao rrd;
}
