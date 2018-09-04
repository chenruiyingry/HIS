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
	<title>药品管理</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/paging.css">
	<link rel="stylesheet" href="/HIS/res/css/drugs.css">
	<link rel="stylesheet" href="/HIS/res/css/homeHeader.css">
</head>
<body>
	<c:import url="/admin/toHead.do?name=drug"></c:import>
	<div class="main" id="main">
		<div class="main_bar">
			<div class="search">
				<form action="">
					<input type="text" placeholder="请输入搜索关键字" class="text">
					<input type="submit" value="" class="submit">
					<i class="fa fa-search" aria-hidden="true"></i>
				</form>
			</div>
			<div class="pagin"><!-- 分页 -->
				<a href="" class="fa_left" title="上一页"><i class="fa fa-arrow-left fa-2x" aria-hidden="true"></i></a>
				<a href="" class="fa_right" title="下一页"><i class="fa fa-arrow-right fa-2x" aria-hidden="true"></i></a>
			</div>
			<div class="main_a"></div>
			<div class="main_left">
				<div class="main_content"><!-- 循环 -->
					<p class="name">乙肝清热解毒胶囊</p>
					<p class="effect"><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>清肝利胆，利湿解毒。用于肝胆湿热引起的黄疸(或无黄疸)、发烧(或低烧)口干苦或口黏臭，厌油，胃肠不适，舌质红，舌苔厚腻，脉弦滑数等；急慢性病毒性乙型肝炎初期或活动期、乙型肝炎病毒携带者见上述证候者。</p>
				</div>
			</div>
			<form action="">
			<div class="main_right_top">
				<div class="drop drop_t">
					<p>药名</p>
					<input class="drop_t_i" type="text">
				</div>
				<div class="drop drop_t">
					<p>生产方</p>
					<input class="drop_t_i" type="text">
				</div>
				<div class="drop drop_t">
					<p>进货价</p>
					<input class="drop_t_i" type="text">
				</div>
				<div class="drop drop_t">
					<p>售价</p>
					<input class="drop_t_i" type="text">
				</div>
				<div class="drop drop_t">
					<p>计量单位</p>
					<input class="drop_t_i" type="text">
				</div>
				<div class="drop drop_t">
					<p>库存量</p>
					<input class="drop_t_i" type="text">
				</div>
				<input type="button" value="修改" class="button_1 button_2">
				<input type="submit" value="确定" class="submit_3 button_2">
			</div>
			</form>
			<form action="">
			<div class="main_right_bottom">
				<div class="drop drop_b">
					<p class="drop_b_p">药名</p>
					<input class="drop_b_i" type="text">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">主治功能</p>
					<input class="drop_b_i" type="text">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">生产方</p>
					<input class="drop_b_i" type="text">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">进货价</p>
					<input class="drop_b_i" type="text">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">售价</p>
					<input class="drop_b_i" type="text">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">计量单位</p>
					<input class="drop_b_i" class="drop_b_i" type="text">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">生产日期</p>
					<input class="drop_b_i" type="text">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">有效日期</p>
					<input class="drop_b_i" type="text">
				</div>
				<div class="submit_bar"></div>
				<input type="submit" value="添加" class="submit submit_2">
			</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/drugs.js"></script>
	<script type="text/javascript" src="/HIS/res/js/homeHeader.js"></script>
</body>
</html>
