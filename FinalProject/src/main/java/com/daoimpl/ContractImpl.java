package com.daoimpl;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.ContractDao;
import com.daoimpl.EntityImpl;
import com.entities.Contract;
 
@Repository("ContractDao")
@Transactional
public class ContractImpl extends EntityImpl<Contract> implements ContractDao {
 
	 @Autowired
	    SessionFactory session;
	    
	    public List<Contract> list() {
	        return session.getCurrentSession().createQuery("from Contract").list();
	    }
	    
	    public List<Contract> getContractFromId(Integer contract_id) {
	    	Query query = session.getCurrentSession().createQuery("from Contract where contract_id = :contract_id");
	    	query.setParameter("contract_id", contract_id);
	    	return query.list();
	    }
}