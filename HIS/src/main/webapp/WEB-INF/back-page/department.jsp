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
	<title>科室管理</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/department.css">
</head>
<body>
	<c:import url="/admin/toHead.do">
		<c:param name="headname" value="department"></c:param>
	</c:import>
	<div class="main" id="main">
		<c:forEach items="${list }" var="department">
			<div class="module" id="module_${department.id }">
				<form action="/HIS/admin/updateDepartment.do" method="post" onsubmit="return check()">
					<div class="modif md modif_${department.id } md_${department.id }" title="长按左侧修改"></div>
					<div class="delete md md_${department.id } delete_${department.id }" title="长按右侧删除">
						<a href="javascript:void(0)" onclick="if(!confirm('您确定删除吗？')) {window.location.reload();return false;} window.location.href='/HIS/admin/deleteDepartment.do?id=${department.id }'" class="delete_a delete_a_${department.id }">delete</a>
						<p class="time" id="time_${department.id }"></p>
					</div>
					<input type="text" value="${department.name }" class="name name_${department.id }" name="name" id="name">
					<input type="hidden" name="id" value="${department.id }">
					<input type="hidden" name="code" value="${department.code }">
					<input type="hidden" name="p_code" value="${department.p_code }">
					<p class="number">编号：${department.code }</p>
					<textarea class="textarea textarea_${department.id }" name="introduction" id="introduction">${department.introduction }</textarea>
					<p class="number_p">医生人数：${department.doctornum }</p>
					<p class="time" id="time_${department.id }"></p>
					<input type="button" value="取消" class="cancel cs cs_${department.id }">
					<input type="submit" value="保存" class="submit cs cs_${department.id }">
				</form>
			</div>
		</c:forEach>
		<div class="module module_plus">
			<input type="button" class="return_p" title="单击返回">
			<input type="button" class="plus">
			<i class="fa fa-plus-square-o fa-5x" aria-hidden="true"></i>
			<form action="/HIS/admin/addDepartment.do" method="post" onsubmit="return check1()">
				<input type="hidden" name="p_code" value="${p_code }">
				<input type="text" placeholder="科室名称" class="name_2" name="name" id="name1">
				<textarea class="plusresume" name="introduction" placeholder="科室简介" id="introduction1"></textarea>
				<input type="submit" value="保存" class="save" >
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/departmentIsnull.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/department.js"></script>
	<c:forEach items="${list }" var="department">
		<script type="text/javascript">
		$(document).ready(function (){
			$('.modif_${department.id }').mousedown(function (){
				timeout = setTimeout(function() {
					$('#module_${department.id }').css({"color": "rgba(74, 74, 74, 0.56)",});
					$('.name_${department.id }').css({"color": "rgba(74, 74, 74, 0.56)", "z-index": "2",});
					$('.textarea_${department.id }').css({"color": "rgba(74, 74, 74, 0.56)", "z-index": "2",});
					$('.cs_${department.id }').css({"display": "block",});
					$('.modif_${department.id }').css({"background-color": "rgba(0, 0, 0, 0.16)", "width": "100%",});
				}, 300);
			});
			$('.delete_${department.id }').mousedown(function (){
				timeout = setTimeout(function() {
					$('#module_${department.id }').css({"color": "rgba(74, 74, 74, 0.56)", "background-color": "#ffc8c8",});
					$('.name_${department.id }').css({"color": "rgba(74, 74, 74, 0.56)",});
					$('.textarea_${department.id }').css({"color": "rgba(74, 74, 74, 0.56)",});
					$('.delete_${department.id }').css({"background-color": "rgba(0, 0, 0, 0.16)", "width": "100%",});
					setTimeout(function() {
						$('.delete_a_${department.id }')[0].click();
					}, 3500);
					$(function (){
						var s = 2;
						setInterval(function (){
							$('#time_${department.id }').html(s + ".0s 后删除");
							s--;
						}, 1000)
					});
				}, 200);
			});
			$('.md_${department.id }').mouseup(function (){
				clearTimeout(timeout);
				$('#module_${department.id }').css({"color": "rgba(74, 74, 74)",});
				$('.name_${department.id }').css({"color": "rgba(74, 74, 74)",});
				$('.textarea_${department.id }').css({"color": "rgba(74, 74, 74)",});
				$('.modif_${department.id }').css({"background-color": "rgba(0, 0, 0, 0)","width": "50%",});	
			});
			$('.md_${department.id }').mouseout(function (){
				$('#module_${department.id }').css({"color": "rgba(74, 74, 74)",});
				$('.name_${department.id }').css({"color": "rgba(74, 74, 74)",});
				$('.textarea_${department.id }').css({"color": "rgba(74, 74, 74)",});
				$('.modif_${department.id }').css({"background-color": "rgba(0, 0, 0, 0)","width": "50%",});
			});
		});
		</script>	
	</c:forEach>
</body>
</html>