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
	<title>部门管理</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/department_a.css">
</head>
<body>
	<c:import url="/admin/toHead.do">
		<c:param name="headname" value="division"></c:param>
	</c:import>
	<div class="main" id="main">
		<c:forEach items="${list }" var="division">
			<div class="module" id="module_${division.id }">
				<div class="md js_${division.id }">
					<input type="button" value="修改" class="modif mds ms modif_${division.id } mds_${division.id }">
					<input type="button" value="删除" class="delete mds delete_${division.id } mds_${division.id }">
					<input type="button" value="返回" class="return mds return_${division.id } mds_${division.id }">
				</div>
				<a href="/HIS/admin/department.do?code=${division.p_code }" class="view vd view_${division.id }"></a>
				<a href="/HIS/admin/deleteDepartment.do?id=${division.id }" class="delete_a vd delete_a_${division.id }"></a>
				<form action="/HIS/admin/updateDepartment.do" method="post" onsubmit="return check()">
					<input type="hidden" name="id" value="${division.id }">
					<input type="text" value="${division.name }" class="name nt nt_${division.id }" readonly name="name" id="name">
					<p class="number">编号：${division.p_code }</p>
					<textarea class="textarea nt nt_${division.id } textarea_${division.id }" readonly name="introduction" id="introduction">${division.introduction }</textarea>
					<p class="number_p">科室数量：${division.departmentnum }</p>
					<input type="submit" value="保存" class="submit mds ms submit_${division.id } mds_${division.id}">
				</form>
			</div>
		</c:forEach>
		<div class="module module_plus">
			<input type="button" class="return_p" title="单击返回">
			<input type="button" class="plus">
			<i class="fa fa-plus-square-o fa-5x" aria-hidden="true"></i>
			<form action="/HIS/admin/addDivision.do" method="post" onsubmit="return check1()">
				<input type="text" value="" placeholder="部门名称" class="name_2" name="name" id="name1">
				<textarea class="plusresume" name="introduction" placeholder="部门简介" id="introduction1"></textarea>
				<input type="submit" value="保存" class="save">
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/department_aIsnull.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/department_a.js"></script>
	<c:forEach items="${list }" var="division">
	<script type="text/javascript">
		$(document).ready(function (){
			$('.js_${division.id }').mouseover(function (){
				$('.js_${division.id }').css({"width": "100%", "height": "100%",});
				$('.modif_${division.id }').css({"top": "28%", "right": "65%", "width": "60px", "height": "60px",});
				$('.return_${division.id }').css({"top": "28%", "right": "65%", "width": "60px", "height": "60px",});
				$('.delete_${division.id }').css({"top": "60%", "right": "35%", "width": "60px", "height": "60px",});
				$('.submit_${division.id }').css({"top": "23%", "right": "28%", "width": "60px", "height": "60px",});
				$('.view_${division.id }').css({"top": "23%", "right": "28%", "width": "60px", "height": "60px", "color": "#fff",});
				$('.view_${division.id }').html("查看");
			});
			$('.js_${division.id }').mouseout(function (){
				$('.js_${division.id }').css({"width": "10%", "height": "10%",});
				$('.view_${division.id }').html("");
				$('.mds_${division.id }').css({"top": "0%", "right": "0%", "width": "0px", "height": "0px",});
				$('.view_${division.id }').css({"top": "0%", "right": "0%", "width": "0px", "height": "0px", "color": "#fff0",});
			});
			$('.submit_${division.id }').mouseover(function (){
				$('.js_${division.id }').css({"width": "100%", "height": "100%",});
				$('.return_${division.id }').css({"top": "28%", "right": "65%", "width": "60px", "height": "60px",});
				$('.modif_${division.id }').css({"top": "28%", "right": "65%", "width": "60px", "height": "60px",});
				$('.delete_${division.id }').css({"top": "60%", "right": "35%", "width": "60px", "height": "60px",});
				$('.submit_${division.id }').css({"top": "23%", "right": "28%", "width": "60px", "height": "60px",});
				$('.view_${division.id }').css({"top": "23%", "right": "28%", "width": "60px", "height": "60px", "color": "#fff",});
				$('.view_${division.id }').html("");
			});
			$('.view_${division.id }').mouseover(function (){
				$('.js_${division.id }').css({"width": "100%", "height": "100%",});
				$('.return_${division.id }').css({"top": "28%", "right": "65%", "width": "60px", "height": "60px",});
				$('.modif_${division.id }').css({"top": "28%", "right": "65%", "width": "60px", "height": "60px",});
				$('.delete_${division.id }').css({"top": "60%", "right": "35%", "width": "60px", "height": "60px",});
				$('.submit_${division.id }').css({"top": "23%", "right": "28%", "width": "60px", "height": "60px",});
				$('.view_${division.id }').css({"top": "23%", "right": "28%", "width": "60px", "height": "60px", "color": "#fff",});
				$('.view_${division.id }').html("查看");
			});
			
			$('.modif_${division.id }').click(function (){
				$('.nt_${division.id }').removeAttr('readonly');
				$('.js_${division.id }').css({"width": "10%", "height": "10%",});
				$('.mds_${division.id }').css({"top": "0%", "right": "0%", "width": "0px", "height": "0px",});
				$('.view_${division.id }').css({"top": "0%", "right": "0%", "width": "0px", "height": "0px", "color": "#fff0",});
				$('.submit_${division.id }').css({"z-index": "2"});
				$('.return_${division.id }').css({"z-index": "2"});
				$('.modif_${division.id }').css({"z-index": "-1"});
				$('.view_${division.id }').html("");
			});
			$('.return_${division.id }').click(function (){
				$('.return_${division.id }').css({"z-index": "-1"});
				$('.modif_${division.id }').css({"z-index": "2"});
				$('.submit_${division.id }').css({"z-index": "-1"});
				$('.view_${division.id }').html("");
				$('.nt_${division.id }').attr({"readonly": "readonly",});
				$('.js_${division.id }').css({"width": "10%", "height": "10%",});
				$('.mds_${division.id }').css({"top": "0%", "right": "0%", "width": "0px", "height": "0px",});
				$('.view_${division.id }').css({"top": "0%", "right": "0%", "width": "0px", "height": "0px", "color": "#fff0",});
			});
			$('.delete_${division.id }').click(function (){
				$('.submit_${division.id }').css({"z-index": "-1"});
				$('.nt_${division.id }').attr({"readonly": "readonly",});
				$('.js_${division.id }').css({"width": "10%", "height": "10%",});
				$('.mds_${division.id }').css({"top": "0%", "right": "0%", "width": "0px", "height": "0px",});
				$('.delete_a_${division.id }').css({"top": "40%", "right": "40%", "width": "60px", "height": "60px",});
				$('.delete_a_${division.id }').html("确定");
				$('#module_${division.id }').css({"background-color": "#a7a3a3",});
				$('.textarea_${division.id }').css({"background-color": "#a7a3a3",});
				$('.return_${division.id }').css({"z-index": "2"});
				$('.view_${division.id }').html("");
				$('.view_${division.id }').css({"top": "0%", "right": "0%", "width": "0px", "height": "0px", "color": "#fff0",});
				$('.return_${division.id }').click(function (){
					$('.delete_a_${division.id }').css({"top": "0%", "right": "0%", "width": "0px", "height": "0px",});
					$('.delete_a_${division.id }').html("");
					$('#module_${division.id }').css({"background-color": "#f5f5f5",});
					$('.textarea_${division.id }').css({"background-color": "#fff",});
				});
			});
		});
		</script>
	</c:forEach>
</body>
</html>