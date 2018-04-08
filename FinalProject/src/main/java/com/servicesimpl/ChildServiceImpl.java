	package com.servicesimpl;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daoapi.ChildDao;
import com.entities.Child;
import com.servicesapi.ChildService;
 
@Service
public class ChildServiceImpl implements ChildService {
 
    @Autowired
    ChildDao childDao;
 
    public boolean saveOrUpdate(Child child) {
        return childDao.saveOrUpdate(child);
    }
 
    public List<Child> list() {
        return childDao.list();
    }
 
    public boolean delete(Child child) {
        return childDao.delete(child);
    }
    
    public Child getChildById(Integer child_id) {
    	return childDao.getChildById(child_id);
    }
 
}