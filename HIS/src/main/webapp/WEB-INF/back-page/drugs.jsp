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
			<!-- <div class="pagin">分页
				<a href="" class="fa_left" title="上一页"><i class="fa fa-arrow-left fa-2x" aria-hidden="true"></i></a>
				<a href="" class="fa_right" title="下一页"><i class="fa fa-arrow-right fa-2x" aria-hidden="true"></i></a>
			</div> -->
			<div class="main_a"></div>
			<div class="main_left">
				<c:forEach items="${pagination.list }" var="drug">
					<div class="main_content js_${drug.id }"><!-- 循环 -->
						<p class="name">${drug.name }</p>
						<p class="effect"><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>${drug.function }</p>
					</div>
				</c:forEach>
			</div>
			<div class="pagin">
				<c:forEach items="${pagination.pageView }" var="page">
					${page }
				</c:forEach>
			</div>
			<form action="">
			<div class="main_right_top">
				<div class="drop drop_t">
					<p>药名</p>
					<input class="drop_t_i" type="text" name="name" id="name">
				</div>
				<div class="drop drop_t">
					<p>生产方</p>
					<input class="drop_t_i" type="text" name="manufacturer" id="manufacturer">
				</div>
				<div class="drop drop_t">
					<p>进货价</p>
					<input class="drop_t_i" type="text" name="purchase_price" id="purchase_price">
				</div>
				<div class="drop drop_t">
					<p>售价</p>
					<input class="drop_t_i" type="text" name="sale_price" id="sale_price">
				</div>
				<div class="drop drop_t">
					<p>计量单位</p>
					<input class="drop_t_i" type="text" name="unit" id="unit">
				</div>
				<div class="drop drop_t">
					<p>库存量</p>
					<input class="drop_t_i" type="text" name="store" id="store">
				</div>
				<input type="button" value="修改" class="button_1 button_2">
				<input type="submit" value="确定" class="submit_3 button_2">
			</div>
			</form>
			<form action="/HIS/admin/addDurg.do">
			<div class="main_right_bottom">
				<div class="drop drop_b">
					<p class="drop_b_p">药名</p>
					<input class="drop_b_i" type="text" name="name">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">主治功能</p>
					<input class="drop_b_i" type="text" name="function">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">生产方</p>
					<input class="drop_b_i" type="text" name="manufacturer">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">进货价</p>
					<input class="drop_b_i" type="text" name="purchase_price">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">售价</p>
					<input class="drop_b_i" type="text" name="sale_price">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">计量单位</p>
					<input class="drop_b_i" class="drop_b_i" type="text" name="unit">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">生产日期</p>
					<input class="drop_b_i" type="date" name="produce_date">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">有效日期</p>
					<input class="drop_b_i" type="date" name="effective_date">
				</div>
				<div class="submit_bar"></div>
				<input type="submit" value="添加" class="submit submit_2">
			</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/drugs.js"></script>
	<script type="text/javascript">
		var main = document.getElementById('main');
		main.style.height = $(window).height()-72+"px";
	</script>
	<c:forEach items="${pagination.list }" var="drug">
		<script type="text/javascript">
		$(document).ready(function (){
			$('.js_${drug.id }').mouseover(function (){
				$('.main_right_bottom').css({"height": "5%",});
				$('.main_right_top').css({"height": "61%",});
				$('.drop_b').css({"z-index": "-1", "padding-top": "0%",});
				$('.submit_bar').css({"height": "100%",});
				$('.submit_2').css({"margin-bottom": "0%", "left": "0px", "width": "100%", "height": "40px", "background-color": "#57a0d2cf",});
				$('.submit_2').val("返回");
				$('.button_1').css({"z-index": "3","background-color": "rgb(255, 138, 138)",});
				$('.js_${drug.id }').css({"box-shadow": "rgba(0, 0, 0, 0.43) -3px 3px 5px", "left": "3px",});
				$.ajax({
					type: 'POST',
					url: '/HIS/admin/drug.do',
					data: {
						code: ${drug.code }
					},
					dataType: "json",
					success: function(data) {
						$("#name").val(data.name);
						$("#manufacturer").val(data.manufacturer);
						$("#purchase_price").val(data.purchase_price);
						$("#sale_price").val(data.sale_price);
						$("#unit").val(data.unit);
						$("#store").val(data.store);
					}
				})
			});
			$('.js_${drug.id }').mouseout(function (){
				$('.js_${drug.id }').css({"box-shadow": "rgba(0, 0, 0, 0.43) 0px 0px 0px", "left": "0%",});
			});
		});
		</script>
	</c:forEach>
</body>
</html>
