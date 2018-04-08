	package com.servicesimpl;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daoapi.PlannedAbsenceDao;
import com.entities.Plannedabsence;
import com.servicesapi.PlannedabsenceService;
 
@Service
public class PlannedabsenceServiceImpl implements PlannedabsenceService {
 
    @Autowired
    PlannedAbsenceDao plannedAbsenceDao;
 
    public boolean saveOrUpdate(Plannedabsence absence) {
        return plannedAbsenceDao.saveOrUpdate(absence);
    }
    
    public List getAllAbsences() {
    	return plannedAbsenceDao.getAllAbsences();
    }
}