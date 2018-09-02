<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="/HIS/res/css/homeHeader.css">
  </head>
  
  <body>
  	<div class="head">
		<div class="bar_c">
			<div class="bar_b"></div>
			<div class="bar_c_a"></div>
		</div>
		<div class="half-head">
			<img src="/HIS/res/img/logo.png" class="title">
			<p class="half-title">— ${name }</p>
		</div>
		<span class="timeShow_1" id="timeShow_1"></span>
		<div class="half-head_1">
			<a href="" class="bar_a" id="bar_a" onmouseover="mov()" onmouseout="mou()"><</a>
			<div class="bar" id="bar">
				<a href="">医生</a>
				<a href="">病人</a>
				<a href="">病房</a>
				<a href="">药品</a>
				<a href="">收费</a>
			</div>
			<img class="auther_head" id="auther_head" src="/HIS/res/img/author_head.gif" alt="img">
			<p class="username_1" id="username_1">123456789</p>
			<a href="" class="sign-out"><i class="fa fa-sign-out"></i></a>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/homeHeader.js"></script>
  </body>
</html>
