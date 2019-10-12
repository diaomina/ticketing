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
<title>会员注册</title>
<link type="text/css" href="css/reg.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/reg.js"></script>
</head>
<body>
<div class="d">
	<form action="<%=basePath%>RegMemberServlet" method="post">
		<fieldset>
		<legend><strong>会员注册</strong></legend>
		<table>
			<tr>
				<td class="input">用户名：</td>
				<td><input id="username" name="username"></td>
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
				<td colspan="2" id="submit"><input type="submit" value="注册"></td>
			</tr>
		</table>
		</fieldset>
	</form>
</div>
</body>
</html>