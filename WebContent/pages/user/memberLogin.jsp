<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员登录</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css">
</head>
<body>

	<h2>登录</h2>
	<%-- <p style="color: red; font-weight: 900">${msg}</p> --%>
	<form action="<%=basePath%>MemberLoginServlet" method="post" target="_top">
		<p>用户名</p>
		<input type="text" class="name" name="userName"/>
		<p>密 码</p>
		<input type="password" class="password" name="passWord"/> 
		<br/><br/>
		<input type="submit" value="登录">
	</form>
	<br />
	<h6>
		<a href="<%=basePath%>/pages/user/memberReg.jsp">没有账号？点击注册</a>
	</h6>

</body>
</html>