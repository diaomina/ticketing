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
	<title>添加车次</title>
	<script type="text/javascript" src="<%=basePath%>js/moment.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/getDateTime.js"></script>
	<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >
</head>
<body onload="getDateTime()">
	<form action="<%=basePath%>AddTrainServlet" method="post">
		<h3>添加车次</h3>
		<table border="1" cellpadding="8" cellspacing="1">
			<tr>
				<td>车次</td>
				<td><input type="text" name="trainNumber"></td>	
			</tr>
			<tr>
				<td>起始站</td>
				<td><input type="text" name="startStation"></td>	
			</tr>
			<tr>
				<td>终点站</td>
				<td><input type="text" name="endStation"></td>
			<tr/>
			<tr>
				<td>开车时间</td>
				<td><input type="datetime-local" id="startTime" name="startTime" min=""/></td>
			<tr/>
			<tr>
				<td>到站时间</td>
				<td><input type="datetime-local" id="endTime" name="endTime" min=""/></td>
			<tr/>
			<tr>
				<td>车票价格</td>
				<td><input type="text" name="price"></td>
			<tr/>
			<tr>
				<td>座位数量</td>
				<td><input type="text" name="seatNumber"></td>
			<tr/>
		</table>
		<br/><br/>
		<input class="sumbit-button" type="submit" value="添加"/>
	</form>
</body>
</html>