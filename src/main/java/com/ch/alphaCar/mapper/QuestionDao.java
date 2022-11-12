package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Question;

@Mapper
public interface QuestionDao {

	int getTotal(Question question);

	Question select(Integer qNo);

	int getMaxNum();

	void updateStep(Question question);

	Integer insert(Question question);

	List<Question> list(Question question);

}
