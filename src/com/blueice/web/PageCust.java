package com.blueice.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blueice.domain.Page;
import com.blueice.factory.BasicFactory;
import com.blueice.service.CustService;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

public class PageCust extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		CustService service = BasicFactory.getFactory().getService();
		
		/*1.获取当前要显示的页，和每页记录数*/
		int thispage = Integer.parseInt(request.getParameter("thispage"));
		int rowperpage = 5;
		
		/*2.调用service中的分页查寻方法，查出客户记录。 */
		Page page = service.pageCust(thispage,rowperpage);
		request.setAttribute("page", page);
		
		/*3.请求转发到pageList.jsp页面。*/
		request.getRequestDispatcher("/pageList.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
