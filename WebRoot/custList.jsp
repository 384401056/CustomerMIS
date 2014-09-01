<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body style="text-align: center;">
	<h1>客户列表</h1><hr>
	<table border="1">
		
		<tr>
			<th>ID</th>
			<th>客户姓名</th>
			<th>客户姓别</th>
			<th>出生年月</th>
			<th>手机号码</th>
			<th>电子邮箱</th>
			<th>客户爱好</th>
			<th>客户类型</th>
			<th>客户描述</th>
		</tr>
		
		<c:forEach items="${requestScope.list}" var="cust">
		
			<tr>
				<td align="center"><c:out value="${cust.id}"/></td>
				<td align="left"><c:out value="${cust.name}"/></td>
				<td align="center"><c:out value="${cust.gender}"/></td>
				<td align="left"><c:out value="${cust.birthday}"/></td>
				<td align="left"><c:out value="${cust.cellphone}"/></td>
				<td align="left"><c:out value="${cust.email}"/></td>
				<td align="left"><c:out value="${cust.preference}"/></td>
				<td align="left"><c:out value="${cust.type}"/></td>
				<td align="left"><c:out value="${cust.description}"/></td>
				<td><a href="${pageContext.request.contextPath}/servlet/CustInfo?id=${cust.id}">修改</a></td>
			</tr>
		
		</c:forEach>
	
	</table>
</body>
</html>