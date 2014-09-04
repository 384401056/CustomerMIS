<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
	function chekAll(allC){
	
		var otherCs = document.getElementsByName("delId");
		for(var i=0;i<otherCs.length;i++)
		{
			otherCs[i].checked = allC.checked;
		}
	}
	
</script>
</head>
<body style="text-align: center;">
	<h1>客户列表</h1><hr>
	
	<form action="${pageContext.request.contextPath}/servlet/ListCustByCond" method="POST">
	姓名：<input type="text" name="name" value="${param.name }"/>
	性别：
		<input type="radio" name="gender" value="男" <c:if test="${param.gender == '男'}"> checked="checked" </c:if> /> 男
		<input type="radio" name="gender" value="女" <c:if test="${param.gender == '女'}"> checked="checked" </c:if> /> 女
		<input type="radio" name="gender" value="" <c:if test="${param.gender == ''}"> checked="checked" </c:if> /> 无
	客服类型:
		<select name="type">
			<option value="" 
				<c:if test="${param.type=='' }">selected="selected"</c:if>  
			>无</option>
		
			<option value="钻石客户" 
				<c:if test="${param.type=='钻石客户' }">selected="selected"</c:if>  
			>钻石客户 </option>
			<option value="白金客户" 
				<c:if test="${param.type=='白金客户' }">selected="selected"</c:if>  
			>白金客户</option>
			<option value="黄金客户" 
				<c:if test="${param.type=='黄金客户' }">selected="selected"</c:if>  
			>黄金客户</option>
			<option value="白银客户" 
				<c:if test="${param.type=='白银客户' }">selected="selected"</c:if>  
			>白银客户</option>
			<option value="一般客户" 
				<c:if test="${param.type=='一般客户' }">selected="selected"</c:if>  
			>一般客户</option>
		</select>
		<input  type="submit" value="查询"/>
	</form>
	<br>
	<form action="${pageContext.request.contextPath}/servlet/BatchDel" method="POST">
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
			
			<c:forEach items="${requestScope.list}" var="cust">
			
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
		<input type="submit" value="批量删除"/>
	</form>
</body>
</html>