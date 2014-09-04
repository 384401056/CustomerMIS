<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  </head>
  
<body style="text-align: center;">
	<h1>客户列表</h1><hr>
		<table border="1">
			
			<tr>
				<th><input type="checkbox" onclick="chekAll(this)"/>全选</th> 
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
			
			<c:forEach items="${page.list}" var="cust">
			
				<tr>
					<td align="center"><input type="checkbox" name="delId" value="${cust.id}"/></td>
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
					<td><a href="${pageContext.request.contextPath}/servlet/CustDel?id=${cust.id}">删除</a></td>
				</tr>
			
			</c:forEach>
		</table>
		<br>
		当前第${page.thisPage}页 
		
		<a href="${pageContext.request.contextPath }/servlet/PageCust?thispage=${page.firstPage}">首页</a>
		<a href="${pageContext.request.contextPath }/servlet/PageCust?thispage=${page.prevPage}">上一页</a>

		<c:if test="${page.countPage<=5 }">
			<c:set var="begin" value="1" scope="page"/>
			<c:set var="end" value="${page.countPage}" scope="page"/>
		</c:if>
		
		<c:if test="${page.countPage>5 }">
			<c:choose>
				<c:when test="${page.thisPage<=3}">
					<c:set var="begin" value="1" scope="page"/>
					<c:set var="end" value="5" scope="page"/>
				</c:when>
				
				<c:when test="${page.thisPage>=(page.countPage-2)}">
					<c:set var="begin" value="${page.countPage - 4}" scope="page"/>
					<c:set var="end" value="${page.countPage }" scope="page"/>
				</c:when>
				
				<c:otherwise>
					<c:set var="begin" value="${page.thisPage-2}" scope="page"/>
					<c:set var="end" value="${page.thisPage+2}" scope="page"/>
				</c:otherwise>
			</c:choose>
		</c:if>
		
		<c:forEach begin="${begin}" end="${end}" step="1" var="i">
			<c:if test="${i==page.thisPage }">
				${i }
			</c:if>
			<c:if test="${i!=page.thisPage }">
				<a href="${pageContext.request.contextPath }/servlet/PageCust?thispage=${i}">${i}</a>
			</c:if>
		</c:forEach>


		<a href="${pageContext.request.contextPath }/servlet/PageCust?thispage=${page.nextPage}">下一页</a>
		<a href="${pageContext.request.contextPath }/servlet/PageCust?thispage=${page.lastPage}">尾页</a>
		
		共${page.countRow }条记录
		共${page.countPage }页
		
</body>
</html>
















