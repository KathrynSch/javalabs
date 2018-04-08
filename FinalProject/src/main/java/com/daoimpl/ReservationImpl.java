package com.daoimpl;
 
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.ReservationDao;
import com.daoimpl.EntityImpl;
import com.entities.Reservation;
 
@Repository("ReservationDao")
@Transactional
public class ReservationImpl extends EntityImpl<Reservation> implements ReservationDao {
 
    @Autowired
    SessionFactory session;
    
    public List<Reservation> list() {
        return session.getCurrentSession().createQuery("from Reservation").list();
    }
   
    public List getChildrenByDate(Date date, String period) {
    	Query query = session.getCurrentSession().createSQLQuery("SELECT child.child_id, first_name, last_name, age, reservation_id, absence FROM reservation join contract on reservation.contract_id = contract.contract_id join child on child.child_id = contract.child_id where at_date = :date and period_of_day = :period");
    	query.setParameter("date", date);
    	query.setParameter("period", period);
    	return query.list();
    }
    
    public List<Reservation> getReservationById(Integer reservation_id) {
    	Query query = session.getCurrentSession().createQuery("from Reservation where reservation_id = :reservation_id");
    	query.setParameter("reservation_id", reservation_id);
    	return query.list();
    }
    
    public Integer getChildrenAvailability( Date date, String period) {
    	Query query = session.getCurrentSession().createSQLQuery("select count(DISTINCT(child.child_id)) from reservation join contract on reservation.contract_id = contract.contract_id\r\n" + 
													    			"join child on child.child_id = contract.child_id\r\n" + 
													    			"where age >=2\r\n" + 
													    			"and reservation.at_date = :date \r\n" + 
													    			"and reservation.period_of_day = :period \r\n" + 
													    			"and absence =1");
    	query.setParameter("date", date);
    	query.setParameter("period", period);
    	List list = query.list();
    	return ((Number) list.get(0)).intValue();
    	
    }
    
    public Integer getBabyAvailability( Date date, String period) {
    	Query query = session.getCurrentSession().createSQLQuery("select count(DISTINCT(child.child_id)) from reservation join contract on reservation.contract_id = contract.contract_id\r\n" + 
													    			"join child on child.child_id = contract.child_id\r\n" + 
													    			"where age <2\r\n" + 
													    			"and reservation.at_date = :date \r\n" + 
													    			"and reservation.period_of_day = :period \r\n" + 
													    			"and absence =1");
    	query.setParameter("date", date);
    	query.setParameter("period", period);
    	List list = query.list();
    	return ((Number) list.get(0)).intValue();
    	
    }
    
    public int justifyAbsenceBetweenDates(Date start_date, Date end_date){
    	Query query = session.getCurrentSession().createQuery("UPDATE Reservation SET absence=3 where at_date >= :start_date and at_date <= :end_date ");
    	query.setParameter("start_date", start_date);
    	query.setParameter("end_date", end_date);
    	return query.executeUpdate();
	}
}