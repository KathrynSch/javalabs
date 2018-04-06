package com.daoimpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.DayoffDao;
import com.daoimpl.EntityImpl;
 
@Repository("DayoffDao")
@Transactional
public class DayoffImpl extends EntityImpl<DayoffImpl> implements DayoffDao {
 
    @Autowired
    SessionFactory session;
 
   
}