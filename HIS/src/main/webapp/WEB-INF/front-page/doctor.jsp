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
	<c:import url="/toHead.action">
		<c:param name="name" value="doctor"></c:param>
	</c:import>
	<form action="/HIS/editDoctor.action" id="myform" class="myform" onsubmit="return check()" method="post">
	<input type="hidden" name="id" value="${doctor.id }">
	<div class="main" id="main">
		<div class="main_bar">
			<button type="button" onclick="modify()">修改</button>
			<a href="/HIS/toIndex.action" class="arrow-left_a faz" title="返回首页"><i class="fa fa-arrow-left fa-2x faz" aria-hidden="true"></i></a>
			<a href="javascript:void(0)" onclick="javascript:document.getElementById('submit').click()" class="arrow-left_b faz" title="确定"><i class="fa fa-check fa-2x faz" aria-hidden="true"></i></a>
			<a href="javascript:void(0)" onclick="javascript:document.getElementById('reset').click()" class="arrow-left_c faz" title="重置"><i class="fa fa-times fa-2x faz" aria-hidden="true"></i></a>
			<input type="submit" value="" class="submit faz" id="submit">
			<input type="reset" value="" class="reset faz" id="reset">
			<div class="photo">
				<img src="${doctor.allUrl }" alt="img" id="allImgUrl">
			</div>
			<table>
				<tr>
					<td class="td_4">姓名</td>
					<td><input type="text" class="td_3_code" name="name" id="name" value="${doctor.name }"></td>
					<td>性别</td>
					<td>
						<input type="text" class="td_3 td_3_code" value="<c:if test="${doctor.sex eq 'WOMAN' }">女</c:if><c:if test="${doctor.sex eq 'MAN' }">男</c:if>">
					</td>
				</tr>
				<tr>
					<td>医生编号</td>
					<td><input type="text" class="td_3_code" name="code" id="code" value="${doctor.code }"></td>
					<td>民族</td>
					<td><input type="text" class="td_3" name="nation" id="nation" value="${doctor.nation }"></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><input type="date" class="td_3 date" name="birth" id="birth" value="${doctor.birth }"></td>
					<td>籍贯</td>
					<td><input type="text" class="td_3" name="native_place" id="native_place" value="${doctor.native_place }"></td>
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
						<input type="text" class="td_3_code td_3_depa" value="${departmentName }">
					</td>
				</tr>
				<tr>
					<td>医师级别</td>
					<td>
						<input type="text" class="td_3_code" value="<c:if test="${doctor.level eq 'CHIEF' }">主任医师</c:if><c:if test="${doctor.level eq 'ASSOCIATECHIEF' }">副主任医师</c:if><c:if test="${doctor.level eq 'ATTENDING' }">主治医师</c:if><c:if test="${doctor.level eq 'RESIDENT' }">住院医师</c:if><c:if test="${doctor.level eq 'PHYSICIAN' }">医师</c:if><c:if test="${doctor.level eq 'FELDSHER' }">医士</c:if>">
					</td>
					<td>职称</td>
					<td><input type="text" class="td_3" name="title" id="title" value="${doctor.title }"></td>
					<td>职务</td>
					<td>
					<input type="text" class="td_3_code td_3_depa" value="<c:if test="${doctor.duty eq 'DOCTOR' }">医生</c:if><c:if test="${doctor.duty eq 'CASHIER' }">收银员</c:if><c:if test="${doctor.duty eq 'REGISTER' }">挂号员</c:if><c:if test="${doctor.duty eq 'PHARMACIST' }">药剂师</c:if>">
					</td>
				</tr>
				<tr>
					<td>入职时间</td>
					<td><input class="date" type="date" name="hiredate" id="hiredate" value="${doctor.hiredate }"/></td>
					<td>从事专业</td>
					<td><input type="text" class="td_3_code" name="major" id="major" value="${doctor.major }"></td>
					<td>备注</td>
					<td rowspan="2">
					<textarea class="td_2 td_3" name="remark">${doctor.remark }</textarea></td>
				</tr>
				<tr>
					<td>工作时间</td>
					<td class="td_3_datetime">
						<input class="datetime" type="datetime-local" name="work_time" id="work_time" value="${doctor.work_time }"/> —
						<input class="datetime" type="datetime-local" name="outwork_time" id="outwork_time" value="${doctor.outwork_time }"/>
					</td>
				</tr>
			</table>
			<div class="introduction">
				<p class="introduction_title">简介</p>
				<p class="introduction_main"><i class="fa fa-quote-left fa-lg pull-left fa-border"></i>求职信的长处是可根据求职对象的需求有针对性的拟订文稿，对于那些欲在外地谋职的毕业生更有一定优势。它的不足是，随着人才市场迅速发展、部门工作效率不断提高，很多招聘单位不愿再通过信件进行交流，直接面试已成为当前机关、企事业单位吸纳人才的主流方式。加之由于它反馈慢，且每应聘一个单位都必须撰写一份求职信，给毕业生带来诸多不便，甚至于耽搁了时间、贻误了时机。 个人简介则不同，毕业生可用相同的个人资料去应聘众多求职单位，同时也节省了发信、等信而消耗的时间。而与个人简介相应的直接应聘可减少不必要环节，有助于招聘者全面、真实地了解和考察毕业生，使工作变得更加快捷、有效。 可以说，个人简介与求职信互有长短，毕业生可根据不同情况、不同时机选择恰当的文种，以更有利于求职。</p>
			</div>
			<div class="patient">
				<div class="main_content">
					<table class="table1">
						<tr>
							<td class="main_content_td1 main_content_attribute" colspan="7">病人信息</td>
						</tr>
						<tr>
							<td class="main_content_td3 main_content_attribute">编号</td>
							<td class="main_content_td4 main_content_attribute">姓名</td>
							<td class="main_content_td5 main_content_attribute">性别</td>
							<td class="main_content_td6 main_content_attribute">年龄</td>
							<td class="main_content_td7 main_content_attribute">现病史</td>
							<td class="main_content_td8 main_content_attribute">既往史</td>
							<td class="main_content_td9 main_content_attribute">过敏史</td>
						</tr>
					</table>
				</div>
				<div class="main_content_2">
					<table class="table2">
						<c:forEach items="${patients }" var="patient">
							<tr><!-- 循环 -->
								<td class="main_content_td3 main_content_attribute_2"><a class="patienturl" href="/HIS/visit.action?code=${patient.code }">${patient.code }</a></td>
								<td class="main_content_td4 main_content_attribute_2">${patient.name }</td>
								<td class="main_content_td5 main_content_attribute_2"><c:if test="${patient.sex eq 'MAN' }">男</c:if><c:if test="${patient.sex eq 'WOMAN' }">女</c:if></td>
								<td class="main_content_td6 main_content_attribute_2">${patient.age }</td>
								<td class="main_content_td7 main_content_attribute_2">${patient.present_illness }</td>
								<td class="main_content_td8 main_content_attribute_2">${patient.past_illness }</td>
								<td class="main_content_td9 main_content_attribute_2">${patient.allergy }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/doctorIsNull.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery.nicescroll.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery.form.js"></script>
	<script type="text/javascript" src="/HIS/res/js/doctor_i.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			if (${!empty msg }) {
				alert('${msg }');
			}
		});
	</script>
</body>
</html>