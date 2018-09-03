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
	<title>医生管理</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/paging.css">
	<link rel="stylesheet" href="/HIS/res/css/doctor_s.css">
	<link rel="stylesheet" href="/HIS/res/css/homeHeader.css">
</head>
<body>
	<c:import url="/admin/toHead.do"></c:import>
	<div class="main" id="main">
		<div class="main_bar">
			<a href="doctor_i.html" class="plus_a"><i class="fa fa-plus fa-2x" aria-hidden="true"></i></a>
			<div class="search">
				<form action="">
					<input type="text" placeholder="请输入搜索关键字" class="text">
					<input type="submit" value="" class="submit">
					<i class="fa fa-search" aria-hidden="true"></i>
				</form>
			</div>
			<div class="main_content">
				<table>
					<tr class="tr_1">
						<td>医生编号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>联系电话</td>
						<td>科室</td>
						<td>医师级别</td>
						<td>职务</td>
						<td>是否值班</td>
						<td class="main_content_td10">工作时间</td>
					</tr>
					<tr><!-- 循环 -->
						<td class="main_content_td11">
							<a href=""><img src="/HIS/res/img/author_head.gif" alt="img"></a>
						</td>
						<td><a href="">0123456789</a></td>
						<td><a href="">胡椒粉</a></td>
						<td>男</td>
						<td>12345678901</td>
						<td>神经科</td>
						<td>主治医师</td>
						<td>主任</td>
						<td>是</td>
						<td class="td_1">09：00 ~ 12：00
							<div class="td_1_d">
								<a href=""  class="td_1_d_a">删除</a>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div class="paging">
				<div class="container middle">
					<div class="pagination">
					  <ul>
					      <li><a href="#"></a></li>
					      <li class="active"><a href="#"></a></li>
					      <li><a href="#"></a></li>
					      <li><a href="#"></a></li>
					      <li><a href="#"></a></li>
					      <li><a href="#"></a></li>
					      <li><a href="#"></a></li>
					  </ul>
					</div>
					<form action="">
						<div class="goto">
							到第<input type="text" class="pages">页
							<input type="submit" value="确定" class="define">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/homeHeader.js"></script>
	<script>
		var main = document.getElementById('main');
		main.style.height = $(window).height()-72+"px";
		$(document).ready(function (){
			$('.td_1_d').mouseover(function (){
				$('.td_1_d').css({"width": "40%",});
				$('.td_1_d_a').css({"z-index": "1", "width": "100%",});
			});
			$('.td_1_d').mouseout(function (){
				$('.td_1_d').css({"width": "10%",});
				$('.td_1_d_a').css({"z-index": "-1", "width": "400%",});
			});
		});
	</script>
</body>
</html>