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
<title>我的信息</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/table-style1.css" type="text/css" >
</head>
<body>

	<br/><br/><br/>

	<table border="1" cellpadding="8" cellspacing="1">
		<tr>
			<td>ID：</td>
			<td>${admin.adminId}</td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td>${admin.userName}</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td>${admin.password}</td>
		</tr>
		<tr>
			<td>注册时间：</td>
			<td>${admin.creatTime}</td>
		</tr>
		<tr>
			<td>权限代码：</td>
			<td>${admin.flag}</td>
		</tr>
		<tr>
			<td>状态：</td>
			<td>${admin.isUse}</td>
		</tr>
		<tr>
			<td>登录时间：</td>
			<td>${admin.loginTime}</td>
		</tr>
	</table>
</body>
</html>