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
<title>管理员界面</title>
<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" >
</head>
	<frameset rows="90,*,90" frameborder="1" border="1" noresize="noresize"><!--窗口-->
	    <frame name="top" src="top.jsp"/><!--子窗口-->
	    <frameset cols="10%,90%">
	        <frame name="left" src="left.jsp"/>
	        <frame name="right" src="right.jsp" />
	    </frameset>
	    <frame name="bottom" src="bottom.jsp"/>
	</frameset>
</html>