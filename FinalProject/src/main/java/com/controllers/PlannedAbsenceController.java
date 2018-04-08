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

import com.entities.Plannedabsence;
import com.entities.Child;
import com.entities.Contract;

import com.servicesapi.PlannedabsenceService;
import com.servicesapi.ReservationService;
import com.servicesapi.ContractService;
import com.servicesapi.ChildService;


@Controller
@RequestMapping("plannedAbsence")
public class PlannedAbsenceController {
	
	@Autowired
	PlannedabsenceService absenceServices;
	@Autowired
	ContractService contractServices;
	@Autowired
	ChildService childServices;
	@Autowired
	ReservationService reservationServices;
	
	@RequestMapping(value= "/listRegChildren", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getRegChildren(){
		Map<String,Object> map = new HashMap<String,Object>();
		
		List list = contractServices.getRegChildren();
				
		map.put("status","200");
		map.put("data", list);
		map.put("message","Your record have been deleted successfully");
		
		return map;
		
	}
	
	@RequestMapping(value= "/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAbsences(){
		Map<String,Object> map = new HashMap<String,Object>();
		
		List list = absenceServices.getAllAbsences();
				
		map.put("status","200");
		map.put("data", list);
		map.put("message","Your record have been deleted successfully");
		
		return map;
		
	}
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view =new ModelAndView("plannedAbsence");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Plannedabsence planned_absence){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(absenceServices.saveOrUpdate(planned_absence)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/planAbsence", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> planAbsence(Integer child_id, Integer planned_absence_id, String start_date, String end_date) throws ParseException{
		Map<String,Object> map = new HashMap<String,Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse_start_date = sdf.parse(start_date);
		Date parse_end_date = sdf.parse(end_date);
		
		Child child = childServices.getChildById(child_id);
		Contract contract = contractServices.getContractByChild(child_id).get(0);
		//update reservations to "justify" in absence period
		reservationServices.justifyAbsenceBetweenDates(parse_start_date, parse_end_date);
		Plannedabsence planned_absence = new Plannedabsence(planned_absence_id, contract.getContract_id(),parse_start_date, parse_end_date);
		
		return getSaved(planned_absence);
	}
	
	
}
