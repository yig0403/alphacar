package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Notice;

@Mapper
public interface NoticeDao {

	List<Notice> list();

	Notice select(int noNo);

	int delete(int noNo);

	int getMaxNum();

	int insert(Notice notice);

	int update(Notice notice);


}
