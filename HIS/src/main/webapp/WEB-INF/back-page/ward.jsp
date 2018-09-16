<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>病房管理</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/ward.css">
</head>
<body>
	<c:import url="/admin/toHead.do">
		<c:param name="headname" value="ward"></c:param>
	</c:import>
	<div class="main" id="main">
		<c:forEach items="${wards }" var="ward">
			<div class="module">
			<a href="javascript:void(0)" onclick="return ondelete(${ward.id })" class="module_delete"><i class="fa fa-trash" aria-hidden="true"></i></a>
				<form action="/HIS/admin/updateWard.do" method="post" onsubmit="return updateWard_${ward.id }()">
					<input type="hidden" name="id" value="${ward.id }">
					<input type="hidden" name="oldWard_code" value="${ward.ward_code }">
					<input type="text" value="${ward.ward_code }" class="wardnum ng wardnum_${ward.id } ng_${ward.id }" id="ward_code" title="双击修改" name="ward_code_${ward.id }">
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
					<c:forEach items="${ward.beds }" var="bed" >
						<div class="bed_1 bed_1_${bed.id } <c:if test="${!bed.occupy }">idle idle_${bed.id }</c:if><c:if test="${bed.occupy }">occupy occupy_${bed.id }</c:if>">
							<form action="/HIS/admin/updateBed.do" method="post" onsubmit="return updateBed_${bed.id }()">
								<input type="hidden" name="ward_code" value="${ward.ward_code }">
								<input type="hidden" name="id" value="${bed.id }">
								<input autocomplete="off" type="text" value="${bed.bed_code }" class="bednum bsp bsp_${bed.id }" name="bed_code" id="bed_code_${bed.id }">
								<input type="text" value="<c:if test="${!bed.occupy }">空闲</c:if><c:if test="${bed.occupy }">占用</c:if>" class="status bsp bsp_${bed.id } status_${bed.id }">
								<input autocomplete="off" type="text" value="${bed.price }" class="price bsp bsp_${bed.id }" name="price" id="price_${bed.id }">
								<input type="button" value="修改" class="bedmod bedmod_${bed.id }">
								<input type="submit" value="保存" class="bedsave bedsave_${bed.id }">
							</form>
							<i class="fa fa-angle-down fa-angle-down_${bed.id }" aria-hidden="true"></i>
							<div class="delete delete_${bed.id } <c:if test="${!bed.occupy }">idel_down_${bed.id }</c:if><c:if test="${bed.occupy }">occupy_down_${bed.id }</c:if>">
								<a href="javascript:void(0)" onclick="return ondeletebed(${bed.id })" class="beddel beddel_${bed.id }">删除</a>
							</div>
						</div>
					</c:forEach>
					<div class="bed_1 add add_${ward.id } bed_1_${ward.id }">
						<form action="/HIS/admin/addBed.do" method="post" onsubmit="return insertBed_${ward.id }()">
							<input type="hidden" name="ward_code" value="${ward.ward_code }">
							<input autocomplete="off" type="text" placeholder="床号" class="bednum bsp bsp_${ward.id } bednum_${ward.id }" name="bed_code" id="bed_code1_${ward.id }">
							<input autocomplete="off" type="text" placeholder="价格" class="price bsp bsp_${ward.id } price_${ward.id }" name="price" id="price1_${ward.id }">
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
			<form action="/HIS/admin/addWard.do" class="form_plus" method="post" onsubmit="return insertWard()">
				<input type="text" placeholder="病房号" class="name_2 ngps np" name="ward_code" id="ward_code1">
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
	<script type="text/javascript" src="/HIS/res/js/ward.js"></script>
	<script type="text/javascript">
	$(document).ready(function () {
		if (${!empty msg }) {
			swal({
				title: '${title }',
				text: '${msg }',
				type: '${status }'
			}).then(function() {
				window.location.href='/HIS/admin/ward.do';
			})
		}
	});
	function ondelete(id) {
		swal({
			title: '确定删除？',
			text: "该操作将不能被撤销!",
			type: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '确定',
			cancelButtonText: '取消'
		}).then(function(isConfirm) {
			if (isConfirm === true) {
				window.location.href='/HIS/admin/deleteWard.do?id=' + id;
			} else if (isConfirm === false){
				window.location.href='/HIS/admin/ward.do';
			}
		})
	}
	function ondeletebed(id) {
		swal({
			title: '确定删除？',
			text: "该操作将不能被撤销!",
			type: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '确定',
			cancelButtonText: '取消'
		}).then(function(isConfirm) {
			if (isConfirm === true) {
				window.location.href='/HIS/admin/deleteBed.do?id=' + id;
			} else if (isConfirm === false){
				window.location.href='/HIS/admin/ward.do';
			}
		})
	}
	</script>
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
				$('.bednum_${ward.id }').val("");
				$('.price_${ward.id }').val("");
			});
			$('.bedmod_${ward.id }').click(function (){
				$('.bsp_${ward.id }').removeAttr('readonly');
				$('.status_${ward.id }').attr({"readonly": "readonly",});
				$('.bedsave_${ward.id }').css({"width": "90%", "left": "5%",});
				$('.bsp_${ward.id }').css({"color": "rgb(120, 120, 120)", "background-color": "#fff",});
				$('.bed_1_${ward.id }').css({"background-color": "#fff",});
			});
		});
		/*修改病房编号以及病房类型*/
		function updateWard_${ward.id }(){
			var ward_code = getID('ward_code_${ward.id }').value;	
			if(ward_code.length < 1 || ward_code == ""){
				swal({
					title: '操作失败...',
					text: '请完整填写信息！',
					type: 'error'
				})
				window.location.reload();
				return false;	
			}else{
				return true;
			}
		}
		/*添加病房信息*/
		function insertBed_${ward.id }(){
			var bed_code = getID('bed_code1_${ward.id }').value;
			var price = getID('price1_${ward.id }').value;
			if(bed_code.length < 1 || price.length <1){
				swal({
					title: '操作失败...',
					text: '请完整填写信息！',
					type: 'error'
				})
				return false;	
			}else{
				return true;
			}
		}
		</script>
		<c:forEach items="${ward.beds }" var="bed">
			<script type="text/javascript">
			$(document).ready(function (){
				$('.wardnum_${ward.id }').attr({"readonly": "readonly",});
				$('.wardgen_${ward.id }').attr({"disabled": "disabled",});
				$('.bsp_${bed.id }').attr({"readonly": "readonly",});
				$('.fa-angle-down_${bed.id }').css({"display": "none","color": "#000",});
				$('.idle_${bed.id }').mouseover(function (){
					$('.idle_${bed.id }').css({"height": "16%",});
					$('.bedmod_${bed.id }').css({"height": "25px",});
					$('.bedsave_${bed.id }').css({"height": "25px",});
					$('.fa-angle-down_${bed.id }').css({"display": "block",});
				});
				$('.idle_${bed.id }').mouseleave(function (){
					$('.bsp_${bed.id }').attr({"readonly": "readonly",});
					$('.idle_${bed.id }').css({"height": "8%",});
					$('.bedmod_${bed.id }').css({"height": "0px",});
					$('.bedsave_${bed.id }').css({"width": "0%", "left": "50%", "height": "0%",});
					$('.bsp_${bed.id }').css({"color": "#fff", "background-color": "#8ac3b3",});
					$('.bed_1_${bed.id }').css({"background-color": "#8ac3b3",});
					$('.fa-angle-down_${bed.id }').css({"display": "none","color": "#000",});
					$('.idle_${bed.id }').css({"margin-bottom": "3%",});
					$('.delete_${bed.id }').css({"height": "0px",});
					$('.beddel_${bed.id }').css({"height": "0px",});
				});
				$('.occupy_${bed.id }').mouseover(function (){
					$('.occupy_${bed.id }').css({"height": "16%",});
					$('.bedmod_${bed.id }').css({"height": "25px",});
					$('.bedsave_${bed.id }').css({"height": "25px",});
					$('.fa-angle-down_${bed.id }').css({"display": "block",});
				});
				$('.occupy_${bed.id }').mouseleave(function (){
					$('.bsp_${bed.id }').attr({"readonly": "readonly",});
					$('.occupy_${bed.id }').css({"height": "8%",});
					$('.bedmod_${bed.id }').css({"height": "0px",});
					$('.bedsave_${bed.id }').css({"width": "0%", "left": "50%", "height": "0%",});
					$('.bsp_${bed.id }').css({"color": "#fff", "background-color": "#dc8c8c",});
					$('.bed_1_${bed.id }').css({"background-color": "#dc8c8c",});
					$('.fa-angle-down_${bed.id }').css({"display": "none","color": "#000",});
					$('.occupy_${bed.id }').css({"margin-bottom": "3%",});
					$('.delete_${bed.id }').css({"height": "0px",});
					$('.beddel_${bed.id }').css({"height": "0px",});
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
				$('.fa-angle-down_${bed.id }').click(function (){
					$('.idle_${bed.id }').css({"margin-bottom": "12%",});
					$('.occupy_${bed.id }').css({"margin-bottom": "12%",});
					$('.fa-angle-down_${bed.id }').css({"color": "#fff0",});
					$('.delete_${bed.id }').css({"height": "33px",});
					$('.idel_down_${bed.id }').css({"background-color": "#8ac3b3",});
					$('.occupy_down_${bed.id }').css({"background-color": "rgb(220, 140, 140)",});
					$('.beddel_${bed.id }').css({"height": "25px",});
				});
			});
			/*修改病床信息*/
			function updateBed_${bed.id }(){
				var bed_code = getID('bed_code_${bed.id }').value;
				var price = getID('price_${bed.id }').value;
				if(bed_code.length < 1 || price.length <1 || bed_code == "" || price == ""){
					swal({
						title: '操作失败...',
						text: '请完整填写信息！',
						type: 'error'
					})
					window.location.reload();
					return false;	
				}else{
					return true;
				}
			}
			</script>
		</c:forEach>
	</c:forEach>
</body>
</html>