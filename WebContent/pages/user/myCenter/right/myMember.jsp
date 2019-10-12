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
<title>我的中心</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/table-style1.css" type="text/css" >
</head>
<body>

	<br/><br/><br/>

	<table border="1" cellpadding="8" cellspacing="1">
		<tr>
			<td>ID：</td>
			<td>${member.memberId}</td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td>${member.userName}</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td>${member.password}</td>
		</tr>
		<tr>
			<td>注册时间：</td>
			<td>${member.registerTime}</td>
		</tr>
		<tr>
			<td>状态：</td>
			<td>${member.ifUse}</td>
		</tr>
		<tr>
			<td>登录时间：</td>
			<td>${member.logintimes}</td>
		</tr>
	</table>
</body>
</html>