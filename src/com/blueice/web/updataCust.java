package com.blueice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import com.blueice.domain.Cust;
import com.blueice.factory.BasicFactory;
import com.blueice.service.CustService;

public class updataCust extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CustService service = BasicFactory.getFactory().getService();
		
		Cust customer = new Cust();
		
		//1.封装数据和校验数据。
		try {
			//封装数据
			BeanUtils.populate(customer, request.getParameterMap());
			
			//对 preference 字段的外理，将各个爱好拼接成xxx,yy,zz的形式。
			String[] prefes= request.getParameterValues("preference");
			StringBuffer buffer = new StringBuffer();
			for(String pref:prefes){
				buffer = buffer.append(pref+",");
			}
			String preference = buffer.substring(0, buffer.length()-1);
			
			customer.setPreference(preference);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		
		//2.通过Service更新数据到数据库。
		service.updataCust(customer);

		
		//3.请求转发到/servlet/ListCust页面。
		request.getRequestDispatcher("/servlet/ListCust").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
