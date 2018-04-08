package com.servicesapi;

import java.util.List;
import com.entities.DayOff;
 
public interface DayOffService {
    public boolean saveOrUpdate(DayOff dayoff);
 
    public List<DayOff> list();
 
    public boolean delete(DayOff dayoff);
}
