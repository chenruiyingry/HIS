<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>病房管理</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/ward.css">
</head>
<body>
	<c:import url="/admin/toHead.do">
		<c:param name="headname" value="ward"></c:param>
	</c:import>
	<div class="main" id="main">
		<c:forEach items="${wards }" var="ward">
			<div class="module">
				<form action="/HIS/admin/updateWard.do" method="post">
					<input type="hidden" name="id" value="${ward.id }">
					<input type="hidden" name="oldWard_code" value="${ward.ward_code }">
					<input type="text" value="${ward.ward_code }" class="wardnum ng wardnum_${ward.id } ng_${ward.id }" title="双击修改" name="ward_code">
					<select name="type" id="" class="wardgen ng wardgen_${ward.id } ng_${ward.id }">
						<option value="NORMAL" <c:if test="${ward.type eq 'NORMAL' }">selected="selected"</c:if> >普通病房</option>
						<option value="ICU" <c:if test="${ward.type eq 'ICU' }">selected="selected"</c:if>>重症监护室</option>
						<option value="CCU" <c:if test="${ward.type eq 'CCU' }">selected="selected"</c:if>>心脏加护病房</option>
						<option value="VIP" <c:if test="${ward.type eq 'VIP' }">selected="selected"</c:if>>高级病房</option>
					</select>
					<input type="button" value="取消" class="wardcancel cs cs_${ward.id } wardcancel_${ward.id }">
					<input type="submit" value="确定" class="wardsave cs cs_${ward.id } wardsave_${ward.id }">
				</form>
				<div class="bed">
					<c:forEach items="${ward.beds }" var="bed">
						<div class="bed_1 bed_1_${bed.id } <c:if test="${!bed.occupy }">idle idle_${bed.id }</c:if><c:if test="${bed.occupy }">occupy occupy_${bed.id }</c:if>">
							<form action="/HIS/admin/updateWard.do" method="post">
								<input type="hidden" name="id" value="${bed.id }">
								<input type="text" value="${bed.bed_code }" class="bednum bsp bsp_${bed.id }" name="bed_code">
								<input type="text" value="<c:if test="${!bed.occupy }">空闲</c:if><c:if test="${bed.occupy }">占用</c:if>" class="status bsp bsp_${bed.id } status_${bed.id }">
								<input type="text" value="${bed.price }" class="price bsp bsp_${bed.id }" name="price">
								<input type="button" value="修改" class="bedmod bedmod_${bed.id }">
								<input type="submit" value="保存" class="bedsave bedsave_${bed.id }">
							</form>
						</div>
					</c:forEach>
					<div class="bed_1 add add_${ward.id } bed_1_${ward.id }">
						<form action="/HIS/admin/addWard.do" method="post">
							<input type="hidden" name="ward_code" value="${ward.ward_code }">
							<input type="text" placeholder="床号" class="bednum bsp bsp_${ward.id }" name="bed_code">
							<input type="text" placeholder="价格" class="price bsp bsp_${ward.id }" name="price">
							<input type="text" value="空闲" readonly="readonly" class="status bsp bsp_1">
							<input type="button" value="添加" class="bedmod bedmod_${ward.id }">
							<input type="submit" value="保存" class="bedsave bedsave_${ward.id }">
						</form>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="module module_plus">
			<input type="button" class="return_p" title="单击返回">
			<input type="button" class="plus">
			<i class="fa fa-plus-square-o fa-5x" aria-hidden="true"></i>
			<form action="/HIS/admin/addWard.do" class="form_plus" method="post">
				<input type="text" placeholder="病房号" class="name_2 ngps np" name="ward_code">
				<select name="type" id="" class="genre ngps gs">
					<option value="NORMAL">普通病房</option>
					<option value="ICU">重症监护室</option>
					<option value="CCU">心脏加护病房</option>
					<option value="VIP">高级病房</option>
				</select>
				<!-- <input type="text" placeholder="价格" class="price ngps np" name="price"> -->
				<input type="submit" value="保存" class="save ngps gs">
			</form>
		</div>
		<div class="module_bar"></div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/wardIsNull.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/ward.js"></script>
	<c:forEach items="${wards }" var="ward">
		<script type="text/javascript">
		$(document).ready(function (){
			$('.add_${ward.id }').mouseover(function (){
				$('.add_${ward.id }').css({"height": "16%",});
				$('.bedmod_${ward.id }').css({"height": "25px",});
				$('.bedsave_${ward.id }').css({"height": "25px",});
			});
			$('.add_${ward.id }').mouseleave(function (){
				$('.bsp_${ward.id }').attr({"readonly": "readonly",});
				$('.add_${ward.id }').css({"height": "8%",});
				$('.bedmod_${ward.id }').css({"height": "0px",});
				$('.bedsave_${ward.id }').css({"width": "0%", "left": "50%", "height": "0%",});
				$('.bsp_${ward.id }').css({"color": "#fff", "background-color": "#fff",});
				$('.bed_1_${ward.id }').css({"background-color": "#fff",});
			});
			$('.bedmod_${ward.id }').click(function (){
				$('.bsp_${ward.id }').removeAttr('readonly');
				$('.status_${ward.id }').attr({"readonly": "readonly",});
				$('.bedsave_${ward.id }').css({"width": "90%", "left": "5%",});
				$('.bsp_${ward.id }').css({"color": "rgb(120, 120, 120)", "background-color": "#fff",});
				$('.bed_1_${ward.id }').css({"background-color": "#fff",});
			});
		});
		</script>
		<c:forEach items="${ward.beds }" var="bed">
			<script type="text/javascript">
			$(document).ready(function (){
				$('.wardnum_${ward.id }').attr({"readonly": "readonly",});
				$('.wardgen_${ward.id }').attr({"disabled": "disabled",});
				$('.bsp_${bed.id }').attr({"readonly": "readonly",});
				$('.idle_${bed.id }').mouseover(function (){
					$('.idle_${bed.id }').css({"height": "16%",});
					$('.bedmod_${bed.id }').css({"height": "25px",});
					$('.bedsave_${bed.id }').css({"height": "25px",});
				});
				$('.idle_${bed.id }').mouseleave(function (){
					$('.bsp_${bed.id }').attr({"readonly": "readonly",});
					$('.idle_${bed.id }').css({"height": "8%",});
					$('.bedmod_${bed.id }').css({"height": "0px",});
					$('.bedsave_${bed.id }').css({"width": "0%", "left": "50%", "height": "0%",});
					$('.bsp_${bed.id }').css({"color": "#fff", "background-color": "#8ac3b3",});
					$('.bed_1_${bed.id }').css({"background-color": "#8ac3b3",});
				});
				$('.occupy_${bed.id }').mouseover(function (){
					$('.occupy_${bed.id }').css({"height": "16%",});
					$('.bedmod_${bed.id }').css({"height": "25px",});
					$('.bedsave_${bed.id }').css({"height": "25px",});
				});
				$('.occupy_${bed.id }').mouseleave(function (){
					$('.bsp_${bed.id }').attr({"readonly": "readonly",});
					$('.occupy_${bed.id }').css({"height": "8%",});
					$('.bedmod_${bed.id }').css({"height": "0px",});
					$('.bedsave_${bed.id }').css({"width": "0%", "left": "50%", "height": "0%",});
					$('.bsp_${bed.id }').css({"color": "#fff", "background-color": "#dc8c8c",});
					$('.bed_1_${bed.id }').css({"background-color": "#dc8c8c",});
				});
				$('.bedmod_${bed.id }').click(function (){
					$('.bsp_${bed.id }').removeAttr('readonly');
					$('.status_${bed.id }').attr({"readonly": "readonly",});
					$('.bedsave_${bed.id }').css({"width": "90%", "left": "5%",});
					$('.bsp_${bed.id }').css({"color": "rgb(120, 120, 120)", "background-color": "#fff",});
					$('.bed_1_${bed.id }').css({"background-color": "#fff",});
				});
				$('.ng_${ward.id }').dblclick(function (){
					$('.wardnum_${ward.id }').removeAttr('readonly');
					$('.wardgen_${ward.id }').removeAttr('disabled');
					$('.wardcancel_${ward.id }').removeAttr('disabled');
					$('.ng_${ward.id }').css({"background-color": "#fff",});
					$('.wardgen_${ward.id }').css({"-webkit-appearance": "menulist",});
					$('.cs_${ward.id }').css({"width": "15%",});
				});
				$('.wardcancel_${ward.id }').mouseover(function (){
					$('.wardcancel_${ward.id }').css({"width": "20%",});
				});
				$('.wardcancel_${ward.id }').mouseout(function (){
					$('.wardcancel_${ward.id }').css({"width": "15%",});
				});
				$('.wardsave_${ward.id }').mouseover(function (){
					$('.wardsave_${ward.id }').css({"width": "20%",});
				});
				$('.wardsave_${ward.id }').mouseout(function (){
					$('.wardsave_${ward.id }').css({"width": "15%",});
				});
				$('.wardcancel_${ward.id }').click(function (){
					$('.wardnum_${ward.id }').attr({"readonly": "readonly",});
					$('.wardgen_${ward.id }').attr({"disabled": "disabled",});
					$('.ng_${ward.id }').css({"background-color": "#fff0",});
					$('.wardgen_${ward.id }').css({"-webkit-appearance": "none",});
					$('.cs_${ward.id }').css({"width": "0%",});
					$('.wardcancel_${ward.id }').attr({"disabled": "disabled",});
				});
			});
			</script>
		</c:forEach>
	</c:forEach>
</body>
</html>