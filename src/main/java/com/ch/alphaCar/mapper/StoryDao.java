package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Story;

@Mapper
public interface StoryDao {

	int getTotal(Story story);

	List<Story> list(Story story);

	int getMaxNum();

	Integer insert(Story story);

	void updaterpRead(Integer stNo);

	Story select(Integer stNo);

	int delete(Integer stNo);

	int update(Story story);
	
}
