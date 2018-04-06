package com.daoimpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.PlannedAbsenceDao;
import com.daoimpl.EntityImpl;
 
@Repository("PlannedAbsenceDao")
@Transactional
public class PlannedAbsenceImpl extends EntityImpl<PlannedAbsenceImpl> implements PlannedAbsenceDao {
 
    @Autowired
    SessionFactory session;
 
   
}