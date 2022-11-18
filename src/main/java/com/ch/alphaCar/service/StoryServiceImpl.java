package com.ch.alphaCar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.mapper.StoryDao;

@Service
public class StoryServiceImpl implements StoryService {
	@Autowired
	private StoryDao sd;
}
