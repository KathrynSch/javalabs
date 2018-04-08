package com.daoimpl;
 
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.ContractDao;
import com.daoimpl.EntityImpl;
import com.entities.Contract;
import com.entities.Child;
 
@Repository("ContractDao")
@Transactional
public class ContractImpl extends EntityImpl<Contract> implements ContractDao {
 
	 @Autowired
	    SessionFactory session;
	    
	    public List<Contract> list() {
	        return session.getCurrentSession().createQuery("from Contract").list();
	    }
	    
	    public List<Contract> getContractById(Integer contract_id) {
	    	Query query = session.getCurrentSession().createQuery("from Contract where contract_id = :contract_id");
	    	query.setParameter("contract_id", contract_id);
	    	return query.list();
	    }
	    
	    public List getTemporaryChildren(Date date){
	    	Query query = session.getCurrentSession().createSQLQuery("SELECT child.child_id, last_name, first_name FROM contract join child on child.child_id = contract.child_id where is_regular = 0 and start_date <= :date and end_date >= :date");
	    	query.setParameter("date", date);
	    	return query.list();
	    }
	    
	    public List<Contract> getContractByChild(Integer child_id){
	    	Query query = session.getCurrentSession().createQuery("from Contract where child_id = :child_id");
	    	query.setParameter("child_id", child_id);
	    	return query.list();
	    }
}