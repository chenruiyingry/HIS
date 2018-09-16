<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>取药</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/tofee.css">
</head>
<body>
	<c:import url="/toHead.action">
		<c:param name="name" value="drug"></c:param>
	</c:import>
	<form action="drug.action">
	<div class="main" id="main">
		<div class="main_bar">
			<div class="main_bar_input">
				<input type="text" placeholder="病人编号" class="number" name="code" value="${code }">
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
					window.location.href='/HIS/toDrug.action';
				})
			}
		});
		var ta = document.getElementById('main');
		ta.style.height = $(window).height()-72+"px";
	</script>
</body>
</html>
