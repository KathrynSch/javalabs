package com.servicesapi;
 
import java.util.Date;
import java.util.List;

import com.entities.Child;
import com.entities.Contract;
 
public interface ContractService {
	
    public boolean saveOrUpdate(Contract child);
 
    public List<Contract> list();
 
    public boolean delete(Contract child);
    
    public Contract getContractById(Integer contract_id);
    
    public List getTempChildren(Date date);
    
    public List<Contract> getContractByChild(Integer child_id);
}