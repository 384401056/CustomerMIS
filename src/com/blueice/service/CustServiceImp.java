package com.blueice.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.blueice.dao.CustDao;
import com.blueice.domain.Cust;
import com.blueice.domain.Page;
import com.blueice.factory.BasicFactory;
import com.blueice.utils.DaoUtils;

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
		if(dao.updataCust(cust)<0){
			throw new RuntimeException("更新数据失败。");
		}
	}

	@Override
	public void delCust(String custId) {
		if(dao.delCust(custId)<0){
			throw new RuntimeException("删除数据失败。");
		}
	}

	@Override
	public void delCustByBatch(String[] ids) {
		
		Connection conn = DaoUtils.getConnection();
		
		try {
			conn.setAutoCommit(false);
			
			for(String id:ids){
				
				dao.delCustByIdWithTrans(conn,id);
				
			}
			
			DbUtils.commitAndCloseQuietly(conn);

		} catch (SQLException e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Cust> findCustBycond(Cust cust) {
		return dao.findCustByCond(cust);
	}

	@Override
	public Page pageCust(int thispage, int rowperpage) {
		
		Page page = new Page();
		int countRow = dao.CustCountRow();
		int countPage = countRow/rowperpage+(countRow%rowperpage==0?0:1);
		
		page.setThisPage(thispage);
		page.setRowperPage(rowperpage);
		page.setCountRow(countRow);
		page.setCountPage(countPage);
		page.setFirstPage(1);
		page.setLastPage(countPage);
		page.setPrevPage(thispage==1?thispage:thispage-1);
		page.setNextPage(thispage==countPage?thispage:thispage+1);
		
		
		page.setList(dao.pageCust((thispage-1)*rowperpage,rowperpage));
		
		return page;
	}

}














