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
	<title>修改订单</title>
	<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >
</head>
<body>

	<br/><br/><br/>
	
	<form action="<%=basePath%>UpdatePrepAdminServlet" method="post">
		<h3>修改订单</h3>
		<table border="1" cellpadding="8" cellspacing="1">
			<tr>
				<th>订单编号</th>
				<th>会员信息ID</th>
				<th>车次</th>
				<th>起始站</th>
				<th>终点站</th>
				<th>开车时间</th>
				<th>到达时间</th>
				<th>票价</th>
				<th>付款情况</th>
				<th>订票时间</th>
			</tr>
			<tr>
				<td>${prep.prepId}</td>
				<td>${prep.pmemberId}</td>
				<td>${prep.trainNumber}</td>
				<td>${prep.startStation}</td>
				<td>${prep.endStation}</td>
				<td>${prep.startTime}</td>
				<td>${prep.endTime}</td>
				<td>
					<input type="text" id="price" name="price" value="${prep.price}">
				</td>
				<td>
					<select name="way">
						<option value="false">&nbsp;&nbsp;未付款&nbsp;&nbsp;</option>
						<option value="true">&nbsp;&nbsp;已付款&nbsp;&nbsp;</option>
					</select>
				</td>
				<td>${prep.booktime}</td>
			</tr>
		</table>
	
		<br/>
		
		<input type="hidden" name="prepId" value="${prep.prepId}">
		
		<input class="sumbit-button" type="submit" value="提交" />
	
	</form>
</body>
</html>