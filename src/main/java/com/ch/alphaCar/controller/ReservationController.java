package com.ch.alphaCar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ch.alphaCar.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService rs;
	
}


