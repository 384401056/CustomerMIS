package com.blueice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blueice.domain.Cust;
import com.blueice.factory.BasicFactory;
import com.blueice.service.CustService;

public class ListCust extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		CustService service = BasicFactory.getFactory().getService();
		List<Cust> list = service.getAllCust();
		request.setAttribute("list", list);
		
		/*请求转发的地址前要加'/'*/
		request.getRequestDispatcher("/custList.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
