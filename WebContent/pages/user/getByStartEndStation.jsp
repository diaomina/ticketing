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
	<%-- <link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/table-style.css" type="text/css" > --%>
	<link rel="stylesheet" href="<%=basePath%>css/select-style.css" type="text/css" >
	<link rel="stylesheet" href="<%=basePath%>css/sumbitButton-style.css" type="text/css" >
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/style.css" />
</head>
<body onload="getDate()">

	
	<br/><br/>
	<form action="<%=basePath%>GetByStartEndStationServlet" method="post">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
	
	<br/>
	<div class="page-container">
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="40">序号</th>
					<th width="80">车次</th>
					<th width="80">起始站</th>
					<th width="80">终点站</th>
					<th width="120">开车时间</th>
					<th width="120">到站时间</th>
					<th width="60">票价/元</th>
					<th width="60">剩余座位数</th>
					<th width="60">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${trainList}" var="allTrain" varStatus="status">
			<tr  class="text-c">
				<td>${status.index+1}</td>
				<td>${allTrain.trainNumber}</td>
				<td>${allTrain.startStation}</td>
				<td>${allTrain.endStation}</td>
				<td>${allTrain.startTime}</td>
				<td>${allTrain.endTime}</td>
				<td>${allTrain.price}</td>
				<td>${allTrain.seatNumber}</td>
				<td><a href="<%=basePath%>CheckLoginServlet?trainId=${allTrain.trainId}&temp=2">订票</a></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=basePath%>lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=basePath%>lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
	
	$('.table-sort').dataTable({
		"aaSorting": [[ 0, "asc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"pading":false,
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[8]}// 不参与排序的列
		]
	});
	
</script> 
	
	
</body>
</html>