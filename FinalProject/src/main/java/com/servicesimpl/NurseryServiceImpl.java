	package com.servicesimpl;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daoapi.NurseryDao;
import com.entities.Nursery;
import com.servicesapi.NurseryService;
 
@Service
public class NurseryServiceImpl implements NurseryService {
 
    @Autowired
    NurseryDao nurseryDao;
 
    public boolean saveOrUpdate(Nursery nursery) {
        return nurseryDao.saveOrUpdate(nursery);
    }
 
    public List<Nursery> list() {
        // TODO Auto-generated method stub
        return nurseryDao.list();
    }
 
    public boolean delete(Nursery nursery) {
        // TODO Auto-generated method stub
        return nurseryDao.delete(nursery);
    }
 
}