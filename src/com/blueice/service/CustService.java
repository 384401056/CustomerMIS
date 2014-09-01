package com.blueice.service;

import java.util.List;

import com.blueice.domain.Cust;

public interface CustService{

	/**
	 * 添加用户。
	 */
	void addCust(Cust customer);

	
	/**
	 * 查询用户列表。
	 */
	List<Cust> getAllCust();


	/**
	 * 根据Id查找客户。
	 * @param custId  客户Id
	 */
	Cust findCustById(String custId);

	
	/**
	 * 修改客户信息
	 * @param cust 客户Bean 
	 */
	void updataCust(Cust cust);


}
