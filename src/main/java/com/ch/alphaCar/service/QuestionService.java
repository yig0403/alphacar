package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.Question;

public interface QuestionService {

	int getTotal(Question question);

	Question select(Integer qNo);

	int getMaxNum();

	void updateStep(Question question);

	Integer insert(Question question);

	List<Question> list(Question question);

	int delete(Integer qNo);

	int update(Question question);



}
