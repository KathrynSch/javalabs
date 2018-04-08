package com.daoimpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.DayoffDao;
import com.daoimpl.EntityImpl;
import com.entities.Dayoff;
 
@Repository("DayOffDao")
@Transactional
public class DayoffImpl extends EntityImpl<Dayoff> implements DayoffDao {
 
    @Autowired
    SessionFactory session;
    public List<Dayoff> list() {
        return session.getCurrentSession().createQuery("from DayOff").list();
    }
   
   
}