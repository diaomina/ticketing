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
<title>我的订单</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
</head>
<body>

<h3 style="color: red;">${msg}</h3>

<table border="1" cellpadding="8" cellspacing="1">
		<tr>
			<th>订单编号</th>
			<th>车次</th>
			<th>起始站</th>
			<th>终点站</th>
			<th>开车时间</th>
			<th>到达时间</th>
			<th>票价</th>
			<th>付款情况</th>
			<th>付款</th>
			<th>改签</th>
			<th>退票</th>
		</tr>
		<c:forEach items="${prepList}" var="prep">
		<tr>
			<td>${prep.prepId}</td>
			<td>${prep.trainNumber}</td>
			<td>${prep.startStation}</td>
			<td>${prep.endStation}</td>
			<td>${prep.startTime}</td>
			<td>${prep.endTime}</td>
			<td>${prep.price}</td>
			<td>${prep.way}</td>
			<td>
				<a href="<%=basePath%>PayServlet?prepId=${prep.prepId}">
				<img alt="" src="<%=basePath%>images/pay.jpg">
				</a>
			</td>
			<td>
				<a href="<%=basePath%>UpdatePrepServlet?temp=2&&prepId=${prep.prepId}">
				<img alt="" src="<%=basePath%>images/update.jpg">
				</a>
			</td>
			<td>
				<a href="<%=basePath%>DeletePrepServlet?prepId=${prep.prepId}">
				<img alt="" src="<%=basePath%>images/delete.jpg">
				</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>