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
<title>修改管理员密码</title>
	<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >
</head>
<body>

	<br/><br/><br/>

	<form action="<%=basePath%>UpdateAdminPassword" method="post">
	<h3>修改密码</h3>
	原密码：<input type="text" name="oldPassword"><br/><br/>
	新密码：<input type="text" name="newPassword"><br/><br/><br/>
	<input class="sumbit-button" type="submit" value="提交" /><br/><br/>
	</form>
</body>
</html>