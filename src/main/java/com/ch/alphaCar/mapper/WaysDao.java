package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Ways;

@Mapper
public interface WaysDao {

	int insert(Ways ways);

	List<Ways> list();

	Ways select(String waysTitle);

	int update(Ways ways);

	int delete(String waysTitle);

}
