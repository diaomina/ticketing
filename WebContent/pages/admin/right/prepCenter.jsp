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
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>订单列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单中心 <span class="c-gray en">&gt;</span> 订单列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l"> <a class="btn btn-primary radius" data-title="导出Excel" data-href="<%=basePath%>ExportExcelServlet" href="<%=basePath%>ExportExcelServlet"><i class="Hui-iconfont">&#xe600;</i> 导出Excel</a></span> 
		<span class="r">共有数据：<strong>${prepList.size()}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="30">序号</th>
					<th width="60">订单编号</th>
					<th width="60">会员信息ID</th>
					<th width="80">乘车人详细信息</th>
					<th width="80">车次</th>
					<th width="80">起始站</th>
					<th width="80">终点站</th>
					<th width="120">开车时间</th>
					<th width="120">到达时间</th>
					<th width="60">票价</th>
					<th width="60">付款情况</th>
					<th width="120">订票时间</th>
					<th width="80">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${prepList}" var="prep" varStatus="status">
				<tr class="text-c">
					<td>${status.index+1}</td>
					<td>${prep.prepId}</td>
					<td>${prep.pmemberId}</td>
					<td>
						<a href="<%=basePath%>GetPmemberByPmemberIdServlet?pmemberId=${prep.pmemberId}">
						<%-- <img alt="" src="<%=basePath%>images/look.jpg"> --%>
						点击查看
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
					<td class="f-14 td-manage">
						<a style="text-decoration:none" class="ml-5" href="<%=basePath%>UpdatePrepAdminServlet?prepId=${prep.prepId}" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
						<a style="text-decoration:none" class="ml-5" href="<%=basePath%>DeletePrepAmdinServlet?prepId=${prep.prepId}" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
					</td>
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
		  {"orderable":false,"aTargets":[3, 12]}// 不参与排序的列
		]
	});
	
	
</script> 

</body>
</html>


