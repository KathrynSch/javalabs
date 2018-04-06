package com.daoapi;

import java.util.List;



public interface EntityDao<E> {

	 	public boolean saveOrUpdate(E entity);
	 
	    public List<E> list();
	 
	    public boolean delete(E entity);
}

