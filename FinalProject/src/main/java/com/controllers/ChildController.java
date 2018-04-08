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

import com.entities.Child;
import com.servicesapi.ChildService;

@Controller
@RequestMapping("child")
public class ChildController {
	
	@Autowired
	ChildService childServices;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view = new ModelAndView("child");
		return view;
	}

<<<<<<< HEAD
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Child child){
=======
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)		
	public @ResponseBody Map<String, Object> getSaved(Child child){

>>>>>>> c4990cebc882ba7bc0daf8cb738ebb8feea3b494
       Map<String,Object> map = new HashMap<String,Object>();
 
		if(childServices.saveOrUpdate(child)){
			map.put("status","200");
			map.put("message","Your record has been saved successfully");
		}
		
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Child child){
		Map<String,Object> map = new HashMap<String,Object>();
	
			List<Child> list = childServices.list();
			
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
	public @ResponseBody Map<String,Object> delete(Child child){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(childServices.delete(child)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
	
}
