package com.servicesapi;
 
import java.util.List;
import com.entities.Plannedabsence;
 
public interface PlannedabsenceService {
	
    public boolean saveOrUpdate(Plannedabsence absence);
    public List getAllAbsences();

}