package com.daoapi;

import java.util.Date;
import java.util.List;

import com.entities.Plannedabsence;

public interface PlannedAbsenceDao {
	 public boolean saveOrUpdate(Plannedabsence absence);
	 public List getAllAbsences();
    
}