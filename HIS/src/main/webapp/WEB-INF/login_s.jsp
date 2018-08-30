<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sign in</title>
	<link rel="shortcut icon" href="img/favicon.ico">
	<link rel="stylesheet" href="css/login_s.css">
	<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div class="slider" id="slider" style="--img-prev:url(img/1.jpg)"> 
	 	<div class="slider__content" id="slider-content">
			<div class="slider__images">
			 	<div class="slider__images-item slider__images-item--active" data-id="1"><img src="img/1.jpg"></div>
			 	<div class="slider__images-item" data-id="2"><img src="img/2.jpg"></div>
			 	<div class="slider__images-item" data-id="3"><img src="img/3.jpg"></div>
			 	<div class="slider__images-item" data-id="4"><img src="img/4.jpg"></div>
			 	<div class="slider__images-item" data-id="5"><img src="img/5.jpg"></div>
			</div>
			<div class="slider__text">
			 	<div class="slider__text-item slider__text-item--active" data-id="1">
					<div class="slider__text-item-head">
					 	<h3>HIS</h3>
					</div>
					<div class="slider__text-item-info">
					 	<p id="en_1">“An information system for use in a hospital includes a mobile terminal for inputting and outputting data”</p>
					 	<p class="zh_0" id="zh_1">用于医院的信息系统包括用于输入和输出数据的移动终端</p>
					</div>
			 	</div>
			 	<div class="slider__text-item" data-id="2">
					<div class="slider__text-item-head">
					 	<h3>Pharmacy</h3>
					</div>
					<div class="slider__text-item-info">
					 	<p id="en_2">“The technical field related to drug storage management, specifically relates to a pharmacy drug storage information management system”</p>
					 	<p class="zh_0" id="zh_2">涉及药品仓储管理的技术领域，具体涉及一种药房药品仓储信息管理系统</p>
					</div>
			 	</div>
			 	<div class="slider__text-item" data-id="3">
					<div class="slider__text-item-head">
					 	<h3>Consultation</h3>
					</div>
					<div class="slider__text-item-info">
					 	<p id="en_3">“The invention relates to an emergency medical treatment device for emergency first aid, which is open, easy to expand and multifunctional”</p>
					 	<p class="zh_0" id="zh_3">涉及一种具有开放式、易扩展、多功能的急诊急救用医疗诊察装置</p>
					</div>
			 	</div>
			 	<div class="slider__text-item" data-id="4">
					<div class="slider__text-item-head">
					 	<h3>Out-patient</h3>
					</div>
					<div class="slider__text-item-info">
					 	<p id="en_4">“The invention relates to the field of medical information technology, in particular to an electronic medical record system with electronic signature and file management function applied to an outpatient clinic.”</p>
					 	<p class="zh_0" id="zh_4">涉及医用信息技术领域，尤其涉及一种应用于门诊的具有电子签名以及档案管理功能的电子病案系统</p>
					</div>
			 	</div>
			 	<div class="slider__text-item" data-id="5">
					<div class="slider__text-item-head">
					 	<h3>In-patient</h3>
					</div>
					<div class="slider__text-item-info">
					 	<p id="en_5">“The technical field of medical equipment and devices, in particular, relates to a nursing interaction for inpatient departments”</p>
					 	<p class="zh_0" id="zh_5">医疗设备与装置技术领域，具体涉及一种住院部用的护理交互</p>
					</div>
			 	</div>
			</div>
	 	</div>
	 	<div class="slider__nav">
			<div class="slider__nav-arrows">
			 	<div class="slider__nav-arrow slider__nav-arrow--left" id="left">to left</div>
			 	<div class="slider__nav-arrow slider__nav-arrow--right" id="right">to right</div>
			</div>
			<div class="slider__nav-dots" id="slider-dots"></div>
	 	</div>
	</div>
	<div class="main" id="main">
		<div class="changeLanguage">
			<a href="" id="EZ">EN</a>
			<div class="Lbar">
				<button onclick="ENLanguage()">EN</button>
				<button onclick="ZHLanguage()">ZH</button>
			</div>
		</div>
		<div class="title">
			<h1 id="his">Hospital Information System</h1>
			<span id="timeShow_1"></span>
			<span id="timeShow"></span>
		</div>
		<div class="loginbar" id="loginbar">
			<h3 id="si">Sign in</h3>
			<form action="" onsubmit="return check()">
				<input type="text" placeholder="User ID" id="username">
				<input type="password" placeholder="Password" id="userpwd">
				<input type="submit" value="Sign In" onmouseover="mov()" onmouseout="mou()" class="submit" id="submit">
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<script>
		var bg = document.getElementById("bg-image");
		var main = document.getElementById("main");
		var username = document.getElementById("username");
		var userpwd = document.getElementById("userpwd");
		var loginbar = document.getElementById("loginbar");
		var si = document.getElementById("si");
		var submit = document.getElementById("submit");
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
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript" src="js/login_s.js"></script>
	<script type="text/javascript" src="js/login_sl.js"></script>
</body>
</html>