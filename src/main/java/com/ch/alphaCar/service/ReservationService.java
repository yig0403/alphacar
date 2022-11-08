package com.ch.alphaCar.service;

import java.util.List;

import com.ch.alphaCar.dto.Reservation;

public interface ReservationService {

	List<Reservation> list(Reservation reservation);

	int getTotal(Reservation reservation);

}
