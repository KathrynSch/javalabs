package com.servicesapi;
 
import java.util.Date;
import java.util.List;
import com.entities.Reservation;
 
public interface ReservationService {
	
    public boolean saveOrUpdate(Reservation reservation);
 
    public List<Reservation> list();
 
    public boolean delete(Reservation reservation);
    
    public List listFromDate(Date parse_date, String period);
}