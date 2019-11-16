<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单中心</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" >
</head>
<body>
	<table border="1" cellpadding="8" cellspacing="1">
	
		<tr>
			<th>订单编号</th>
			<th>会员信息ID</th>
			<th>乘车人详细信息</th>
			<th>车次</th>
			<th>起始站</th>
			<th>终点站</th>
			<th>开车时间</th>
			<th>到达时间</th>
			<th>票价</th>
			<th>付款情况</th>
			<th>订票时间</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${prepList}" var="prep">
		<tr>
			<td>${prep.prepId}</td>
			<td>${prep.pmemberId}</td>
			<td>
				<a href="<%=basePath%>GetPmemberByPmemberIdServlet?pmemberId=${prep.pmemberId}">
				<img alt="" src="<%=basePath%>images/look.jpg">
				</a>
			</td>
			<td>${prep.trainNumber}</td>
			<td>${prep.startStation}</td>
			<td>${prep.endStation}</td>
			<td>${prep.startTime}</td>
			<td>${prep.endTime}</td>
			<td>${prep.price}</td>
			<c:if test="${prep.way == true}">
				<td>已付款</td>
			</c:if>
			<c:if test="${prep.way == false}">
				<td style="color:red">未付款</td>
			</c:if>
			<td>
				<fmt:formatDate value="${prep.booktime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td>
				<a href="<%=basePath%>UpdatePrepAdminServlet?prepId=${prep.prepId}">
				<img alt="" src="<%=basePath%>images/update.jpg">
				</a>
			</td>
			<td>
				<a href="<%=basePath%>DeletePrepAmdinServlet?prepId=${prep.prepId}">
				<img alt="" src="<%=basePath%>images/delete.jpg">
				</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>