<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<h1>客户管理系统主页</h1><hr>

	<a href="${pageContext.request.contextPath}/addCust.jsp">添加客户</a>
	
	<a href="${pageContext.request.contextPath}/servlet/ListCust">查看客户列表</a>
	
</body>
</html>