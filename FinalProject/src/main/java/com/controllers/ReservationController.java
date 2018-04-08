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
import com.servicesapi.ChildService;
import com.entities.Reservation;
import com.servicesapi.ReservationService;


@Controller
@RequestMapping("reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationServices;
	
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
	
	
	@RequestMapping(value="/listFromDate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAllfromDate(String date, String period) throws ParseException{
		Map<String,Object> map = new HashMap<String,Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse_date = sdf.parse(date);
	
			List list = reservationServices.listFromDate(parse_date, period);
			
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
	
}
