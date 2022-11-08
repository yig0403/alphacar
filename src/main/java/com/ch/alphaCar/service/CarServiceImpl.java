package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Car;
import com.ch.alphaCar.mapper.CarDao;
@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDao cd;

	public int getTotal(Car car) {
		return cd.getTotal(car);
	}

	public List<Car> list(Car car) {
		return cd.list(car);
	}

	public Car select(String carNo) {
		return cd.select(carNo);
	}

	public int insert(Car car) {
		return cd.insert(car);
	}

	public int update(Car car) {
		return cd.update(car);
	}


	public int delete(String carNo) {
		return cd.delete(carNo);
	}

	public List<Car> listR(Car car) {
		return cd.listR(car);
	}

}
