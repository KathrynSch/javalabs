package com.daoimpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.ContractDao;
import com.daoimpl.EntityImpl;
 
@Repository("ContractDao")
@Transactional
public class ContractImpl extends EntityImpl<ContractImpl> implements ContractDao {
 
    @Autowired
    SessionFactory session;
 
   
}