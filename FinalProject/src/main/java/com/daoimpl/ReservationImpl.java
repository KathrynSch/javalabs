package com.daoimpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.ReservationDao;
import com.daoimpl.EntityImpl;
 
@Repository("ReservationDao")
@Transactional
public class ReservationImpl extends EntityImpl<ReservationImpl> implements ReservationDao {
 
    @Autowired
    SessionFactory session;
 
   
}