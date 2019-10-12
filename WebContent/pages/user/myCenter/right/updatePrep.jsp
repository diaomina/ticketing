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
<title>车票改签</title>
<link rel="stylesheet" href="css/style.css" type="text/css" >
</head>
<body>

<h3>${msg}</h3>
	
	<form action="<%=basePath%>GetByStartEndStationServlet" method="post">
		起始站:
		<select name="startStation">
			<c:forEach items="${startStationList}" var="train">
				<option value="${train.startStation}">${train.startStation}</option>
			</c:forEach>
			
		</select>
		终点站:
		<select name="endStation">
			<c:forEach items="${endStationList}" var="train">
				<option value="${train.endStation}">${train.endStation}</option>
			</c:forEach>
		</select>
		
		开车时间:
		<input type="date" id="startTime" id="startTime" name="startTime" min=""/>
		
		<input type="submit" value="查询">
	
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