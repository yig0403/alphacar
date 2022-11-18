package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.StoryReply;

public interface StoryReplyService {

	void insert(StoryReply str);

	List<StoryReply> list(Integer stNo);

	StoryReply select2(Integer strNo);

	void delete(Integer strNo);

	void update(StoryReply str);

	

}
