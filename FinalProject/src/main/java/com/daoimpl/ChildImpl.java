package com.daoimpl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daoapi.ChildDao;
import com.daoimpl.EntityImpl;
 
@Repository("ChildDao")
@Transactional
public class ChildImpl extends EntityImpl<ChildImpl> implements ChildDao {
 
    @Autowired
    SessionFactory session;
 
   
}