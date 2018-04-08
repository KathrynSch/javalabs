package com.daoapi;

import java.util.List;

import com.entities.DayOff;

public interface DayOffDao extends EntityDao<DayOff>{

	 public List<DayOff> list();
}