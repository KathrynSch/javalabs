package com.daoapi;

import java.util.List;

import com.entities.Dayoff;

public interface DayoffDao extends EntityDao<Dayoff>{

	 public List<Dayoff> list();
}