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
		<c:forEach items="${list }" var="division">
			<div class="module" id="module">
				<form action="">
					<div class="modif md" title="长按左侧修改"></div>
					<div class="delete md" title="长按右侧删除">
						<a href="" class="delete_a">delete</a>
						<p id="time"></p>
					</div>
					<input type="text" value="${divison.name }" class="name">
					<p class="number">${divisoin.p_code }</p>
					<textarea class="textarea">${divisoin.introduction }</textarea>
					<p class="number_p">科室总数：${division.doctornum }</p>
					<p id="time"></p>
					<input type="button" value="取消" class="cancel cs">
					<input type="submit" value="保存" class="submit cs">
				</form>
			</div>
		</c:forEach>
		<div class="module module_plus">
			<input type="button" class="return_p" title="单击返回">
			<input type="button" class="plus">
			<i class="fa fa-plus-square-o fa-5x" aria-hidden="true"></i>
			<form action="">
				<input type="text" value="科室名称" class="name_2">
				<textarea class="plusresume">科室简介</textarea>
				<input type="submit" value="保存" class="save">
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/department.js"></script>
</body>
</html>