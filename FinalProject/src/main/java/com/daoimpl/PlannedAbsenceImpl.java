package com.daoimpl;
 
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.PlannedAbsenceDao;
import com.daoimpl.EntityImpl;
import com.entities.Plannedabsence;
 
@Repository("PlannedAbsenceDao")
@Transactional
public class PlannedAbsenceImpl extends EntityImpl<Plannedabsence> implements PlannedAbsenceDao {
 
    @Autowired
    SessionFactory session;
    
    public boolean saveOrUpdate(Plannedabsence absence) {
        session.getCurrentSession().saveOrUpdate(absence);

        return true;
    }

    public List getAllAbsences() {
    	Query query = session.getCurrentSession().createSQLQuery("SELECT child.last_name, child.first_name, plannedabsence.start_date, plannedabsence.end_date\r\n" + 
													    			"FROM `plannedabsence`\r\n" + 
													    			"join contract on plannedabsence.contract_id = contract.contract_id\r\n" + 
													    			"join child on child.child_id = contract.child_id");
    	
    	return query.list();
    	
    }
   
}