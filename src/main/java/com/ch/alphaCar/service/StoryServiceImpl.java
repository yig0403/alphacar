package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Story;
import com.ch.alphaCar.mapper.StoryDao;

@Service
public class StoryServiceImpl implements StoryService {
	@Autowired
	private StoryDao sd;

	public int getTotal(Story story) {
		return sd.getTotal(story);
	}
	public List<Story> list(Story story) {
		return sd.list(story);
	}
	public int getMaxNum() {
		return sd.getMaxNum();
	}
	public Integer insert(Story story) {
		return sd.insert(story);
	}
	public void updaterpRead(Integer stNo) {
		sd.updaterpRead(stNo);
	}
	public Story select(Integer stNo) {
		return sd.select(stNo);
	}
	public int delete(Integer stNo) {
		return sd.delete(stNo);
	}
	public int update(Story story) {
		return sd.update(story);
	}
}
