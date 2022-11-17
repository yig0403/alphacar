package com.ch.alphaCar.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.alphaCar.dto.Car;
import com.ch.alphaCar.dto.Member;
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
	
	
	@RequestMapping("reservationSearch.do")
	public String reservationSearch() {
		return "/reservation/reservationSearch";
	}
	
	@RequestMapping("reservationHistory.do")
	public String reservationHistory(Reservation reservation, String pageNum, Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		reservation.setId(id);
		int rowPerPage = 10; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = rs.getTotal(reservation);		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		reservation.setStartRow(startRow);
		reservation.setEndRow(endRow);
		List<Reservation> list = rs.list(reservation);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);

		model.addAttribute("reservation",reservation);
		model.addAttribute("num", num);
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
	    return "/reservation/reservationHistory";	
	}
	@RequestMapping("reservationView.do")
	public String reservationView(Reservation reservaiton,Model model) {
		return "/reservation/reservationView";
	}
	
	@RequestMapping("reservationInsertForm.do")
	public String carInsertForm() {
		return "/reservation/reservationInsertForm";
	}
	

	@SuppressWarnings("unused")
	@RequestMapping("reservation.do")
	public String reservationInsert(Date startDate,Date endDate, String carNo, String pageNum, Model model, HttpSession session, Reservation reservation) throws IOException {
		int result = 0;
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		int getMaxNum=rs.getMaxNum();
		reservation.setRsNo(getMaxNum);
		Reservation reservation2 = rs.select(reservation.getRsNo());
		Car car = cs.select(carNo);
		String id = (String) session.getAttribute("id");
		reservation.setId(id);
		Date todate = java.sql.Date.valueOf(today);
		if (reservation2 == null) {
			 if(todate.before(startDate) && todate.before(endDate) && endDate.after(startDate)) {	 
						 result = rs.insert(reservation);
						 cs.update1(reservation.getCarNo());  
				  }	 
		} else result = -1;  // 이미 있으니 입력하지마
		
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "/reservation/reservation";
	}
	
	@RequestMapping("reservationDelete.do")
	public String reservationDelete(Reservation reservation,String pageNum ,Model model) {
		int result = 0;
		Reservation reservation2 = rs.select(reservation.getRsNo());
		if( reservation2 != null) {
		result = rs.delete(reservation2.getRsNo());
		}else result = -1;
		model.addAttribute("result", result);
		model.addAttribute("pageNum,", pageNum);
		return "/reservation/reservationDelete";
	}
	
	@RequestMapping("reservationDeleteForm.do")
	public String reservationDeleteForm(int rsNo, String pageNum,  Model model) {
		model.addAttribute("rsNo", rsNo);
		model.addAttribute("pageNum", pageNum);
		return "/reservation/reservationDeleteForm";
	}

	
	@RequestMapping("reservationReturn.do")
	public String reservationReturn(Reservation reservation,String pageNum ,Model model,String carNo) {
		int result = 0;
		Reservation reservation2 = rs.select(reservation.getRsNo());
		System.out.println(reservation.getCarNo());
		
		if( reservation2 != null) {
			result = rs.update1(reservation2.getRsNo());

		}else result = -1;
		model.addAttribute("result", result);
		model.addAttribute("pageNum,", pageNum);
		return "/reservation/reservationReturn";
	}
	
	@RequestMapping("reservationReturnForm.do")
	public String reservationReturnForm(String carNo, int rsNo, String pageNum,  Model model) {
		model.addAttribute("rsNo", rsNo);
		model.addAttribute("pageNum", pageNum);
		return "/reservation/reservationReturnForm";
	}
}


