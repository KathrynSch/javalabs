	package com.servicesimpl;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.DayOffDao;
import com.entities.DayOff;
import com.servicesapi.DayOffService;

@Service
public class DayOffServiceImpl implements DayOffService {
 
    @Autowired
    DayOffDao dayoffDao;
 
    public boolean saveOrUpdate(DayOff dayoff) {
        return dayoffDao.saveOrUpdate(dayoff);
    }
 
    public List<DayOff> list() {
        // TODO Auto-generated method stub
        return dayoffDao.list();
    }
 
    public boolean delete(DayOff dayoff) {
        // TODO Auto-generated method stub
        return dayoffDao.delete(dayoff);
    }
 
}