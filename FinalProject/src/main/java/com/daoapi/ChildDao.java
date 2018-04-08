package com.daoapi;

import java.util.List;

import com.entities.Child;

public interface ChildDao extends EntityDao<Child>{

	 public List<Child> list();
	 
	 public Child getChildById(Integer child_id);
}