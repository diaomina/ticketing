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
	<title>修改车次</title>
	<script type="text/javascript" src="<%=basePath%>js/moment.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/getDateTime.js"></script>
	<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
</head>
<body onload="getDateTime()">
	<form action="<%=basePath%>UpdateTrainServlet" method="post">
	<h3>修改车次</h3>
		<table>
			<tr>
				<td>车次</td>
				<td><input type="text" name="trainNumber" value="${train.trainNumber}"></td>	
			</tr>
			<tr>
				<td>起始站</td>
				<td><input type="text" name="startStation" value="${train.startStation}"></td>	
			</tr>
			<tr>
				<td>终点站</td>
				<td><input type="text" name="endStation" value="${train.endStation}"></td>
			<tr/>
			<tr>
				<td>开车时间</td>
				<td><input type="datetime-local" id="startTime" name="startTime" min="" value="${train.startTime}"/></td>
			<tr/>
			<tr>
				<td>到站时间</td>
				<td><input type="datetime-local" id="endTime" name="endTime" min="" value="${train.endTime}"/></td>
			<tr/>
			<tr>
				<td>车票价格</td>
				<td><input type="text" name="price" value="${train.price}"></td>
			<tr/>
			<tr>
				<td>座位数量</td>
				<td><input type="text" name="seatNumber" value="${train.seatNumber}"></td>
			<tr/>
		</table>
		<input type="hidden" name="trainId" value="${train.trainId}">
		<input type="submit" value="修改">
	</form>
</body>
</html>