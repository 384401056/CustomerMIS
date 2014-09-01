package com.blueice.dao;

import java.util.List;

import com.blueice.domain.Cust;

public interface CustDao {
	/**
	 * 根据姓名查找客户是否存在，存在返回客户Bean，否则返回null;
	 * @param name 姓名
	 */
	Cust findCustByName(String name);

	/**
	 * 添加用户到数据库。
	 * @param customer 客户Bean
	 */
	void addCust(Cust customer);

	
	/**
	 * 查询客户列表。
	 * @return 客户列表
	 */
	List<Cust> getAllCust();

	
	/**
	 * 根据Id查找客户。
	 * @return 客户Bean
	 */
	Cust findCustById(String custId);
}
