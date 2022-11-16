package com.ch.alphaCar.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.ReportReply;

@Mapper
public interface ReportReplyDao {

	void insert(ReportReply rpr);

}
