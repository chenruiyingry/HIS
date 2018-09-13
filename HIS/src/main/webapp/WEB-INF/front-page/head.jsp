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
			<a href="/HIS/toIndex.action"><img src="/HIS/res/img/logo.png" class="title"></a>
			<p class="half-title">— ${name }</p>
		</div>
		<span class="timeShow_1" id="timeShow_1"></span>
		<div class="half-head_1">
			<a class="bar_a" id="bar_a" onmouseover="mov()" onmouseout="mou()"><</a>
			<div class="bar" id="bar">
				<a href="/HIS/toRegister.action">挂号</a>
				<a href="/HIS/toVisit.action">诊疗</a>
				<a href="/HIS/toFee.action">收费</a>
				<a href="/HIS/toDrug.action">取药</a>
				<a href="/HIS/toUpdate.action">修改密码</a>
			</div>
			<a href="/HIS/toInfo.action?code=${doctorsession.code }" class="update" title="点击查看个人信息"></a>
			<img class="auther_head" id="auther_head" src="${doctorsession.allUrl }" alt="img">
			<p class="username_1" id="username_1">${doctorsession.name }</p>
			<a href="/HIS/logout.action" class="sign-out"><i class="fa fa-sign-out"></i></a>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/homeHeader.js"></script>
  </body>
</html>
