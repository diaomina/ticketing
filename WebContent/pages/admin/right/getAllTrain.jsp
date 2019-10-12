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
<title>管理车次界面</title>
<link rel="stylesheet" href="<%=basePath%>/css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
</head>
<body>
	<table border="1" cellpadding="8" cellspacing="1">
		<tr>
			<th>车次</th>
			<th>起始站</th>
			<th>终点站</th>
			<th>开车时间</th>
			<th>到达时间</th>
			<th>票价</th>
			<th>剩余座位数</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${trainList}" var="allTrain">
		<tr>
			<td>${allTrain.trainNumber}</td>
			<td>${allTrain.startStation}</td>
			<td>${allTrain.endStation}</td>
			<td>${allTrain.startTime}</td>
			<td>${allTrain.endTime}</td>
			<td>${allTrain.price}</td>
			<td>${allTrain.seatNumber}</td>
			<td>
				<a href="<%=basePath%>UpdateTrainServlet?trainId=${allTrain.trainId}">
				<img alt="" src="<%=basePath%>images/update.jpg">
				</a>
			</td>
			<td>
				<a href="<%=basePath%>DeleteTrainServlet?trainId=${allTrain.trainId}">
				<img alt="" src="<%=basePath%>images/delete.jpg">
				</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>