<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>挂号系统</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/tofee.css">
</head>
<body>
	<c:import url="/toHead.action">
		<c:param name="name" value="register"></c:param>
	</c:import>
	<form action="toRegist.action">
	<div class="main" id="main">
		<div class="main_bar">
			<!-- <canvas></canvas> -->
			<div class="main_bar_input">
				<input type="text" placeholder="卡号" class="number" name="code" value="${code }">
				<input type="submit" value="" class="submit">
				<i class="fa fa-search" aria-hidden="true"></i>
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script>
		var ta = document.getElementById('main');
		ta.style.height = $(window).height()-72+"px";
	</script>
</body>
</html>
