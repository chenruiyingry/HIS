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
			<!-- <canvas></canvas> -->
			<div><a href="javascript:void(0)" onclick="return change()" class="change">交班></a></div>
			<div class="main_bar_input">
				<input type="text" placeholder="卡号" class="number" name="code" value="${code }">
				<input type="submit" value="" class="submit">
				<i class="fa fa-search" aria-hidden="true"></i>
				<p class="errormsg">${msg }</p>
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script>
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
