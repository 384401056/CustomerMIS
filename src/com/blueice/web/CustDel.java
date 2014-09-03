package com.blueice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blueice.factory.BasicFactory;
import com.blueice.service.CustService;

public class CustDel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String custId = request.getParameter("id");
		
		CustService service = BasicFactory.getFactory().getService();
		
		service.delCust(custId);
		
		response.sendRedirect(request.getContextPath()+"/servlet/ListCust");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
