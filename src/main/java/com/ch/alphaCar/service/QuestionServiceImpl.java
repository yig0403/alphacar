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
	public Question select(Integer qNo) {
		return qd.select(qNo);
	}
	public int getMaxNum() {
		return qd.getMaxNum();
	}
	public void updateStep(Question question) {
		qd.updateStep(question);
	}
	public Integer insert(Question question) {
		return qd.insert(question);
	}
	public List<Question> list(Question question) {
		return qd.list(question);
	}
	public int delete(Integer qNo) {
		return qd.delete(qNo);
	}
	public int update(Question question) {
		return qd.update(question);
	}
}
