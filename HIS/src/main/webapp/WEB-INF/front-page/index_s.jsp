<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>HIS</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/index_s.css">
</head>
<body>
	<c:import url="/toHead.action">
		<c:param name="name" value="frontindex"></c:param>
	</c:import>
	<div class="main" id="main">
		<div class='container'>
			<div class='wrap'>
				<div class='crop'>
					<a href="/HIS/toRegister.action" title="挂号"><img src='/HIS/res/img/10.jpg'></a>
				</div>
			</div>
			<div class='wrap'>
				<div class='crop'>
					<a href="/HIS/toVisit.action" title="诊疗"><img src='/HIS/res/img/77.png'></a>
				</div>
			</div>
			<div class='wrap'>
				<div class='crop'>
					<a href="/HIS/toFee.action" title="收费"><img src='/HIS/res/img/0111.png'></a>
				</div>
			</div>
			<div class='wrap'>
				<div class='crop'>
					<a href="/HIS/toDrug.action" title="取药"><img src='/HIS/res/img/133.png'></a>
				</div>
			</div>
		</div>
		<div class="foot">
			<p>@2018 HIS</p>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function () {
			if (${!empty msg }) {
				swal({
					title: '${title }',
					text: '${msg }',
					type: '${status }'
				}).then(function(){
					window.location.href='/HIS/toIndex.action';
				})
			}
		});
		var main = document.getElementById('main');
		main.style.height = $(window).height()-72+"px";
	</script>
</body>
</html>