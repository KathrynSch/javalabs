	package com.servicesimpl;
 
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daoapi.ReservationDao;
import com.entities.Reservation;
import com.servicesapi.ReservationService;
 
@Service
public class ReservationServiceImpl implements ReservationService {
 
    @Autowired
    ReservationDao reservationDao;
 
    public boolean saveOrUpdate(Reservation reservation) {
        return reservationDao.saveOrUpdate(reservation);
    }
 
    public List<Reservation> list() {
        return reservationDao.list();
    }
 
    public boolean delete(Reservation reservation) {
        return reservationDao.delete(reservation);
    }
    
    public List listByDate(Date date, String period) {
    	return reservationDao.getChildrenByDate(date, period);
    }
    
    public List<Reservation> getReservationById(Integer reservation_id) {
    	return reservationDao.getReservationById(reservation_id);
    }
    
    public Integer getChildrenAvailability( Date date, String period) {
    	return (20-reservationDao.getChildrenAvailability( date, period));
    }
    
    public Integer getBabyAvailability( Date date, String period) {
    	return (5-reservationDao.getBabyAvailability( date, period));
    }
}