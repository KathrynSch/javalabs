package com.daoapi;

import java.util.Date;
import java.util.List;

import com.entities.Reservation;

public interface ReservationDao extends EntityDao<Reservation>{

	 public List<Reservation> list();
	 public List getChildrenFromDate(Date date, String period);
}