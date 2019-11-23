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
	<title>首页</title>
	
	<style type="text/css">
		html *{
			margin: 0 auto;
			padding: 0 auto;
			text-align: center;
		}
	</style>
	
	<link rel="stylesheet" href="<%=basePath%>css/home-menu.css" type="text/css" >
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>static/h-ui.admin/css/style.css" />
	
</head>
	 	<!-- 首页顶部导航栏start  -->
	 	<header class="navbar-wrapper">
	    <div id="head">
	    
		    <ul id="menu" style="margin:0 auto; width: 60%;">
		        <li style="width:530px; display:inline"><a href="<%=basePath%>pages/user/home.jsp">火车站售票系统</a></li>
		        <li style="display:inline"><a href="<%=basePath%>pages/user/home.jsp">首页</a></li>
		        <li style="display:inline"><a href="<%=basePath%>CheckLoginServlet?temp=1">会员中心</a>
		        <li style="display:inline"><a href="<%=basePath%>pages/user/memberLogin.jsp" target="my_iframe">登录/注册</a></li>
		        <li style="display:inline"><a href="<%=basePath%>MemberLoginOutServlet">退出登录</a></li>
		    </ul>
		    
		</div>
		</header>
	    
	    <iframe name="my_iframe" id="my_iframe" src="<%=basePath%>GetByStartEndStationServlet" width="60%" height="800px" seamless="seamless"></iframe>
	    <!-- 首页顶部导航栏end  -->
	    
	    

</html>