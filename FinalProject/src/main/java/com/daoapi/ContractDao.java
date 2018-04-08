package com.daoapi;

import java.util.Date;
import java.util.List;

import com.entities.Child;
import com.entities.Contract;

public interface ContractDao  extends EntityDao<Contract>{

	 public List<Contract> list();
	 public List<Contract> getContractById(Integer contract_id);
	 public List getTemporaryChildren(Date date);
	 public List getRegularChildren();
	 public List<Contract> getContractByChild(Integer child_id);
}