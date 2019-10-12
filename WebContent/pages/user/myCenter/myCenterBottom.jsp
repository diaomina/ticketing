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
<title>底部页</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
</head>
<body>
	<div class="align_center">
		<p>©版权所有©2019 chky. All rights reserved.赣ICP备11003558号</p>
	</div>
</body>
</html>