package com.ch.alphaCar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.alphaCar.dto.Car;
import com.ch.alphaCar.dto.Reservation;

@Mapper
public interface ReservationDao {

	List<Reservation> list(Reservation reservation);

	int getTotal(Reservation reservation);

	Reservation select(int rsNo);

	int delete(int rsNo);

	List<Reservation> listSearch(Reservation reservation);

	int insert(Reservation reservation);

	int getMaxNum();

	int update1(int rsNo);

}
