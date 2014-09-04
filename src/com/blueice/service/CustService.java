package com.blueice.service;

import java.sql.SQLException;
import java.util.List;

import com.blueice.domain.Cust;
import com.blueice.domain.Page;

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


	/**
	 * 删除客户信息。
	 * @param custId
	 */
	void delCust(String custId);


	/**
	 * 批量删除客户
	 * @param ids 客户id数组。
	 * @throws SQLException 
	 */
	void delCustByBatch(String[] ids);


	/**
	 * 根据条件查找用户。
	 * @param cust
	 * @return
	 */
	List<Cust> findCustBycond(Cust cust);


	/**
	 * 根据当前页，和每页多少条记录，来返回分页信息。
	 * @param thispage
	 * @param rowperpage
	 * @return
	 */
	Page pageCust(int thispage, int rowperpage);


}
