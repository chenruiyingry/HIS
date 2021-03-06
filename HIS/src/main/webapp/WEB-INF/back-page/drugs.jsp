<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>药品管理</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/drugs.css">
</head>
<body>
	<c:import url="/admin/toHead.do">
		<c:param name="headname" value="drug"></c:param>
	</c:import>
	<div class="main" id="main">
		<div class="main_bar">
			<div class="search">
				<form action="/HIS/admin/durglist.do">
					<input type="text" placeholder="请输入搜索关键字" class="text" name="name">
					<input type="submit" value="" class="submit">
					<i class="fa fa-search" aria-hidden="true"></i>
				</form>
			</div>
			<div class="main_a"></div>
			<div class="main_left">
				<c:forEach items="${pagination.list }" var="drug">
					<div class="main_content js_${drug.id }"><!-- 循环 -->
						<p class="name">${drug.name }</p>
						<a href="javascript:void(0)" onclick="return ondelete(${drug.code })"  class="delete delete_${drug.id }"><i class="fa fa-times" aria-hidden="true"></i></a>
						<p class="effect"><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>${drug.funcction }</p>
					</div>
				</c:forEach>
			</div>
			<div class="pagin">
				<c:forEach items="${pagination.pageView }" var="page">
					${page }
				</c:forEach>
			</div>
			<form action="/HIS/admin/updateDrug.do" onSubmit="return check1()">
			<div class="main_right_top">
				<div class="drop drop_t">
					<p>药名</p>
					<input class="drop_t_i" type="text" name="name" id="name">
				</div>
				<div class="drop drop_t">
					<p>主治功能</p>
					<input class="drop_t_i" type="text" name="function" id="funcction">
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
					<p>库存量</p>
					<input class="drop_t_i" type="text" name="store" id="store">
				</div>
				<input type="hidden" name="code" id="code">
				<input type="button" value="修改" class="button_1 button_2">
				<input type="submit" value="确定" class="submit_3 button_2">
			</div>
			</form>
			<form action="/HIS/admin/addDurg.do" method="post" onSubmit="return check2()">
			<div class="main_right_bottom">
				<div class="drop drop_b">
					<p class="drop_b_p">药名</p>
					<input class="drop_b_i" type="text" name="name" id="name1">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">主治功能</p>
					<input class="drop_b_i" type="text" name="funcction" id="funcction1">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">生产方</p>
					<input class="drop_b_i" type="text" name="manufacturer" id="manufacturer1">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">进货价</p>
					<input class="drop_b_i" type="text" name="purchase_price" id="purchase_price1">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">售价</p>
					<input class="drop_b_i" type="text" name="sale_price" id="sale_price1">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">计量单位</p>
					<input class="drop_b_i" type="text" name="unit" id="unit1">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">规格</p>
					<input class="drop_b_i"  type="text" name="spec" id="spec1">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">生产日期</p>
					<input class="drop_b_i" type="date" name="produce_date" id="produce_date1">
				</div>
				<div class="drop drop_b">
					<p class="drop_b_p">有效日期</p>
					<input class="drop_b_i" type="date" name="effective_date" id="effective_date1">
				</div>
				<div class="submit_bar"></div>
				<input type="submit" value="添加" class="submit submit_2">
			</div>
			</form>
		</div>
	</div>
    <script type="text/javascript" src="/HIS/res/js/drugIsNull.js"></script>
	<script type="text/javascript" src="/HIS/res/js/drugs.js"></script>
	<script type="text/javascript">
		var main = document.getElementById('main');
		main.style.height = $(window).height()-72+"px";
		$(document).ready(function () {
			if (${!empty msg }) {
				swal({
					title: '${title }',
					text: '${msg }',
					type: '${status }'
				}).then(function(){
					window.location.href='/HIS/admin/druglist.do';
				})
			}
		});
		function ondelete(code) {
			swal({
				title: '确定删除？',
				text: "该操作将不能被撤销!",
				type: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#3085d6',
				cancelButtonColor: '#d33',
				confirmButtonText: '确定',
				cancelButtonText: '取消'
			}).then(function(isConfirm) {
				if (isConfirm === true) {
					window.location.href='/HIS/admin/deleteDrug.do?code=' + code;
				} else if (isConfirm === false){
					window.location.href='/HIS/admin/druglist.do';
				}
			})
		}
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
				$('.delete_${drug.id }').css({"color": "#ff8a8a",});
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
						$("#code").val(data.code);
						$("#name").val(data.name);
						$("#manufacturer").val(data.manufacturer);
						$("#purchase_price").val(data.purchase_price);
						$("#sale_price").val(data.sale_price);
						$("#funcction").val(data.funcction);
						$("#store").val(data.store);
					}
				})
			});
			$('.js_${drug.id }').mouseout(function (){
				$('.js_${drug.id }').css({"box-shadow": "rgba(0, 0, 0, 0.43) 0px 0px 0px", "left": "0%",});
				$('.delete_${drug.id }').css({"color": "#ff8a8a00",});
			});
		});
		</script>
	</c:forEach>
	<script type="text/javascript">
		$(document).ready(function (){
			$(".previouspage").html("<i class='fa fa-arrow-left fa-2x' aria-hidden='true' title='上一页'></i>");
			$(".nextpage").html("<i class='fa fa-arrow-right fa-2x' aria-hidden='true' title='下一页'></i>");
		});
	</script>
</body>
</html>
