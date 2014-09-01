package com.blueice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.blueice.domain.Cust;
import com.blueice.utils.DaoUtils;

public class MySqlDao implements CustDao {

	public MySqlDao() {

	}

	@Override
	public Cust findCustByName(String name) {
		try {
			String sqlStr = "SELECT * FROM customer where name=?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return runner.query(sqlStr, new BeanHandler<Cust>(Cust.class), name);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addCust(Cust customer) {
		try {
			
			String sqlStr = "INSERT INTO customer VALUES(null,?,?,?,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			runner.update(DaoUtils.getConnection(),sqlStr, 
					customer.getName(),
					customer.getGender(),
					customer.getBirthday(),
					customer.getCellphone(),
					customer.getEmail(),
					customer.getPreference(),
					customer.getType(),
					customer.getDescription());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public List<Cust> getAllCust() {
		try {
			
			String sqlStr = "SELECT * FROM customer";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return runner.query(sqlStr, new BeanListHandler<Cust>(Cust.class));
			
/* 手动实现 ResultSetHandler接口的方法. */
//			return runner.query(sqlStr, new ResultSetHandler<List<Cust>>(){
//				@Override
//				public List<Cust> handle(ResultSet rs) throws SQLException {
//					
//					List<Cust> list = new ArrayList<Cust>(); 
//
//					while(rs.next()){
//						Cust cust = new Cust();
//						cust.setId(rs.getInt("id"));
//						cust.setName(rs.getString("name"));
//						cust.setGender(rs.getString("gender"));
//						cust.setBirthday(rs.getDate("birthday"));
//						cust.setCellphone(rs.getString("cellphone"));
//						cust.setEmail(rs.getString("email"));
//						cust.setPreference(rs.getString("preference"));
//						cust.setType(rs.getString("type"));
//						cust.setDescription(rs.getString("description"));
//						
//						list.add(cust);
//					}
//
//					return list;
//				}
//				
//			});
			 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Cust findCustById(String custId) {
		try {
			String sqlStr = "SELECT * FROM customer WHERE id =?";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return runner.query(sqlStr, new BeanHandler<Cust>(Cust.class), custId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
















