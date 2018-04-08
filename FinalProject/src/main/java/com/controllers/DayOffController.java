package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.DayOff;
import com.servicesapi.DayOffService;

@Controller
@RequestMapping("dayoff")
public class DayOffController {
	
	@Autowired
	DayOffService dayoffServices;
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view = new ModelAndView("dayoff");
		return view;
	}

	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(DayOff dayoff){
		Map<String,Object> map = new HashMap<String,Object>();

		if(dayoffServices.saveOrUpdate(dayoff)){
			map.put("status","200");
			map.put("message","Your record has been saved successfully");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(DayOff dayoff){
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<DayOff> list = dayoffServices.list();
			
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
	public @ResponseBody Map<String,Object> delete(DayOff dayoff){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(dayoffServices.delete(dayoff)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
	
}
