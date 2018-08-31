<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sign in</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/login.css">
	<link rel="stylesheet" href="/HIS/res/css/login_o.css">
</head>
<body>
	<img class="bg-image" id="bg-image" src="/HIS/res/img/be5004e71963dbe7b2066098c2636721.jpg" alt="img">
	<div class="main" id="main">
		<div class="changeLanguage">
			<a href="" id="EZ">EN</a>
			<div class="Lbar">
				<button onclick="ENLanguage()">EN</button>
				<button onclick="ZHLanguage()">ZH</button>
			</div>
		</div>
		<div class="title">
			<!-- <h1 id="his">Hospital Information System</h1> -->
			<img src="/HIS/res/img/login_logo_2.png" id="his">
			<p id="bom">—— Back Office Management</p>
			<span id="timeShow_1"></span>
			<span id="timeShow"></span>
		</div>
		<div class="loginbar" id="loginbar">
			<h3 id="si">Sign in</h3>
			<form action="" onsubmit="return check()" id="loginform" method="post">
				<input type="text" placeholder="User ID" id="username" value="${username }" name="username">
				<input type="password" placeholder="Password" id="userpwd" value="${password }" name="password">
				<p>${msg }</p>
				<input type="submit" value="Sign In" onmouseover="mov()" onmouseout="mou()" class="submit" id="submit">
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script>
		var bg = document.getElementById("bg-image");
		var main = document.getElementById("main");
		var username = document.getElementById("username");
		var userpwd = document.getElementById("userpwd");
		var loginbar = document.getElementById("loginbar");
		var si = document.getElementById("si");
		var submit = document.getElementById("submit");
		bg.style.height = $(window).height()+"px";
		main.style.height = $(window).height()+"px";
		$("input").focus(function(){
			username.placeholder = "用户名";
			userpwd.placeholder = "密码";
			loginbar.style.cssText = "background: rgba(248, 248, 248, 0.7);";
			si.style.cssText = "color: rgb(120, 120, 120);";
			submit.style.cssText = "background-color: rgb(230, 89, 78);";
			submit.disabled = false;
		});
	</script>
	<script type="text/javascript" src="/HIS/res/js/login.js"></script>
	<script type="text/javascript" src="/HIS/res/js/login_l.js"></script>
</body>
</html>