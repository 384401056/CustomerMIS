<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
<body style="text-align: center;">

	<h1>客户管理系统--修改客户</h1><hr>
	
	<form action="${pageContext.request.contextPath}/servlet/updataCust" method="POST">
		<input type="hidden" name="id" value="<c:out value="${cust.id}"/>" />
	<table border="1">
		<tr>
			<td>客户姓名：</td>
			<td align="left"> <input type="text" name="name" style="background-color: silver;" readonly="readonly"
				value="<c:out value="${cust.name}"/>"/> </td>
		</tr>
		<tr>
			<td>客户性别：</td>
			<td align="left">
				<input type="radio" name="gender" value="男" <c:if test="${cust.gender == '男'}"> checked="checked" </c:if> /> 男
				<input type="radio" name="gender" value="女" <c:if test="${cust.gender == '女'}"> checked="checked" </c:if> /> 女
			</td>
		</tr>
		<tr>
			<td>出生年月：</td>
			<td align="left"> <input type="text" name="birthday" value="<c:out value="${cust.birthday}"/>"/> </td>
		</tr>
		
		<tr>
			<td>手机号码：</td>
			<td align="left"><input type="text" name="cellphone" value="<c:out value="${cust.cellphone}"/>"/></td>
		</tr>
		
		<tr>
			<td>电子邮箱：</td>
			<td align="left"><input type="text" name="email" value="<c:out value="${cust.email}"/>"/></td>
		</tr>
		
		<tr>
			<td>爱好：</td>
			<td align="left">
			
				<!-- 使用 c:roTokens标签循环迭代，来判断preference中是否包含某个字符。 -->
				<input type="checkbox" name="preference" value="蓝球" 
				
				<c:forTokens items="${cust.preference}" delims="," var="pref">
					<c:if test="${pref=='蓝球'}">
						checked="checked"
					</c:if> 
				</c:forTokens>
				/>蓝球
				
				<!-- 使用 fn:contains 来查看字符串中是否包含某个字符。 -->
				<input type="checkbox" name="preference" value="足球"
					<c:if test="${fn:contains(cust.preference,'足球')}">
						checked="checked"
					</c:if> 
				/>足球
				
				<input type="checkbox" name="preference" value="乒乓球"
					<c:if test="${fn:contains(cust.preference,'乒乓球')}">
						checked="checked"
					</c:if> 
				/>乒乓球
				
				
				<input type="checkbox" name="preference" value="网球"
					<c:if test="${fn:contains(cust.preference,'网球')}">
						checked="checked"
					</c:if> 				
				/>网球
				
				<input type="checkbox" name="preference" value="羽毛球"
					<c:if test="${fn:contains(cust.preference,'羽毛球')}">
						checked="checked"
					</c:if> 	
				/>羽毛球
			</td>
		</tr>
		
		<tr>
			<td>客户类型：</td>
			<td align="left">
				<select name="type">
					<option value="钻石客户" 
						<c:if test="${cust.type=='钻石客户' }">selected="selected"</c:if>  
					>钻石客户 </option>
					<option value="白金客户" 
						<c:if test="${cust.type=='白金客户' }">selected="selected"</c:if>  
					>白金客户</option>
					<option value="黄金客户" 
						<c:if test="${cust.type=='黄金客户' }">selected="selected"</c:if>  
					>黄金客户</option>
					<option value="白银客户" 
						<c:if test="${cust.type=='白银客户' }">selected="selected"</c:if>  
					>白银客户</option>
					<option value="一般客户" 
						<c:if test="${cust.type=='一般客户' }">selected="selected"</c:if>  
					>一般客户</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>客户注释：</td>
			<td align="left">
				<textarea name="description" rows="5" cols="40"/><c:out value = "${cust.description }"/></textarea>
			</td>
		</tr>
		<tr><td colspan="2" align="center"><input  type="submit" value="修改客户"/></td></tr>
	</table>
	
	</form>
</body>
</html>
