package com.ch.alphaCar.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Question;

@Mapper
public interface QuestionDao {

	int getTotal(Question question);

}
