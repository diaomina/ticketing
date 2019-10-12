<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员中心</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
</head>
<body>
	
	<table border="1" cellpadding="8" cellspacing="1">
		<tr>
			<th>会员ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>注册时间</th>
			<th>会员状态</th>
			<th>登录时间</th>
			<th>个人信息</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${memberList}" var="member">
		<tr>
			<td>${member.memberId}</td>
			<td>${member.userName}</td>
			<td>${member.password}</td>
			<td>${member.registerTime}</td>
			<td>${member.ifUse}</td>
			<td>${member.logintimes}</td>
			<td>
				<a href="<%=basePath%>GetPmemberByMemberIdServlet?temp=admin&memberId=${member.memberId}">
				<img alt="" src="<%=basePath%>images/look.jpg">
				</a>
			</td>
			<td>
				<a href="<%=basePath%>UpdateMemberAdminServlet?memberId=${member.memberId}">
				<img alt="" src="<%=basePath%>images/update.jpg">
				</a>
			</td>
			<td>
				<a href="<%=basePath%>DeleteMemberAdminServlet?memberId=${member.memberId}">
				<img alt="" src="<%=basePath%>images/delete.jpg">
				</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>