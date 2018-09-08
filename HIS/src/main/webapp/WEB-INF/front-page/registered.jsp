<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>挂号</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/registered.css">
	<link rel="stylesheet" href="/HIS/res/css/homeHeader.css">
</head>
<body>
	<div class="head">
		<div class="bar_c">
			<div class="bar_b"></div>
			<div class="bar_c_a"></div>
		</div>
		<div class="half-head">
			<p class="title">医院信息管理系统</p>
			<p class="half-title">—— 挂号管理</p>
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
			<p class="username_1" id="username_1">Ginbing</p>
			<a href="" class="sign-out"><i class="fa fa-sign-out"></i></a>
		</div>
	</div>
	<form action="" onSubmit="return check()">
	<div class="main" id="main">
		<div class="main_bar">
			<p class="title main_bar_title">挂号预填表</p>
			<input type="submit" value="提交" class="submit">
			<table>
				<tr>
					<td>姓名：</td>
					<td><input type="text" id="name" style="width: 70%;"></td>
					<td style="width: 5%;">性别：</td>
					<td style="width: 10%;">
						<select name="" id="" style="width: 50%;">
							<option value="">男</option>
							<option value="">女</option>
						</select>
					</td>
					<td>年龄：</td>
					<td style="width: 12%;"><input type="text" id="age" style="width: 70%;"></td>
					<td style="width: 7%;">医保类型：</td>
					<td style="width: 14%;">
						<select name="" id="" style="width: 70%;">
							<option value="">1</option>
							<option value="">2</option>
						</select>
					</td>
					<td style="width: 7%;">就诊科室：</td>
					<td style="width: 12%;">
						<select name="" id="" style="width: 100%;">
							<option value="">1</option>
							<option value="">2</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>现病史</td>
					<td colspan="9" class="td_9"><input type="text" id="present_illness"></td>
				</tr>
				<tr>
					<td>既病史</td>
					<td colspan="9" class="td_9"><input type="text" id="past_illness"></td>
				</tr>
				<tr>
					<td>过敏史</td>
					<td colspan="9" class="td_9"><input type="text" id="allergy"></td>
				</tr>
				<tr>
					<td>家庭地址：</td>
					<td colspan="4"><input type="text" id="address" style="width: 90%;"></td>
					<td>联系电话：</td>
					<td colspan="4"><input type="text" id="phone" style="width: 40%;"></td>
				</tr>
			</table>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/registered.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/homeHeader.js"></script>
	<script>
		var main = document.getElementById('main');
		main.style.height = $(window).height()-72+"px";
	</script>
</body>
</html>