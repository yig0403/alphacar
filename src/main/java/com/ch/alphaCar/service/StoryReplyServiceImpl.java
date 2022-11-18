package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.StoryReply;
import com.ch.alphaCar.mapper.StoryReplyDao;

@Service
public class StoryReplyServiceImpl implements StoryReplyService {
	@Autowired
	private StoryReplyDao srd;

	public void insert(StoryReply str) {
		srd.insert(str);
	}
	public List<StoryReply> list(Integer stNo) {
		return srd.list(stNo);
	}
	public StoryReply select2(Integer strNo) {
		return srd.select2(strNo);
	}
	public void delete(Integer strNo) {
		srd.delete(strNo);
	}
	public void update(StoryReply str) {
		srd.update(str);
	}
	
}
