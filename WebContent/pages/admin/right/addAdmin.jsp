<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加管理员</title>
	<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >
</head>
<body>
	<form action="<%=basePath%>AddAdminServlet" method="post">
		<h3>添加管理员</h3>
		
		<table border="1" cellpadding="8" cellspacing="1">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td>权限代码：</td>
				<td><input type="text" name="flag" /></td>
			</tr>
		</table>
		
		<br/><br/>
		<input class="sumbit-button" type="submit" value="添加">
	</form>
</body>
</html>