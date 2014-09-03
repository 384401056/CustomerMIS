package com.blueice.test;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.blueice.utils.DaoUtils;

public class TestCust {

	@Test
	public void addCust(){
		try {
			
			String sqlStr = "INSERT INTO customer VALUES(null,?,?,?,?,?,?,?,?)";
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			
			for(int i=0;i<100;i++){
				runner.update(sqlStr, 
						"name"+i,
						"男",
						"1985-05-06",
						"168985758485",
						"name"+i+"@qq.com",
						"蓝球,足球,乒乓球,网球,羽毛球",
						"钻石客户",
						"这是一个批量添加的客户。");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
