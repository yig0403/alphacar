package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.Ways;

public interface WaysService {

	int insert(Ways ways);

	List<Ways> list();

}
