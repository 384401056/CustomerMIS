<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body style="text-align: center;">

	<h1>客户管理系统--添加客户</h1><hr>
	
	<form action="${pageContext.request.contextPath}/servlet/AddCustServlet" method="POST">
	<table border="1">
		<tr>
			<td>客户姓名：</td>
			<td align="left"> <input type="text" name="name"/> </td>
		</tr>
		<tr>
			<td>客户性别：</td>
			<td align="left"> 
				<input type="radio" name="gender" value="男"/> 男
				<input type="radio" name="gender" value="女"/> 女
			</td>
		</tr>
		<tr>
			<td>出生年月：</td>
			<td align="left"> <input type="text" name="birthday"/> </td>
		</tr>
		
		<tr>
			<td>手机号码：</td>
			<td align="left"><input type="text" name="cellphone"/></td>
		</tr>
		
		<tr>
			<td>电子邮箱：</td>
			<td align="left"><input type="text" name="email"/></td>
		</tr>
		
		<tr>
			<td>爱好：</td>
			<td align="left">
				<input type="checkbox" name="preference" value="蓝球"/>蓝球
				<input type="checkbox" name="preference" value="足球"/>足球
				<input type="checkbox" name="preference" value="乒乓球"/>乒乓球
				<input type="checkbox" name="preference" value="网球"/>网球
				<input type="checkbox" name="preference" value="羽毛球"/>羽毛球
			</td>
		</tr>
		
		<tr>
			<td>客户类型：</td>
			<td align="left">
				<select name="type">
					<option value="钻石客户">钻石客户</option>
					<option value="白金客户">白金客户</option>
					<option value="黄金客户">黄金客户</option>
					<option value="白银客户">白银客户</option>
					<option value="一般客户">一般客户</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<td>客户注释：</td>
			<td align="left"><textarea name="description" rows="5" cols="40"></textarea></td>
		</tr>
		<tr><td colspan="2" align="center"><input  type="submit" value="添加客户"/></td></tr>
	</table>
	
	</form>
</body>
</html>















