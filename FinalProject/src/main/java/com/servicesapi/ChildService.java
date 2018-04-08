package com.servicesapi;
 
import java.util.List;
import com.entities.Child;
 
public interface ChildService {
	
    public boolean saveOrUpdate(Child child);
 
    public List<Child> list();
 
    public boolean delete(Child child);
    
    public Child getChildById(Integer child_id);
}