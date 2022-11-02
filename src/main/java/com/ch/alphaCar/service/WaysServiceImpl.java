package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Ways;
import com.ch.alphaCar.mapper.WaysDao;

@Service
public class WaysServiceImpl implements WaysService {
	@Autowired
	private WaysDao wd;

	@Override
	public int insert(Ways ways) {
		return wd.insert(ways);
	}
	@Override
	public List<Ways> list() {
		return wd.list();
	}
}
