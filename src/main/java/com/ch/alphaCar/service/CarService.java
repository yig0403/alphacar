package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.Car;

public interface CarService {

	int getTotal(Car car);

	List<Car> list(Car car);

	Car select(String carNo);

	int insert(Car car);

	int update(Car car);

	int delete(String carNo);

}
