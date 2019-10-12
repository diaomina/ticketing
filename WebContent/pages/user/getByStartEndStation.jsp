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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>根据起点站、终点站、出发时间查询展示车次信息</title>
	<script type="text/javascript" src="js/moment.js"></script>
	<script type="text/javascript" src="js/getDate.js"></script>
	<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/select-style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >
</head>
<body onload="getDate()">

	
	<br/><br/>
	<form action="<%=basePath%>GetByStartEndStationServlet" method="post">
		起始站:&nbsp;&nbsp;
		<select name="startStation">
			<c:forEach items="${startStationList}" var="train">
				<option value="${train.startStation}">${train.startStation}</option>
			</c:forEach>
		</select>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		终点站:&nbsp;&nbsp;
		<select name="endStation">
			<c:forEach items="${endStationList}" var="train">
				<option value="${train.endStation}">${train.endStation}</option>
			</c:forEach>
		</select>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		开车时间:&nbsp;&nbsp;
		<input type="date" id="startTime" id="startTime" name="startTime" min=""/>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
		<input class="sumbit-button" type="submit" value="查询">
	
	</form>
	<br/><br/>

	<table border="1" cellpadding="8" cellspacing="1">
		<tr>
			<th>车次</th>
			<th>起始站</th>
			<th>终点站</th>
			<th>开车时间</th>
			<th>到达时间</th>
			<th>票价</th>
			<th>剩余座位数</th>
			<th>操作</th>
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
			<td><a href="<%=basePath%>BookingServlet?trainId=${allTrain.trainId}">订票</a></td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>