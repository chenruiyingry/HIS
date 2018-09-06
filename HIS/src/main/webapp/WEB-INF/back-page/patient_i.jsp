<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>病人信息</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/patient_i.css">
</head>
<body>
	<c:import url="/admin/toHead.do">
		<c:param name="headname" value="patient"></c:param>
	</c:import>
	<form action="/HIS/admin/editPatient.do" id="myform" class="myform">
	<input type="hidden" name="id" value="${patient.id }">
	<div class="main" id="main">
		<div class="main_bar">
			<button type="button" onclick="modify()">修改</button>
			<a href="/HIS/admin/doctorList.do" class="arrow-left_a faz" title="返回病人列表"><i class="fa fa-arrow-left fa-2x faz" aria-hidden="true"></i></a>
			<a href="javascript:void(0)" onclick="javascript:document.getElementById('submit').click()" class="arrow-left_b faz" title="确定"><i class="fa fa-check fa-2x faz" aria-hidden="true"></i></a>
			<a href="javascript:void(0)" onclick="javascript:document.getElementById('reset').click()" class="arrow-left_c faz" title="重置"><i class="fa fa-times fa-2x faz" aria-hidden="true"></i></a>
			<input type="submit" value="" class="submit faz" id="submit">
			<input type="reset" value="" class="reset faz" id="reset">
			<table>
				<tr>
					<td class="td_4">姓名</td>
					<td><input type="text" class="td_3" name="name" value="${patient.name }"></td>
					<td class="td_4">性别</td>
					<td>
						<input type="text" class="td_3 td_3_gdd" value="<c:if test="${patient.sex eq 'MAN' }">男</c:if><c:if test="${patient.sex eq 'WOMAN' }">女</c:if>">
						<input type="radio" name="sex" value="MAN" class="gender duty" <c:if test="${patient.sex eq 'MAN' }">checked="checked"</c:if>><span class="male mf">男</span>
						<input type="radio" name="sex" value="WOMAN" class="gender duty" <c:if test="${patient.sex eq 'WOMAN' }">checked="checked"</c:if>><span class="famale mf">女</span>
					</td>
					<td class="td_4">年龄</td>
					<td><input type="text" class="td_3" name="age" value="${patient.age }"></td>
				</tr>
				<tr>
					<td class="td_4">联系电话</td>
					<td><input type="text" class="td_3" name="phone" value="${patient.phone }"></td>
					<td class="td_4">医保类型</td>
					<td id="insurance_type">
						<input type="text" class="td_1 td_3 td_3_gdd" value="${patient.insurance_type }">
						<select name="insurance_type" class="td_3 td_3_insurance_type">
							<option value="城镇职工基本医疗保险" <c:if test="${patient.insurance_type eq '城镇职工基本医疗保险' }">selected="selected"</c:if>>城镇职工基本医疗保险</option>
							<option value="新型农村合作医疗" <c:if test="${patient.insurance_type eq '新型农村合作医疗' }">selected="selected"</c:if>>新型农村合作医疗</option>
							<option value="城镇居民基本医疗保险" <c:if test="${patient.insurance_type eq '城镇居民基本医疗保险' }">selected="selected"</c:if>>城镇居民基本医疗保险</option>
						</select>
					</td>
					<td class="td_4">病人状态</td>
					<td><input type="text" class="td_3" name="status" value="<c:if test="${patient.status == 1 }">在医</c:if><c:if test="${patient.status == 2 }">住院</c:if><c:if test="${patient.status == 3 }">出院</c:if>"></td>
					
				</tr>
				<tr>
					<td class="td_4">既病史</td>
					<td><input type="text" class="td_3" name="past_illness" value="${patient.past_illness }"></td>
					<td class="td_4">现病史</td>
					<td><input type="text" class="td_3" name="present_illness" value="${patient.present_illness }"></td>
					<td class="td_4">过敏史</td>
					<td><input type="text" class="td_3" name="allergy" value="${patient.allergy }"></td>
				</tr>
			</table>
			<div class="introduction">
					<table>
						<tr class="tr_1">
							<td>病历编号</td>
							<td>科室</td>
							<td>医生姓名</td>
							<td>化验结果</td>
							<td>检查结果</td>
							<td>治疗方法</td>
							<td>是否住院</td>
							<td>时间</td>
						</tr>
						<tr>
							<td>12334</td>
							<td>生化</td>
							<td>张三</td>
							<td>无</td>
							<td>无</td>
							<td>吃药</td>
							<td>否</td>
							<td>2018-08-28</td>
						</tr>
					</table>
					<!-- <tr>
							<td>12334</td>
							<td>生化</td>
							<td>张三</td>
							<td>无</td>
							<td>无</td>
							<td>吃药</td>
							<td>否</td>
							<td>2018-08-28</td>
						</tr> -->
					<c:forEach items="${pagination.list }" var="patient">
							
					</c:forEach>
					<%-- <c:if test="${empty pagination.list }">
						<p class="selectnone">查无相关信息，请重新尝试！！</p>
					</c:if> --%>
					
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery.form.js"></script>
	<script type="text/javascript" src="/HIS/res/js/patient_i.js"></script>
</body>
</html>