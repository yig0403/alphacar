package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.ReportReply;
import com.ch.alphaCar.mapper.ReportReplyDao;

@Service
public class ReportReplyServiceImpl implements ReportReplyService {
	@Autowired
	private ReportReplyDao rrd;
	
	public void insert(ReportReply rpr) {
		rrd.insert(rpr);
	}

	public List<ReportReply> list(Integer rpNo) {
		return rrd.list(rpNo);
	}
	public ReportReply select2(Integer rrNo) {
		return rrd.select2(rrNo);
	}

	public void delete(Integer rrNo) {
		rrd.delete(rrNo);
	}
	public void update(ReportReply rpr) {
		rrd.update(rpr);
	}
	
	
}
