<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>医生信息</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/doctor_i.css">
</head>
<body>
	<c:import url="/admin/toHead.do">
		<c:param name="headname" value="doctor"></c:param>
	</c:import>
	<form action="/HIS/admin/editDoctor.do" id="myform" enctype="multipart/form-data" class="myform" onsubmit="return check()">
	<input type="hidden" name="id" value="${doctor.id }">
	<div class="main" id="main">
		<div class="main_bar">
			<button type="button" onclick="modify()">修改</button>
			<a href="/HIS/admin/doctorList.do" class="arrow-left_a faz" title="返回医生列表"><i class="fa fa-arrow-left fa-2x faz" aria-hidden="true"></i></a>
			<a href="javascript:void(0)" onclick="javascript:document.getElementById('submit').click()" class="arrow-left_b faz" title="确定"><i class="fa fa-check fa-2x faz" aria-hidden="true"></i></a>
			<a href="javascript:void(0)" onclick="javascript:document.getElementById('reset').click()" class="arrow-left_c faz" title="重置"><i class="fa fa-times fa-2x faz" aria-hidden="true"></i></a>
			<input type="submit" value="" class="submit faz">
			<input type="reset" value="" class="reset faz">
			<div class="photo">
				<c:if test="${!empty doctor.allUrl }">
					<a href="javascript:void(0)" onclick="javascript:document.getElementById('file').click()" class="addlink"></a>
					<img src="${doctor.allUrl }" alt="img" id="allImgUrl">
				</c:if>
				<c:if test="${empty doctor.allUrl }">
					<a href="javascript:void(0)" onclick="javascript:document.getElementById('file').click()" class="addlink"></a>
					<img src="/HIS/res/img/add.png" alt="img" id="allImgUrl">
				</c:if>
				<input type="hidden" name="image_url" id="path" value="${doctor.image_url }"/>
				<input type="file" name="pic" class="img" id="file" onchange="uploadPic()"/>
			</div>
			<table>
				<tr>
					<td class="td_4">姓名</td>
					<td><input type="text" class="td_3" name="name" id="name" value="${doctor.name }"></td>
					<td>性别</td>
					<td>
						<input type="text" class="td_3 td_3_gdd" value="${doctor.sex }">
						<input type="radio" name="sex" value="MAN" class="gender duty" checked="checked" <c:if test="${doctor.sex eq '男' }">checked="checked"</c:if>><span class="male mf">男</span>
						<input type="radio" name="sex" value="WOMAN" class="gender duty" <c:if test="${doctor.sex eq '女' }">checked="checked"</c:if>><span class="famale mf">女</span>
					</td>
				</tr>
				<tr>
					<td>民族</td>
					<td><input type="text" class="td_3" name="nation" id="nation" value="${doctor.nation }"></td>
					<td>籍贯</td>
					<td><input type="text" class="td_3" name="native_place" id="native_place" value="${doctor.native_place }"></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><input type="date" class="td_3 date" name="birth" id="birth" value="${doctor.birth }"></td>
					<td>医生编号</td>
					<td><input type="text" class="td_3" name="code" id="code" value="${doctor.code }"></td>
				</tr>
				<tr>
					<td>最高学位</td>
					<td><input type="text" class="td_3" name="degree" id="degree" value="${doctor.degree }"></td>
					<td>毕业院校</td>
					<td><input type="text" class="td_3" name="graduate" id="graduate" value="${doctor.graduate }"></td>
				</tr>
				<tr>
					<td>联系地址</td>
					<td><input type="text" class="td_3" name="address" id="address" value="${doctor.address }"></td>
					<td>联系电话</td>
					<td><input type="text" class="td_3" name="phone" id="phone" value="${doctor.phone }"></td>
					<td>电子邮箱</td>
					<td><input type="text" class="td_1 td_3" name="email" id="email" value="${doctor.email }"></td>
				</tr>
				<tr>
					<td>资格证书编码</td>
					<td><input type="text" class="td_3" name="qualification" id="qualification" value="${doctor.qualification }"></td>
					<td>执业证书编码</td>
					<td><input type="text" class="td_3" name="license" id="license" value="${doctor.license }"></td>
					<td>科室</td>
					<td id="department">
						<input type="text" class="td_1 td_3 td_3_gdd" value="${doctor.department_code }">
						<select name="department_code" class="td_3 td_3_department">
							<c:forEach items="${departmentlist }" var="department">
								<option value="${department.code }" <c:if test="${doctor.department_code eq department.name }">selected="selected"</c:if>>${department.name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>医师级别</td>
					<td>
						<input type="text" class="td_3 td_3_gdd" value="${doctor.level }">
						<select name="level" class="td_3 td_3_level">
							<option value="CHIEF" <c:if test="${doctor.level eq '主任医师' }">selected="selected"</c:if>>主任医师</option>
							<option value="ASSOCIATECHIEF" <c:if test="${doctor.level eq '副主任医师' }">selected="selected"</c:if>>副主任医师</option>
							<option value="ATTENDING" <c:if test="${doctor.level eq '主治医师' }">selected="selected"</c:if>>主治医师</option>
							<option value="RESIDENT" <c:if test="${doctor.level eq '住院医师' }">selected="selected"</c:if>>住院医师</option>
							<option value="PHYSICIAN" <c:if test="${doctor.level eq '医师' }">selected="selected"</c:if>>医师</option>
							<option value="FELDSHER" <c:if test="${doctor.level eq '医士' }">selected="selected"</c:if>>医士</option>
						</select>
					</td>
					<td>职称</td>
					<td><input type="text" class="td_3" name="title" id="title" value="${doctor.title }"></td>
					<td>职务</td>
					<td><input type="text" class="td_1 td_3" name="duty" id="duty" value="${doctor.duty }"></td>
				</tr>
				<tr>
					<td>入职时间</td>
					<td><input class="td_3 date" type="date" name="hiredate" id="hiredate" value="${doctor.hiredate }"/></td>
					<td>从事专业</td>
					<td><input type="text" class="td_3" name="major" id="major" value="${doctor.major }"></td>
					<td>备注</td>
					<td rowspan="2">
					<textarea class="td_2 td_3" name="remark">${doctor.remark }</textarea></td>
				</tr>
				<tr>
					<td>是否值班</td>
					<td>
						<input type="text" class="td_3 td_3_gdd" value="<c:if test="${doctor.worknow }">是</c:if><c:if test="${!doctor.worknow }">否</c:if>" >
						<input type="radio" name="worknow" class="duty gender" <c:if test="${doctor.worknow }">checked="checked"</c:if>><span class="male mf yn">是</span>
						<input type="radio" name="worknow" class="duty gender" <c:if test="${!doctor.worknow }">checked="checked"</c:if>><span class="famale mf yn">否</span>
					</td>
					<td>工作时间</td>
					<td class="td_3_datetime">
						<input class="td_3 datetime" type="datetime-local" name="work_time" id="work_time" value="${doctor.work_time }"/> - 
						<input class="td_3 datetime" type="datetime-local" name="outwork_time" id="outwork_time" value="${doctor.outwork_time }"/>
					</td>
				</tr>
			</table>
			<div class="introduction">
				<p class="introduction_title">简介</p>
				<p class="introduction_main"><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>求职信的长处是可根据求职对象的需求有针对性的拟订文稿，对于那些欲在外地谋职的毕业生更有一定优势。它的不足是，随着人才市场迅速发展、部门工作效率不断提高，很多招聘单位不愿再通过信件进行交流，直接面试已成为当前机关、企事业单位吸纳人才的主流方式。加之由于它反馈慢，且每应聘一个单位都必须撰写一份求职信，给毕业生带来诸多不便，甚至于耽搁了时间、贻误了时机。 个人简介则不同，毕业生可用相同的个人资料去应聘众多求职单位，同时也节省了发信、等信而消耗的时间。而与个人简介相应的直接应聘可减少不必要环节，有助于招聘者全面、真实地了解和考察毕业生，使工作变得更加快捷、有效。 可以说，个人简介与求职信互有长短，毕业生可根据不同情况、不同时机选择恰当的文种，以更有利于求职。</p>
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/doctorIsNull.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery.form.js"></script>
	<script type="text/javascript" src="/HIS/res/js/doctor_i.js"></script>
	<script>
		function uploadPic(){
			//定义参数
			var options = {
				url : "/HIS/doctor/uploadPic.do",
				dataType : "json",
				type :  "post",
				success : function(data){
					//回调 二个路径  
					//url
					//path
					$("#allImgUrl").attr("src",data.url);
					$("#path").val(data.path);
				}
			};	
			//jquery.form使用方式
			$("#myform").ajaxSubmit(options);
		}
		if (${code eq "yesyes" }) {
			$(document).ready(function (){
				$('button').click();
				$('.addlink').css({"z-index": "2",});
			});
			document.getElementById("myform").action = "/HIS/admin/addDoctor.do";
		}
	</script>
</body>
</html>