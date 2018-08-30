<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>HIS</title>
	<link rel="shortcut icon" href="../res/img/favicon.ico">
	<link rel="stylesheet" href="../res/css/font-awesome.min.css">
	<link rel="stylesheet" href="../res/css/index.css">
	<link rel="stylesheet" href="../res/css/homeHeader.css">
</head>
<body>
	<div class="head">
		<div class="bar_b"></div>
		<div class="half-head">
			<p class="title">医院信息管理系统</p>
			<p class="half-title">―― 后台管理</p>
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
			<p class="username">${admin_session.username }</p>
			<a href="../admin/logout.do" class="sign-out"><i class="fa fa-sign-out"></i></a>
		</div>
	</div>
	<div id="ta">
		<div id="theArt">
			<div class="artGroup slide artGroup_1">
				<div class="artwork"> <img src="../res/img/6.jpg">
					<a href="">
						<div class="detail">
							<h3>医生管理</h3>
							<p><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>通过医生编号查询到医生信息列表，以及查询、添加、更新、删除医生信息。</p>
						</div>
					</a>
				</div>
			</div>
			<div class="artGroup slide artGroup_2">
				<div class="artwork"> <img src="../res/img/7.jpg">
					<a href="">
						<div class="detail">
							<h3>病人管理</h3>
							<p><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>通过病人编号查询到病人信息列表，以及添加、更新、删除病人信息。</p>
						</div>
					</a>
				</div>
			</div>
			<div class="artGroup slide artGroup_3">
				<div class="artwork"> <img src="../res/img/10.jpg">
					<a href="">
						<div class="detail">
							<h3>门诊管理</h3>
							<p><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>通过科室编号查询部门编号、科室名字、简介、人数，以及添加、更新、删除科室信息。</p>
						</div>
					</a>
				</div>
			</div>
			<div class="artGroup slide artGroup_4">
				<div class="artwork"> <img src="../res/img/8.jpg">
					<a href="">
						<div class="detail">
							<h3>病房管理</h3>
							<p><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>通过病房编号查询病床编号、通过病床编号查询病床是否被占用。可以添加、更新、删除病房编号与病床编号。</p>
						</div>
					</a>
				</div>
			</div>
			<div class="artGroup slide artGroup_5">
				<div class="artwork"> <img src="../res/img/9.jpg">
					<a href="">
						<div class="detail">
							<h3>药品管理</h3>
							<p><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>通过药物编号查询到药物信息列表，以及添加药物信息、更新药物信息、删除药物信息。</p>
						</div>
					</a>
				</div>
			</div>
			<div class="artGroup slide artGroup_6">
				<div class="artwork"> <img src="../res/img/11.jpg">
					<a href="">
						<div class="detail">
							<h3>收费管理</h3>
							<p><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>通过详细费用编号或者病历编号查询详细费用信息、通过病历号查询所有缴费单、通过详细费用编号修改支付方式、通过详细费用编号修改费用表、删除费用表。</p>
						</div>
					</a>
				</div>
			</div>
		</div>
		<div class="foot">
			<p>@2018 HIS</p>
		</div>
	</div>
	<script type="text/javascript" src="../res/js/modernizr.min.js"></script>
	<script type="text/javascript" src="../res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="../res/js/index.js"></script>
	<script>
		var ta = document.getElementById('ta');
		ta.style.height = $(window).height()-72+"px";
	</script>
</body>
</html>