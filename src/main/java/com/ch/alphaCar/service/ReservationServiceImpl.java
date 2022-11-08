package com.ch.alphaCar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.alphaCar.dto.Reservation;
import com.ch.alphaCar.mapper.ReservationDao;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	private ReservationDao rd;


	public List<Reservation> list(Reservation reservation) {
		return rd.list(reservation);
	}

	public int getTotal(Reservation reservation) {
		return rd.getTotal(reservation);
	}


	public Reservation select(int rsNo) {
		return rd.select(rsNo);
	}

	public int delete(int rsNo) {
		return rd.delete(rsNo);
	}

	
}
