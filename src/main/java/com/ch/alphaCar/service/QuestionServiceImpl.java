package com.ch.alphaCar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Question;
import com.ch.alphaCar.mapper.QuestionDao;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao qd;

	@Override
	public int getTotal(Question question) {
		// TODO Auto-generated method stub
		return 0;
	}
}
