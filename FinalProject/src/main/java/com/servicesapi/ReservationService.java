package com.servicesapi;
 
import java.util.Date;
import java.util.List;
import com.entities.Reservation;
 
public interface ReservationService {
	
    public boolean saveOrUpdate(Reservation reservation);
 
    public List<Reservation> list();
 
    public boolean delete(Reservation reservation);
    
    public List listByDate(Date parse_date, String period);
    
    public List<Reservation> getReservationById(Integer reservation_id);
    
    public Integer getChildrenAvailability( Date date, String period) ;
    
    public Integer getBabyAvailability( Date date, String period);
    
    public int justifyAbsenceBetweenDates(Date start_date, Date  end_date);
}