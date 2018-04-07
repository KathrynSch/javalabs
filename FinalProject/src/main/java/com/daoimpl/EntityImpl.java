package com.daoimpl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import com.daoapi.EntityDao;

@Repository("EntityDao")
@Transactional
public class EntityImpl<E> implements EntityDao<E>{
	
	@Autowired
    SessionFactory session;
	
	protected E entity;

	@Override
	public boolean saveOrUpdate(Object entity) {
		session.getCurrentSession().saveOrUpdate(entity);
		return true;
	}

	@Override
	public boolean delete(Object entity) {
		try {
            session.getCurrentSession().delete(entity);
        } catch (Exception ex) {
            return false;
        }
 
        return true;
	}
}
