package com.ch.alphaCar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.ReportReply;
import com.ch.alphaCar.mapper.MemberDao;
import com.ch.alphaCar.mapper.ReportDao;
import com.ch.alphaCar.mapper.ReportReplyDao;

@Service
public class ReportReplyServiceImpl implements ReportReplyService {
	@Autowired
	private ReportReplyDao rrd;
	
	public void insert(ReportReply rpr) {
		rrd.insert(rpr);
	}
}
