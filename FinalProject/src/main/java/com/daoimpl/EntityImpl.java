package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import com.daoapi.EntityDao;

public class EntityImpl<E> implements EntityDao{
	
	protected E entity;

	@Override
	public boolean saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
