package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.Story;

public interface StoryService {

	int getTotal(Story story);

	List<Story> list(Story story);

	int getMaxNum();

	Integer insert(Story story);

	void updaterpRead(Integer stNo);

	Story select(Integer stNo);

	int delete(Integer stNo);

	int update(Story story);

}
