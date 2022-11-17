package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.ReportReply;

@Mapper
public interface ReportReplyDao {

	void insert(ReportReply rpr);

	List<ReportReply> list(Integer rpNo);

	ReportReply select2(Integer rrNo);

	void delete(Integer rrNo);

	void update(Integer rrNo);

	

}
