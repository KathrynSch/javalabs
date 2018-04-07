package com.daoapi;

import java.util.List;

import com.entities.Child;
import com.entities.Nursery;

public interface NurseryDao extends EntityDao<Nursery>{

	public List<Nursery> list();
}