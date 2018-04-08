package com.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.entities.Contract;
import com.servicesapi.ContractService;
import com.entities.Child;
import com.servicesapi.ChildService;
import com.entities.Reservation;
import com.servicesapi.ReservationService;

@Controller
@RequestMapping("contract")
public class ContractController {
	
	@Autowired
	ContractService contractServices;
	
	@Autowired
	ChildService childServices;
	
	@Autowired
	ReservationService reservationServices;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view = new ModelAndView("contract");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Integer child_id, String first_name, String last_name, Integer age, Integer contract_id, Boolean is_regular, String start_date, String end_date, String email, String phone_nb) throws ParseException{
		Map<String,Object> map = new HashMap<String,Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse_start_date = sdf.parse(start_date);
		Date parse_end_date = sdf.parse(end_date);
		
		
		Child child= new Child(child_id, first_name, last_name, age);
		
		if(childServices.saveOrUpdate(child)){
			Contract contract = new Contract(contract_id, child.getChild_id(), is_regular,  parse_start_date,  parse_end_date,  email,  phone_nb);
			if(contractServices.saveOrUpdate(contract)){
				map.put("status","200");
				map.put("contract_id", contract.getContract_id());
				map.put("message","Your record has been saved successfully");
			}
		}
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Contract contract){
		Map<String,Object> map = new HashMap<String,Object>();

		List<Contract> list = contractServices.list();
		
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
	public @ResponseBody Map<String,Object> delete(Contract contract){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(contractServices.delete(contract)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
	
	@RequestMapping(value="/regularReservation", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> makeRegularReservation(Integer contract_id, Integer reservation_id, String on_day1, String on_day2, String on_day3, String on_day4, String day_period1, String day_period2, String day_period3, String day_period4){
		Map<String,Object> map = new HashMap<String,Object>();
		
		ArrayList<String> day = new ArrayList<>();
		day.add(on_day1);
		day.add(on_day2);
		day.add(on_day3);
		day.add(on_day4);
		ArrayList<String> period = new ArrayList<>();
		period.add(day_period1);
		period.add(day_period2);
		period.add(day_period3);
		period.add(day_period4);
		
		System.out.println(day);
		System.out.println(period);
		
		//get contract object
		Contract contract = contractServices.getContractFromId(contract_id);
		
		Calendar start_date= Calendar.getInstance();
		start_date.setTime(contract.getStart_date());
		LocalDate contract_start_date = LocalDate.of(start_date.get(Calendar.YEAR), start_date.get(Calendar.MONTH), start_date.get(Calendar.DAY_OF_MONTH));
		contract_start_date = contract_start_date.minusDays(1);
		contract_start_date = contract_start_date.plusMonths(1);
		
		Calendar end_date= Calendar.getInstance();
		end_date.setTime(contract.getEnd_date());
		LocalDate contract_end_date = LocalDate.of(end_date.get(Calendar.YEAR), end_date.get(Calendar.MONTH), end_date.get(Calendar.DAY_OF_MONTH));
		contract_end_date = contract_end_date.plusMonths(1);
		System.out.println(end_date.get(Calendar.MONTH));
		System.out.println(contract_end_date);
		
		//for all reservation
		for(int i=0; i<4; i++)
		{
			LocalDate reservation_date = contract_start_date;
			while (reservation_date.isBefore(contract_end_date)){

				switch(day.get(i)) {
					case "Monday": {
						reservation_date = reservation_date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
						break;
						}
					case "Tuesday": {
						reservation_date = reservation_date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
						break;
						}
					case "Wednesday": {
						reservation_date = reservation_date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
						break;
						}
					case "Thursday": {
						reservation_date = reservation_date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
						break;
						}
					case "Friday": {
						reservation_date = reservation_date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
						break;
						}
					default: {
						reservation_date = contract_end_date; 
						break;
					}
				}
				if (reservation_date.isBefore(contract_end_date) || reservation_date.isEqual(contract_end_date)) {
					Reservation reservation = new Reservation(reservation_id, contract.getContract_id(), new Integer(1), Date.from(reservation_date.atStartOfDay(ZoneId.systemDefault()).toInstant()), period.get(i));
					reservationServices.saveOrUpdate(reservation);
				}		
			}
		}
		map.put("status","200");
		map.put("message","Reservation has been made successfully");
		return map;
	}

}