<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>病人管理</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/paging.css">
	<link rel="stylesheet" href="/HIS/res/css/patient_s.css">
</head>
<body>
	<c:import url="/admin/toHead.do">
		<c:param name="headname" value="patient"></c:param>
	</c:import>
	<div class="main" id="main">
		<div class="main_bar">
			<div class="search">
				<form action="/HIS/admin/patientList.do">
					<input type="text" placeholder="请输入搜索关键字" class="text" name="name">
					<input type="submit" value="" class="submit">
					<i class="fa fa-search" aria-hidden="true"></i>
				</form>
			</div>
			<div class="main_content">
				<table>
					<tr class="tr_1">
						<td>编号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>联系电话</td>
						<td>年龄</td>
						<td>医保类型</td>
						<td>操作</td>
					</tr>
					<hr class="line"/>
					<c:forEach items="${pagination.list }" var="patient">
						<tr class="tr_td"><!-- 循环 -->
							<td><a href="/HIS/admin/patient.do?code=${patient.code }">${patient.code }</a></td>
							<td><a href="/HIS/admin/patient.do?code=${patient.code }">${patient.name }</a></td>
							<td><c:if test="${patient.sex eq 'MAN' }">男</c:if>
							<c:if test="${patient.sex eq 'WOMAN' }">女</c:if></td>
							<td>${patient.phone }</td>
							<td>${patient.age }</td>
							<td>
							${patient.insurance_type }
							</td>
							<td class="td_1">
								<div class="td_1_d js_${patient.id }">
									<a href="javascript:void(0)" onclick="if(!confirm('您确定删除吗？')) {return false;} window.location.href='/HIS/admin/deletePatient.do?code=${patient.code }'" class="td_1_d_a js_a_${patient.id }">删除</a>
								</div>
								<a href="/HIS/admin/patient.do?code=${patient.code }">查看</a>
							</td>
						</tr>
					</c:forEach>
					<c:if test="${empty pagination.list }">
						<p class="selectnone">查无相关信息，请重新尝试！！</p>
					</c:if>
				</table>
			</div>
			<div class="paging">
				<div class="container middle">
					<div class="pagination">
					  <c:forEach items="${pagination.pageView }" var="page">
						  ${page }
					  </c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
		var main = document.getElementById('main');
		main.style.height = $(window).height()-72+"px";
	</script>
	<c:forEach items="${pagination.list }" var="patient">
		<script>
			$(document).ready(function (){
				$('.js_${patient.id }').mouseover(function (){
					$('.js_${patient.id }').css({"width": "100%",});
					$('.js_a_${patient.id }').css({"z-index": "1", "width": "66%",});
				});
				$('.js_${patient.id }').mouseout(function (){
					$('.js_${patient.id }').css({"width": "10%",});
					$('.js_a_${patient.id }').css({"z-index": "-1", "width": "244%",});
				});
			});
		</script>
	</c:forEach>
</body>
</html>