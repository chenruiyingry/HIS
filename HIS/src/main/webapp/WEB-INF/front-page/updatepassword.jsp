<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改密码</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/updatepassword.css">
</head>
<body>
	<c:import url="/toHead.action">
		<c:param name="name" value="password"></c:param>
	</c:import>
	<form action="/HIS/updatepasswd.action" onsubmit="return chkAll()" >
	<div class="main" id="main">
		<div class="main_bar">
			<div class="main_bar_input">
				<input type="hidden" name="code" value="${doctorsession.code }">
				<div class="input">
					<input class="number" type="password" placeholder="输入原密码" id="pw" name="pw" >
					<p id="msg" class="error"></p>
				</div>
				<div class="input">
					<input class="number" type="password" placeholder="输入新密码" id="pw1" name="pw1"> 
					<p id="msg1" class="error"></p>
				</div>     
				<div class="input">
					<input class="number" type="password" placeholder="再次输入密码" id="pw2" name="pw2">
					<p id="msg2" class="error"></p>
				</div>
				<input class="submit" type="submit" value="修改" id="submit" name="submit">
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/check.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
		<script>
			var ta = document.getElementById('main');
			ta.style.height = $(window).height()-72+"px";
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

