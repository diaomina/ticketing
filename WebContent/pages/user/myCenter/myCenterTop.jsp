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
<title>我的中心顶部页</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
</head>
<body>
<h1 align="center">会员个人中心</h1>
<h4>${welcome}</h4>
	
</body>
</html>