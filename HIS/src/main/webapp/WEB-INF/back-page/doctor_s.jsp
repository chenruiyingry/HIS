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
</head>
<body>
	<c:import url="/admin/toHead.do?name=doctor"></c:import>
	<div class="main" id="main">
		<div class="main_bar">
			<a href="/HIS/admin/toAdd.do" class="plus_a" title="新增医生"><i class="fa fa-plus fa-2x" aria-hidden="true"></i></a>
			<div class="search">
				<form action="/HIS/admin/doctorList.do">
					<input type="text" placeholder="请输入搜索关键字" class="text" name="name">
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
					<c:forEach items="${pagination.list }" var="doctor">
						<tr><!-- 循环 -->
							<td class="main_content_td11">
								<a href="/HIS/admin/doctor.do?code=${doctor.code }"><img src="${doctor.allUrl }" alt="img"></a>
							</td>
							<td><a href="/HIS/admin/doctor.do?code=${doctor.code }">${doctor.code }</a></td>
							<td><a href="/HIS/admin/doctor.do?code=${doctor.code }">${doctor.name }</a></td>
							<td><c:if test="${doctor.sex eq 'MAN' }">男</c:if>
							<c:if test="${doctor.sex eq 'WOMAN' }">女</c:if></td>
							<td>${doctor.phone }</td>
							<td>${doctor.department }</td>
							<td>${doctor.level }</td>
							<td>${doctor.title }</td>
							<td>
							<c:if test="${doctor.worknow }">是</c:if>
							<c:if test="${!doctor.worknow }">否</c:if>
							</td>
							<td class="td_1">${doctor.work_time } ~ ${doctor.outwork_time }
								<div class="td_1_d js_${doctor.id }">
									<a href="javascript:void(0)" onclick="if(!confirm('您确定删除吗？')) {return false;} window.location.href='/HIS/admin/deleteDoctor.do?id=${doctor.id }'" class="td_1_d_a js_a_${doctor.id }">删除</a>
								</div>
								<div class="lookdetails"><a href="/HIS/admin/doctor.do?code=${doctor.code }">查看</a></div>
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
	<c:forEach items="${pagination.list }" var="doctor">
		<script>
			$(document).ready(function (){
				$('.js_${doctor.id }').mouseover(function (){
					$('.js_${doctor.id }').css({"width": "32%",});
					$('.js_a_${doctor.id }').css({"z-index": "1", "width": "100%",});
				});
				$('.js_${doctor.id }').mouseout(function (){
					$('.js_${doctor.id }').css({"width": "10%",});
					$('.js_a_${doctor.id }').css({"z-index": "-1", "width": "400%",});
				});
			});
		</script>
	</c:forEach>
</body>
</html>