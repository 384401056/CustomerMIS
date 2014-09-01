package com.blueice.factory;

import java.io.FileReader;
import java.util.Properties;

import com.blueice.dao.CustDao;

public class DaoFactory {
	
	private static DaoFactory factory = new DaoFactory();
	private static Properties prop = null;
	
	static{

		try {
			
			prop = new Properties();
			prop.load(new FileReader(DaoFactory.class.getClassLoader().getResource("config.properties").getPath()));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	private DaoFactory() {

	}
	
	
	public static DaoFactory getFactory(){
		return factory;
	}
	
	public static CustDao getDao(){
		
		try {
			
			String clazz = prop.getProperty("Dao");
			return (CustDao)Class.forName(clazz).newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	
	
}






















