package com.ch.alphaCar.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Car;
import com.ch.alphaCar.dto.Reservation;
import com.ch.alphaCar.service.CarService;
import com.ch.alphaCar.service.MemberService;
import com.ch.alphaCar.service.PagingBean;
import com.ch.alphaCar.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService rs;
	
	@Autowired
	private CarService cs;
	
	@Autowired 
	private MemberService ms;
	
	@RequestMapping("reservationHistory")
	public String reservationHistory(Reservation reservation, String PageNum, Model model, HttpSession session) {
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = cs.getTotal(reservation);		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		reservation.setStartRow(startRow);
		reservation.setEndRow(endRow);
		List<Reservation> list = cs.list(reservation);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		String[] title = {"차량이름","제조사","예약날짜","렌트날짜","반납날짜"};
		model.addAttribute("title",title);
		model.addAttribute("reservation",reservation);
		model.addAttribute("num", num);
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
	    return "/reservation/reservationHistory";	
	}
	@RequestMapping("reservationInsertForm.do")
	public String reservationInsertForm() {
		return "/reservation/reservationInsertForm";
	}
	
	@RequestMapping("reservationInsert.do")
	public String reservationInsert(Car car,Reservation reservation, String pageNum, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면 입력한 데이터, member2 Db에 있는 데이터 중복여부 체크
		Car car2 = cs.select(car.getCarNo());
		
	}
	
}


