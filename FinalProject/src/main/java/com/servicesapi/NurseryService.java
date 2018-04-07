package com.servicesapi;
 
import java.util.List;
import com.entities.Nursery;
 
public interface NurseryService {
    public boolean saveOrUpdate(Nursery nursery);
 
    public List<Nursery> list();
 
    public boolean delete(Nursery nursery);
}