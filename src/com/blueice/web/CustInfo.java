package com.blueice.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blueice.domain.Cust;
import com.blueice.factory.BasicFactory;
import com.blueice.service.CustService;

public class CustInfo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String custId = request.getParameter("id");
		
		CustService service = BasicFactory.getFactory().getService();
		
		Cust cust = service.findCustById(custId);
		
		if(cust!=null){
			
			request.setAttribute("cust", cust);
			request.getRequestDispatcher("/custUpdata.jsp").forward(request,response);
			
		}else{
			throw new RuntimeException("没有找到客户。");
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
