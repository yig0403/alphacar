package com.ch.alphaCar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.mapper.QuestionDao;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired QuestionDao qd;
}
