package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.StoryReply;

@Mapper
public interface StoryReplyDao {

	void insert(StoryReply str);

	List<StoryReply> list(Integer stNo);

	StoryReply select2(Integer strNo);

	void delete(Integer strNo);

	void update(StoryReply str);

}
