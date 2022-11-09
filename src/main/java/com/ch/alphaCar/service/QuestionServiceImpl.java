package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Question;
import com.ch.alphaCar.mapper.QuestionDao;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao qd;

	public int getTotal(Question question) {
		return qd.getTotal(question);
	}
	public List<Question> list(Question question) {
		return qd.list(question);
	}
	public Question select(int qNO) {
		return qd.select(qNO);
	}
}
