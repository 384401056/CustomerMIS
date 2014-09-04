package com.blueice.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import com.blueice.domain.Cust;
import com.blueice.factory.BasicFactory;
import com.blueice.service.CustService;

/**
 * 添加客户的servlet
 */
public class AddCustServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
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
		
		
		
		//2.通过Service保存数据到数据库。
		CustService service = BasicFactory.getFactory().getService();
		
		service.addCust(customer);
		
		//3.重定向到主页。
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return;
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
