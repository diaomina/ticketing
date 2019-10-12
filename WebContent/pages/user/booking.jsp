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
<title>订票信息</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/table-style1.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >

</head>
<body>
	<br/><br/>
	<h1>订   票   信   息</h1>
	<br/>
	<h3 style="color: red;">请确认信息是否正确！</h3>
	<br/>
	
	<table border="1" cellpadding="8" cellspacing="1">
		<tr>
			<td>姓名：</td>
			<td>${pmember.realName}</td>
			<td>性别：</td>
			<td>${pmember.sex}</td>
		</tr>
		<tr>
			<td>年龄：</td>
			<td>${pmember.age}</td>
			<td>身份证：</td>
			<td>${pmember.idCard}</td>
		</tr>
		<tr>
			<td>车次：</td>
			<td>${train.trainNumber}</td>
			<td>车票价格：</td>
			<td>${train.price}</td>
		</tr>
		<tr>
			<td>起始站：</td>
			<td>${train.startStation}</td>
			<td>终点站：</td>
			<td>${train.endStation}</td>
		</tr>
		<tr>
			<td>开车时间：</td>
			<td>${train.startTime}</td>
			<td>到站时间：</td>
			<td>${train.endTime}</td>
		</tr>
	</table>
	
	<br/>
	
	<form action="<%=basePath%>BookingServlet" method="post">
		<input type="hidden" name="trainId" value="${train.trainId}">
		<input class="sumbit-button" type="submit" value="确认">
		
		&nbsp;&nbsp;&nbsp;&nbsp;
		
		<!-- 跳转到这里，使用js实现，<a href="GetByStartEndStationServlet">取消</a> -->
		<input class="sumbit-button" type="button" value="取消" onclick="#">
	</form>
	
</body>
</html>