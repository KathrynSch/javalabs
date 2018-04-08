package com.daoimpl;
 
import java.util.List;
 
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
   
}