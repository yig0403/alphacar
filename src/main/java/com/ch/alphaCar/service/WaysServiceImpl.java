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

	public int insert(Ways ways) {
		return wd.insert(ways);
	}
	public List<Ways> list() {
		return wd.list();
	}
	public Ways select(String waysTitle) {
		return wd.select(waysTitle);
	}
	public int update(Ways ways) {
		return wd.update(ways);
	}
	public int delete(String waysTitle) {
		return wd.delete(waysTitle);
	}
}
