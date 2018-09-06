<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
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
			<a href="/HIS/admin/toIndex.do">
				<img src="/HIS/res/img/logo.png" class="title">
			</a>
			<p class="half-title">―― ${name }</p>
		</div>
		<span class="timeShow_1" id="timeShow_1"></span>
		<div class="half-head_1">
			<a class="bar_a" id="bar_a" onmouseover="mov()" onmouseout="mou()"><</a>
			<div class="bar_1" id="bar">
				<a href="/HIS/admin/doctorList.do">医生</a>
				<a href="/HIS/admin/patientList.do">病人</a>
				<a href="">病房</a>
				<a href="">门诊</a>
				<a href="/HIS/admin/durglist.do">药品</a>
				<a href="">收费</a>
			</div>
			<p class="username">${admin_session.username }</p>
			<a href="/HIS/admin/logout.do" class="sign-out" title="退出"><i class="fa fa-sign-out"></i></a>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/homeHeader.js"></script>
  </body>
</html>
