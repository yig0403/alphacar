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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ch.alphaCar.dto.Car;
import com.ch.alphaCar.service.CarService;
import com.ch.alphaCar.service.PagingBean;


@Controller
public class CarController {
	@Autowired
	private CarService cs;
    
	@RequestMapping("carList.do")
	public String list(Car car, String pageNum, Model model) {
		int rowPerPage = 16; // 한 화면에 보여주는 갯수
		if (pageNum == null || pageNum.equals("")) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int total = cs.getTotal(car);		
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		int num = total - startRow + 1;
		car.setStartRow(startRow);
		car.setEndRow(endRow);
		List<Car> list = cs.list(car);
		PagingBean pb = new PagingBean(currentPage, rowPerPage, total);
		String[] title = {"차량사진","차량이름","등급","제조사"};
		model.addAttribute("title",title);
		model.addAttribute("car",car);
		model.addAttribute("num", num);
		model.addAttribute("list", list);
		model.addAttribute("pb", pb);
		return "/car/carList";
	}
	
	@RequestMapping("carInsertForm.do")
	public String carInsertForm() {
		return "/car/carInsertForm";
	}
	
	@RequestMapping("carInsert.do")
	public String carInsert(Car car, String pageNum, Model model, HttpSession session) throws IOException {
		int result = 0;
		// member는 화면 입력한 데이터, member2 Db에 있는 데이터 중복여부 체크
		Car car2 = cs.select(car.getCarNo());
		String id = (String) session.getAttribute("id");
		car.setId(id);
		if (car2 == null) {
			String filename = car.getFile().getOriginalFilename();
			// 파일명을 변경하고 싶으면 UUID 또는 long으로 날자 데이터
			car.setFilename(filename);
			String real ="src/main/resources/static/carUpload";
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+filename));
			fos.write(car.getFile().getBytes());
			fos.close();
			result = cs.insert(car);
		} else result = -1;  // 이미 있으니 입력하지마
		model.addAttribute("result", result);
		return "/car/carInsert";
	}
	
	@RequestMapping(value = "carNoChk.do", produces = "text/html;charset=utf-8")
	@ResponseBody   // jsp로 가지말고 바로 본문을 전달
	public String carNoChk(String carNo, Model model) {
		String msg = "";
		Car car = cs.select(carNo);
		if (car == null) msg = "입력가능한 차량 번호입니다.";
		else msg = "이미 등록된 차량 번호입니다.";
		return msg;
	}
	
	
	@RequestMapping("carView.do")
	public String carView(String carNo,String pageNum,Model model,HttpSession session) {
		String id = (String)session.getAttribute("id");	
		Car car = cs.select(carNo);
		model.addAttribute("car", car);
		model.addAttribute("pageNum", pageNum);
		return "/car/carView";
	}
	
	@RequestMapping("carUpdateForm.do")
	public String carUpdateForm(String carNo, String pageNum, Model model) {
		Car car = cs.select(carNo);
		model.addAttribute("car", car);
		model.addAttribute("pageNum", pageNum);
		return "/car/carUpdateForm";
	}
	@RequestMapping("carUpdate.do")
	public String carUpdate(Car car,String pageNum, Model model) throws IOException {
		int result = 0;
		Car car2 = cs.select(car.getCarNo());
		// 사진을 수정할 수도 안할 수도 있다(안하면 fileName이 null 또는 공란)
		String filename = car.getFile().getOriginalFilename();
		if (filename != null && !filename.equals("")) {
			car.setFilename(filename);
			String real = "src/main/resources/static/carUpload";
			FileOutputStream fos = new FileOutputStream(new File(real+"/"+filename));
			fos.write(car.getFile().getBytes());
			fos.close();
		}
		result = cs.update(car);
		model.addAttribute("result", result);
		model.addAttribute("pageNum", pageNum);
		return "/car/carUpdate";
	}
	@RequestMapping("carDelete.do")
	public String carDelete(Car car,String pageNum ,Model model) {
		int result = 0;
		Car car2 = cs.select(car.getCarNo());
		if( car2 != null) {
		result = cs.delete(car.getCarNo());
		}else result = -1;
		model.addAttribute("result", result);
		model.addAttribute("pageNum,", pageNum);
		return "/car/carDelete";
	}
	
	@RequestMapping("carDeleteForm.do")
	public String deleteForm(String carNo, String pageNum,  Model model) {
		model.addAttribute("carNo", carNo);
		model.addAttribute("pageNum", pageNum);
		return "/car/carDeleteForm";
	}


}
