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
<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >
</head>
<body>

	<br/><br/><br/>

	<form action="<%=basePath%>UpdatePmemberServlet" method="post">
		<h3>会员个人信息</h3>
		<table border="1" cellpadding="8" cellspacing="1">
			<tr>
				<td>ID：    </td>
				<td>${pmember.pmemberId}</td>
			</tr>
			<tr>
				<td>姓名：    </td>
				<td><input type="text" name="realName" value="${pmember.realName}"></td>
			</tr>
			<tr>
				<td>性别：    </td>
				<td><input type="text" name="sex" value="${pmember.sex}"></td>
			</tr>
			<tr>
				<td>年龄：    </td>
				<td><input type="text" name="age" value="${pmember.age}"></td>
			</tr>
			<tr>
				<td>身份证：    </td>
				<td><input type="text" name="idCard" value="${pmember.idCard}"></td>
			</tr>
		</table>
		<br/><br/>
		<input type="hidden" name="pmemberId" value="${pmember.pmemberId}">
		<input class="sumbit-button" type="submit" value="修改"/>
	</form>

	
</body>
</html>