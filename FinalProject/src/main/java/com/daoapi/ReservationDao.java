package com.daoapi;

import java.util.Date;
import java.util.List;

import com.entities.Reservation;

public interface ReservationDao extends EntityDao<Reservation>{

	 public List<Reservation> list();
	 public List getChildrenByDate(Date date, String period);
	 public List<Reservation> getReservationById(Integer reservation_id);
	 public Integer getChildrenAvailability(Date date, String period);
	 public Integer getBabyAvailability( Date date, String period);
	public int justifyAbsenceBetweenDates(Date start_date, Date end_date);

	    
}