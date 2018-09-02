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
	<title>信息板</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/message.css">
</head>
<body>
	<c:import url="/toHead.action?name=fee"></c:import>
	<c:choose>
		<c:when test="${code eq 'success' }">
			<c:set var="img" value="/HIS/res/img/duihao.jpg"/>
		</c:when>
		<c:when test="${code eq 'error' }">
			<c:set var="img" value="/HIS/res/img/cuohao.jpg"/>
		</c:when>
	</c:choose>
	<div class="main" id="main">
		<div class="main_bar">
			<div class="main_bar_msg">
				<p class="msg">
				
				<img src="${img }" class="img">
				${msg }！<br></p>
				<p id="show" class="time"></p>
			</div>
		</div>
	</div>
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
		var t = ${time };//设定跳转的时间
		setInterval("refer()", 1000); //启动1秒定时
		function refer() {
			if(t == 0) {
				location = "${url }";
			}
			document.getElementById('show').innerHTML = "" + t + "秒后跳转到${urlname }，或点击<a class=" + "'link'" +  "href=" + '${url }' +">此处</a>跳转";
			t--;
		}
	</script>
</body>
</html>
