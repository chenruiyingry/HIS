<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>医生信息</title>
	<link rel="shortcut icon" href="res/img/favicon.ico">
	<link rel="stylesheet" href="res/css/font-awesome.min.css">
	<link rel="stylesheet" href="res/css/doctor_i.css">
	<link rel="stylesheet" href="res/css/homeHeader.css">
</head>
<body>
	<div class="head">
		<div class="bar_c">
			<div class="bar_b"></div>
			<div class="bar_c_a"></div>
		</div>
		<div class="half-head">
			<p class="title">医院信息管理系统</p>
			<p class="half-title">—— 医生信息</p>
		</div>
		<span class="timeShow_1" id="timeShow_1"></span>
		<div class="half-head_1">
			<a href="" class="bar_a" id="bar_a" onmouseover="mov()" onmouseout="mou()"><</a>
			<div class="bar" id="bar">
				<a href="doctor.html">医生</a>
				<a href="">病人</a>
				<a href="">病房</a>
				<a href="">药品</a>
				<a href="">收费</a>
			</div>
			<p class="username">Ginbing</p>
			<a href="" class="sign-out"><i class="fa fa-sign-out"></i></a>
		</div>
	</div>
	<form action="" id="myform">
	<div class="main" id="main">
		<div class="main_bar">
			<button type="button" onclick="modify()">修改</button>
			<a href="doctor_s.html" class="arrow-left_a faz"><i class="fa fa-arrow-left fa-2x faz" aria-hidden="true"></i></a>
			<i class="fa fa-check fa-2x faz" aria-hidden="true"></i>
			<i class="fa fa-times fa-2x faz" aria-hidden="true"></i>
			<input type="submit" value="" class="submit faz">
			<input type="reset" value="" class="reset faz">
			<div class="photo">
				<img src="img/author_head.gif" alt="img">
			</div>
			<table>
				<tr>
					<td class="td_4">姓名</td>
					<td><input type="text" class="td_3" value="Ginbing"></td>
					<td>性别</td>
					<td>
						<input type="text" class="td_3 td_3_gdd">
						<input type="radio" name="gender" class="gender duty"><span class="male mf">男</span>
						<input type="radio" name="gender" class="gender duty"><span class="famale mf">女</span>
					</td>
				</tr>
				<tr>
					<td>民族</td>
					<td><input type="text" class="td_3"></td>
					<td>籍贯</td>
					<td><input type="text" class="td_3"></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><input type="text" class="td_3"></td>
					<td>医生编号</td>
					<td><input type="text" class="td_3"></td>
				</tr>
				<tr>
					<td>最高学位</td>
					<td><input type="text" class="td_3"></td>
					<td>毕业院校</td>
					<td><input type="text" class="td_3"></td>
				</tr>
				<tr>
					<td>联系地址</td>
					<td><input type="text" class="td_3"></td>
					<td>联系电话</td>
					<td><input type="text" class="td_3"></td>
					<td>电子邮箱</td>
					<td><input type="text" class="td_1 td_3"></td>
				</tr>
				<tr>
					<td>资格证书编码</td>
					<td><input type="text" class="td_3"></td>
					<td>执业证书编码</td>
					<td><input type="text" class="td_3"></td>
					<td>科室</td>
					<td id="department">
						<input type="text" class="td_1 td_3 td_3_gdd">
						<select name="" id="" class="td_3 td_3_department">
							<option value="">1</option>
							<option value="">2</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>医师级别</td>
					<td><input type="text" class="td_3"></td>
					<td>职称</td>
					<td><input type="text" class="td_3"></td>
					<td>职务</td>
					<td><input type="text" class="td_1 td_3"></td>
				</tr>
				<tr>
					<td>入职时间</td>
					<td><input class="td_3 date" type="date" name="user_date" /></td>
					<td>从事专业</td>
					<td><input type="text" class="td_3"></td>
					<td>备注</td>
					<td rowspan="2"><textarea class="td_2 td_3"></textarea></td>
				</tr>
				<tr>
					<td>是否值班</td>
					<td>
						<input type="text" class="td_3 td_3_gdd">
						<input type="radio" name="duty" class="duty gender"><span class="male mf yn">是</span>
						<input type="radio" name="duty" class="duty gender"><span class="famale mf yn">否</span>
					</td>
					<td>工作时间</td>
					<td class="td_3_datetime">
						<input class="td_3 datetime" type="datetime-local" name="user_date" /> - 
						<input class="td_3 datetime" type="datetime-local" name="user_date" />
					</td>
				</tr>
			</table>
			<div class="introduction">
				<p class="introduction_title">简介</p>
				<p class="introduction_main"><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>求职信的长处是可根据求职对象的需求有针对性的拟订文稿，对于那些欲在外地谋职的毕业生更有一定优势。它的不足是，随着人才市场迅速发展、部门工作效率不断提高，很多招聘单位不愿再通过信件进行交流，直接面试已成为当前机关、企事业单位吸纳人才的主流方式。加之由于它反馈慢，且每应聘一个单位都必须撰写一份求职信，给毕业生带来诸多不便，甚至于耽搁了时间、贻误了时机。 个人简介则不同，毕业生可用相同的个人资料去应聘众多求职单位，同时也节省了发信、等信而消耗的时间。而与个人简介相应的直接应聘可减少不必要环节，有助于招聘者全面、真实地了解和考察毕业生，使工作变得更加快捷、有效。 可以说，个人简介与求职信互有长短，毕业生可根据不同情况、不同时机选择恰当的文种，以更有利于求职。</p>
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="res/js/doctor_i.js"></script>
	<script type="text/javascript" src="res/js/homeHeader.js"></script>
</body>
</html>