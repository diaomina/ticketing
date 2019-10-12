<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员个人信息</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
</head>
<body>
	<h3>${msg}</h3>
	<table>
		<tr>
			<td>姓名：    </td>
			<td>${pmember.realName}</td>
		</tr>
		<tr>
			<td>性别：    </td>
			<td>${pmember.sex}</td>
		</tr>
		<tr>
			<td>年龄：    </td>
			<td>${pmember.age}</td>
		</tr>
		<tr>
			<td>身份证：    </td>
			<td>${pmember.idCard}</td>
		</tr>
	</table>
	
	<br/><br/>
	<a href="<%=basePath%>GetAllPrepServlet" target="right">返回</a>
</body>
</html>