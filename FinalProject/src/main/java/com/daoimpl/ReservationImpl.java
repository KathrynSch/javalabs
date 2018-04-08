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
   
    public List getChildrenFromDate(Date date, String period) {
    	Query query = session.getCurrentSession().createSQLQuery("SELECT child.child_id, first_name, last_name, age, reservation_id, absence FROM reservation join contract on reservation.contract_id = contract.contract_id join child on child.child_id = contract.child_id where at_date = :date and period_of_day = :period");
    	query.setParameter("date", date);
    	query.setParameter("period", period);
    	return query.list();
    }
}