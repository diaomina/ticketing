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
<title>销售统计</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
</head>
<body>
	<h3>销售统计情况</h3>
	<table>
		<tr>
			<td>已完成订单数：    </td>
			<td>${prepNumber}</td>
		</tr>
		<tr>
			<td>总销售额：    </td>
			<td>${prepPrice}</td>
		</tr>
	</table>
	
	<br/><br/>
</body>
</html>