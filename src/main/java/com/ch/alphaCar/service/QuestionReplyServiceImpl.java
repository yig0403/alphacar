package com.ch.alphaCar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.mapper.QuestionReplyDao;

@Service
public class QuestionReplyServiceImpl implements QuestionReplyService {
	@Autowired
	private QuestionReplyDao qrd;
}
