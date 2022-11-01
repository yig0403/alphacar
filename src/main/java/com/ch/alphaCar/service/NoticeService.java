package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.Notice;

public interface NoticeService {

	List<Notice> list();

	Notice select(int noNo);

	int delete(int noNo);

	int getMaxNum();

	int insert(Notice notice);

	int update(Notice notice);


}
