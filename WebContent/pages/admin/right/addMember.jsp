<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加会员</title>
	<link type="text/css" href="css/reg.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >
	<script src="js/jquery.js"></script>
	<script src="js/reg.js"></script>
</head>
<body>
<div class="d">
	<form action="<%=basePath%>AddMemberServlet" method="post">
		<h3>添加会员</h3>
		<table border="1" cellpadding="8" cellspacing="1">
			<tr>
				<td class="input">用户名：</td>
				<td><input id="userName" name="userName"></td>
				<td>${message1}</td>
			</tr>
			<tr>
				<td class="input">密码：</td>
				<td><input id="password" type="password" name="password"></td>
				<td>${message2}</td>
			</tr>
			<tr>
				<td class="input">确认密码：</td>
				<td><input id="repwd" type="password" name="repwd"></td>
				<td>${message3}</td>
			</tr>
			<tr>
				<td class="input">真实姓名：</td>
				<td><input id="realName" type="text" name="realName"></td>
				<td>${message3}</td>
			</tr>
			<tr>
				<td class="input">性别：</td>
				<td><input id="sex" type="text" name="sex"></td>
				<td>${message3}</td>
			</tr>
			<tr>
				<td class="input">年龄：</td>
				<td><input id="age" type="text" name="age"></td>
				<td>${message3}</td>
			</tr>
			<tr>
				<td class="input">身份证号码：</td>
				<td><input id="idCard" type="text" name="idCard"></td>
				<td>${message3}</td>
			</tr>
			<tr>
				<!-- <td colspan="2" id="submit"><input class="submit-button" type="submit" value="注册"></td> -->
			</tr>
		</table>
		
		<br/><br/>
		
		<input class="submit-button" type="submit" value="添加">
	</form>
</div>
</body>
</html>