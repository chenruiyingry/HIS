<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>收费</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/tofee.css">
</head>
<body>
	<c:import url="/toHead.action">
		<c:param name="name" value="fee"></c:param>
	</c:import>
	<form action="fee.action">
	<div class="main" id="main">
		<div class="main_bar">
			<div><a href="javascript:void(0)" onclick="return change()" class="change">交班></a></div>
			<div class="main_bar_input">
				<input type="text" placeholder="卡号" class="number" name="code" value="${code }">
				<input type="submit" value="" class="submit">
				<i class="fa fa-search" aria-hidden="true"></i>
			</div>
		</div>
	</div>
	</form>
	<script>
		$(document).ready(function () {
			if (${!empty msg }) {
				swal({
					title: '${title }',
					text: '${msg }',
					type: '${status }'
				}).then(function(){
					window.location.href='/HIS/tofee.action';
				})
			}
		});
		var ta = document.getElementById('main');
		ta.style.height = $(window).height()-72+"px";
		function change() {
			$.ajax({
				type: 'POST',
				url: '/HIS/balance.action',
				data: {
					total: 100
				},
				dataType: "text",
				success: function(data) {
					swal({
						title: '确定交班？',
						text: "请按照以下款项清点现金：共"+data+"元",
						type: 'warning',
						showCancelButton: true,
						confirmButtonColor: '#3085d6',
						cancelButtonColor: '#d33',
						confirmButtonText: '确定无误'
						}).then(function(isConfirm) {
						if (isConfirm) {
							window.location.href='/HIS/logout.action';
						}
					})
				}
			})
		}
	</script>
</body>
</html>
