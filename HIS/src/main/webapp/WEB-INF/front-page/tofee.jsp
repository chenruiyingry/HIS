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
	<title>收费</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/tofee.css">
</head>
<body>
	<c:import url="/toHead.action?name=fee"></c:import>
	<form action="fee.action">
	<div class="main" id="main">
		<div class="main_bar">
			<!-- <canvas></canvas> -->
			<div class="main_bar_input">
				<input type="text" placeholder="卡号" class="number" name="code">
				<input type="submit" value="" class="submit">
				<i class="fa fa-search" aria-hidden="true"></i>
				<p class="errormsg">${msg }</p>
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script>
		var main = document.getElementById('main');
		main.style.height = $(window).height()-72+"px";
		$(document).ready(function (){
			$('.bar_c_a').mouseover(function (){
				$('.auther_head').css({"width":"29px", "top":"20px", "right":"95px",});
				$('.username_1').css({"left":"-88px", "z-index":"2",});
			});
			$('.bar_c_a').mouseout(function (){
				$('.auther_head').css({"width":"40px", "top":"10px", "right":"55px",});
				$('.username_1').css({"left":"-150px", "z-index":"-1",});
			});
		});
	</script>
</body>
</html>
