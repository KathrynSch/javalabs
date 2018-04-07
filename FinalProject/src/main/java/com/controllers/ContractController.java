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

import com.entities.Contract;
import com.servicesapi.ContractService;
import com.entities.Child;
import com.servicesapi.ChildService;

@Controller
@RequestMapping("contract")
public class ContractController {
	
	@Autowired
	ContractService contractServices;
	
	@Autowired
	ChildService childServices;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view = new ModelAndView("contract");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Integer child_id, String first_name, String last_name, Integer age, Integer contract_id, Boolean is_regular, String start_date, String end_date, String email, String phone_nb) throws ParseException{
		System.out.println("function called");
		Map<String,Object> map = new HashMap<String,Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse_start_date = sdf.parse(start_date);
		Date parse_end_date = sdf.parse(end_date);
		
		
		Child child= new Child(child_id, first_name, last_name, age);
		Contract contract = new Contract( contract_id, is_regular,  parse_start_date,  parse_end_date,  email,  phone_nb);
		
		if(childServices.saveOrUpdate(child)){
			contract.setChild_id(child.getChild_id());
			if(contractServices.saveOrUpdate(contract)){
				map.put("status","200");
				map.put("message","Your record has been saved successfully");
			}
		}
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Contract contract){
		
		System.out.println("Function list called");
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
	
}
