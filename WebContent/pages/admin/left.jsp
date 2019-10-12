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
<title>管理员界面左侧导航栏</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
</head>
<body>
<ul>
	<li><a href="<%=basePath%>pages/user/home.jsp" target="_top">返回首页</a> </li>
	<li><a href="<%=basePath%>pages/admin/right/getAdmin.jsp" target="right">我的中心</a> </li>
	<li><a href="<%=basePath%>pages/admin/right/updateAdminPassword.jsp" target="right">修改密码</a> </li>
	<li><a href="<%=basePath%>pages/admin/right/addAdmin.jsp" target="right">添加管理</a> </li>
    <li><a href="<%=basePath%>GetAllTrainServlet" target="right">管理车次</a> </li>
    <li><a href="<%=basePath%>pages/admin/right/addTrain.jsp" target="right">添加车次</a> </li>
    <li><a href="<%=basePath%>MemberCenterServlet" target="right">会员中心</a> </li>
    <li><a href="<%=basePath%>pages/admin/right/addMember.jsp" target="right">添加会员</a> </li>
    <li><a href="<%=basePath%>GetAllPrepServlet" target="right">订单中心</a> </li>
    <li><a href="#" target="right">销售情况</a> </li>
    <li><a href="#" target="right">发布新闻</a> </li>
    <li><a href="#" target="right">会员来信</a> </li>
</ul>
</body>
</html>