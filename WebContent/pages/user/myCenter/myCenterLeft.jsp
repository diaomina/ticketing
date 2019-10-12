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
<title>我的中心左侧导航页</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
</head>
<body>
	<ul>
		<li><a href="<%=basePath%>pages/user/home.jsp" target="_top">返回首页</a> </li>
		<li><a href="<%=basePath%>GetMyMemberServlet" target="right">我的中心</a> </li>
		<li><a href="<%=basePath%>GetPmemberByMemberIdServlet" target="right">个人信息</a> </li>
		<li><a href="<%=basePath%>pages/user/myCenter/right/updateMemberPassword.jsp" target="right">修改密码</a> </li>
		<li><a href="<%=basePath%>MyPrepServlet" target="right">我的订单</a> </li>
	</ul>
</body>
</html>