package com.blueice.service;

import java.util.List;
import com.blueice.dao.CustDao;
import com.blueice.domain.Cust;
import com.blueice.factory.BasicFactory;

public class CustServiceImp implements CustService {

	
	private static CustDao dao = BasicFactory.getFactory().getDao();
	
	@Override
	public void addCust(Cust customer) {
		
		if(dao.findCustByName(customer.getName())==null){
			
			dao.addCust(customer);
			
		}else{
			
			throw new RuntimeException("用户名已经存在。");
			
		}
		
	}

	@Override
	public List<Cust> getAllCust() {
		return dao.getAllCust();
	}

	
	@Override
	public Cust findCustById(String custId) {
		
		return dao.findCustById(custId);
		
	}

	@Override
	public void updataCust(Cust cust) {
		dao.updataCust(cust);
	}

}
