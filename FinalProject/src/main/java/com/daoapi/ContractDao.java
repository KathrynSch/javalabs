package com.daoapi;

import java.util.List;

import com.entities.Contract;

public interface ContractDao  extends EntityDao<Contract>{

	 public List<Contract> list();
	 public List<Contract> getContractFromId(Integer contract_id);
}