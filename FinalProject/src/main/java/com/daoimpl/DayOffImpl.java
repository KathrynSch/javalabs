package com.daoimpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.DayOffDao;
import com.daoimpl.EntityImpl;
import com.entities.DayOff;
 
@Repository("DayOffDao")
@Transactional
public class DayOffImpl extends EntityImpl<DayOff> implements DayOffDao {
 
    @Autowired
    SessionFactory session;
    public List<DayOff> list() {
        return session.getCurrentSession().createQuery("from DayOff").list();
    }
   
   
}