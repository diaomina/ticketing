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
	
	<%-- <link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" > --%>
	<link rel="stylesheet" href="<%=basePath%>css/home-menu.css" type="text/css" >
</head>

	 	<!-- 首页顶部导航栏start  -->
	    <div id="head">
		    <ul id="menu" style="margin:0 auto; width: 60%;">
		        <%-- <li><a href="<%=basePath%>pages/user/home.jsp"><img alt="" src="<%=basePath%>/images/home.jpg"></a></li> --%>
		        <li style="width:520px;"><a href="<%=basePath%>pages/user/home.jsp">火车站售票系统</a></li>
		        <li><a href="<%=basePath%>pages/user/home.jsp">首页</a></li>
		        <li><a href="<%=basePath%>pages/user/myCenter/myCenter.jsp">会员中心</a>
		        <li><a href="<%=basePath%>pages/user/memberLogin.jsp" target="my_iframe">登录/注册</a></li>
		        <%-- <li><a href="<%=basePath%>pages/user/memberReg.jsp" target="my_iframe">注册</a></li> --%>
		        <li><a href="#">退出登录</a></li>
		    </ul>
	    </div>
	    
	     <iframe name="my_iframe" id="my_iframe" src="<%=basePath%>GetByStartEndStationServlet" width="60%" height="700px" seamless="seamless"></iframe>
	    <!-- 首页顶部导航栏end  -->
	    
	    
	    




<%-- 	<frameset rows="10%,90%" frameborder="1" border="1" noresize="noresize"><!--窗口-->
		<frame src="<%=basePath%>pages/user/top.jsp">
		<frame src="<%=basePath%>GetByStartEndStationServlet">
		<frame src="<%=basePath%>pages/user/bottom.jsp">
	</frameset> --%>

</html>