package com.blueice.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blueice.factory.BasicFactory;
import com.blueice.service.CustService;

public class BatchDel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		CustService service = BasicFactory.getFactory().getService();
		
		/*1.获取客户ids*/
		String[] ids = request.getParameterValues("delId");
		
		if(ids==null){
			/*重定向到ListCust Servlet*/
			response.sendRedirect(request.getContextPath()+"/servlet/ListCust");
			return;
		}
		
		/*调用service批量删除*/
		try {
			
			service.delCustByBatch(ids);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		/*重定向到ListCust Servlet*/
		response.sendRedirect(request.getContextPath()+"/servlet/ListCust");
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
