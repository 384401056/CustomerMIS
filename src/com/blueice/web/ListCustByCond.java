package com.blueice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import com.blueice.domain.Cust;
import com.blueice.factory.BasicFactory;
import com.blueice.service.CustService;

public class ListCustByCond extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		CustService service = BasicFactory.getFactory().getService();
		try{
			
			//1.封装数据和校验数据。
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			
			List<Cust> list = service.findCustBycond(cust);
			request.setAttribute("list", list);
			
			//3.请求转发到/servlet/ListCust页面。
			request.getRequestDispatcher("/custList.jsp").forward(request, response);
			return;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
