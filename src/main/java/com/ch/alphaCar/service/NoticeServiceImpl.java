package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Notice;
import com.ch.alphaCar.mapper.NoticeDao;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao nd;

	public List<Notice> list() {
		return nd.list();
	}
	public Notice select(int noNo) {
		return nd.select(noNo);
	}
	public int delete(int noNo) {
		return nd.delete(noNo);
	}
	public int getMaxNum() {
		return nd.getMaxNum();
	}
	public int insert(Notice notice) {
		return nd.insert(notice);
	}
	public int update(Notice notice) {
		return nd.update(notice);
	}

	
}
