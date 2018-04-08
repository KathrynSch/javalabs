package com.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Child;
import com.entities.Contract;
import com.servicesapi.ChildService;
import com.entities.Reservation;
import com.servicesapi.ReservationService;
import com.servicesapi.ContractService;


@Controller
@RequestMapping("reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationServices;
	@Autowired
	ContractService contractServices;
	@Autowired
	ChildService childServices;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view = new ModelAndView("reservation");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Reservation reservation){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(reservationServices.saveOrUpdate(reservation)){
			map.put("status","200");
			map.put("message","Your record has been saved successfully");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/listByDate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAllByDate(String date, String period) throws ParseException{
		Map<String,Object> map = new HashMap<String,Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse_date = sdf.parse(date);
	
		List<Object[]> list = reservationServices.listByDate(parse_date, period);
		
		if (list != null){
			map.put("status","200");
			map.put("message","Data found");
			map.put("data", list);
		}else{
			map.put("status","404");
			map.put("message","Data not found");
			
		}
	
		return map;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(Reservation reservation){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(reservationServices.delete(reservation)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
	
	@RequestMapping(value="/updateAbsence", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> updateAbsence(Integer state, Integer reservation_id){
		Map<String,Object> map = new HashMap<String,Object>();
		
		System.out.println(state);		
		Reservation reservation = reservationServices.getReservationById(reservation_id).get(0);
		reservation.setAbsence(state);
		
		return getSaved(reservation);
	}
	
	@RequestMapping(value= "/listTempChildren", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getTempChildren(String date) throws ParseException{
		Map<String,Object> map = new HashMap<String,Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse_date = sdf.parse(date);
		
		List list = contractServices.getTempChildren(parse_date);
				
		map.put("status","200");
		map.put("data", list);
		map.put("message","Your record have been deleted successfully");
		
		return map;
		
	}
	
	@RequestMapping(value= "/addTempReservation", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> addTempReservation(Integer child_id, Integer reservation_id, String date, String period) throws ParseException{
		Map<String,Object> map = new HashMap<String,Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse_date = sdf.parse(date);
		
		Child child = childServices.getChildById(child_id);
		Contract contract = contractServices.getContractByChild(child_id).get(0);
		
		if (child.getAge()>=2)
		{
			if(reservationServices.getChildrenAvailability(parse_date, period) >0) {
				System.out.println(reservationServices.getChildrenAvailability(parse_date, period));
				Reservation reservation = new Reservation(reservation_id, contract.getContract_id(), new Integer(1), parse_date, period);
				getSaved(reservation);
				map.put("status","200");
				map.put("message","Reservation successfully");
			}
			else {
				map.put("status","400");
				map.put("message","Period fully booked for children");
			}
		}
		else {
			if(reservationServices.getBabyAvailability(parse_date, period) >0) {
				System.out.println(reservationServices.getBabyAvailability(parse_date, period));
				Reservation reservation = new Reservation(reservation_id, contract.getContract_id(), new Integer(1), parse_date, period);
				getSaved(reservation);
				map.put("status","200");
				map.put("message","Reservation successfully");
			}
			else {
				map.put("status","400");
				map.put("message","Period fully booked for babies");
			}
		}
		return map;
		
	}
	
}
