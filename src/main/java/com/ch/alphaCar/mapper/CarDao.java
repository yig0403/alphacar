package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Car;

@Mapper
public interface CarDao {

	int getTotal(Car car);

	List<Car> list(Car car);
	
	Car select(String carNo);

	int insert(Car car);

	int update(Car car);

	int delete(String carNo);

	List<Car> listR(Car car);

	int update1(String carNo);

	int update10(String carNo);

}
