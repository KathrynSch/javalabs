	package com.servicesimpl;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daoapi.ContractDao;
import com.entities.Contract;
import com.servicesapi.ContractService;
 
@Service
public class ContractServiceImpl implements ContractService {
 
    @Autowired
    ContractDao contractDao;
 
    public boolean saveOrUpdate(Contract contract) {
        return contractDao.saveOrUpdate(contract);
    }
 
    public List<Contract> list() {
        return contractDao.list();
    }
 
    public boolean delete(Contract contract) {
        return contractDao.delete(contract);
    }
    
    public Contract getContractFromId(Integer contract_id) {
    	List<Contract> list = contractDao.getContractFromId(contract_id);
    	if(list.isEmpty())
    	{
    		return null;
    	}
    	else {
    		return list.get(0);
    	}
    }
 
}