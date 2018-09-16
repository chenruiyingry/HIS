<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改密码</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/updatepassword.css">
</head>
<body>
	<c:import url="/toHead.action">
		<c:param name="name" value="password"></c:param>
	</c:import>
	<form action="/HIS/updatepasswd.action" id="myform" method="post">
	<div class="main" id="main">
		<div class="main_bar">
			<div class="main_bar_input">
				<div class="input">
					<input class="number" type="password" placeholder="输入原密码" id="pw" name="pw" >
				</div>
				<div class="input">
					<input class="number" type="password" placeholder="输入新密码" id="pw1" name="pw1"> 
				</div>     
				<div class="input">
					<input class="number" type="password" placeholder="再次输入密码" id="pw2" name="pw2">
				</div>
				<input class="submit" type="button" value="修改" id="submit" name="submit" onclick="return updatepassword()">
			</div>
		</div>
	</div>
	</form>
	<script>
		$("#submit").click(function() {
			var flag = true;
			var oldPassword = $("#pw").val(); /*原始密码*/
	        var newPassword = $("#pw1").val(); /*新密码1*/
	        var repeatPassword = $("#pw2").val(); /*新密码2*/
	        var reg = /^[0-9a-zA-Z]{6,15}$/;
	        if(oldPassword == "" || oldPassword == null) {
	        	swal({
					title: '操作失败',
					text: '旧密码不能为空，请重新输入！',
					type: 'error'
				})
				flag = false;
	        } else if(newPassword == "" || newPassword == null){
	        	swal({
					title: '操作失败',
					text: '新密码不能为空，请重新输入！',
					type: 'error'
				})
				flag = false;
           	} else if(!reg.test(newPassword)){
        	   swal({
					title: '操作失败',
					text: '密码格式不正确，请重新输入！',
					type: 'error'
				})
				flag = false;
           	} else if(newPassword != repeatPassword){
           		swal({
					title: '操作失败',
					text: '两次输入密码不一致，请重新输入！',
					type: 'error'
				})
				flag = false;
            }
	        if(flag) {
	        	$.ajax({
	                url:"/HIS/updatepasswd.action",
	                type:"POST",
	                dataType : "json",
	                data: {"pw": oldPassword,"pw1" : newPassword},
	                success:function(data){
	                	if(data.yes) {
	                		swal({
		    					title: data.title,
		    					text: data.msg,
		    					type: data.status
		    				}).then(function(){
		    					window.location.href='/HIS/toIndex.action';
		    				})
	                	} else {
	                		swal({
		    					title: data.title,
		    					text: data.msg,
		    					type: data.status
		    				})
	                	}
	              	}
	            });
	        }
		});
		var ta = document.getElementById('main');
		ta.style.height = $(window).height()-72+"px";
	</script>
</body>
</html>

