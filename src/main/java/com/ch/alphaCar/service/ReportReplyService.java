package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.ReportReply;

public interface ReportReplyService {

	void insert(ReportReply rpr);

	List<ReportReply> list(Integer rpNo);

	ReportReply select2(Integer rrNo);

	void delete(Integer rrNo);

	void update(Integer rrNo);

	

}
