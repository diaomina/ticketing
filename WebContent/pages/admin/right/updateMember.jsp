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
	<title>修改会员</title>
	<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >
</head>
<body>
	<form action="<%=basePath%>UpdateMemberAdminServlet" method="post">
		<h3>修改会员</h3>
		<table border="1" cellpadding="8" cellspacing="1">
			<tr>
				<th>会员ID</th>
				<th>用户名</th>
				<th>密码</th>
				<th>注册时间</th>
				<th>会员状态</th>
				<th>登录时间</th>
			</tr>
			<tr>
				<td>${member.memberId}</td>
				<td><input type="text" id="userName" name="userName" value="${member.userName}" /></td>
				<td><input type="text" id="password" name="password" value="${member.password}" /></td>
				<td>${member.registerTime}</td>
				<td>${member.ifUse}</td>
				<td>${member.logintimes}</td>
			</tr>
		</table>
		
		<input type="hidden" name="memberId" value="${member.memberId}">
		
		<br/>
		
		<input class="sumbit-button" type="submit" value="提交" />
		
	</form>

</body>
</html>