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
	<title>挂号系统</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/registered.css">
</head>
<body>
	<c:import url="/toHead.action">
		<c:param name="name" value="register"></c:param>
	</c:import>
	<form action="/HIS/regist.action" onSubmit="return check()">
	<div class="main" id="main">
		<div class="main_bar">
			<p class="main_bar_title">挂号预填表</p>
			<input type="submit" value="提交" class="submit">
			<table>
				<tr>
					<td>姓名：</td>
					<td><input type="text" id="name" style="width: 70%;" name="name" value="${patient.name }"></td>
					<td style="width: 5%;">性别：</td>
					<td style="width: 10%;">
						<select name="sex" id="sex" style="width: 50%;">
							<option value="MAN" <c:if test="${patient.sex eq 'MAN' }">selected="selected"</c:if>>男</option>
							<option value="WOMAN" <c:if test="${patient.sex eq 'WOMAN' }">selected="selected"</c:if>>女</option>
						</select>
					</td>
					<td>年龄：</td>
					<td style="width: 12%;"><input type="text" id="age" style="width: 70%;" name="age" value="${patient.age }"></td>
					<td style="width: 7%;">医保类型：</td>
					<td style="width: 14%;">
						<select name="insurance_type" id="insurance_type" style="width: 70%;">
						<c:if test="${patient.insurance_type eq '城镇职工基本医疗保险' }">selected="selected"</c:if>
							<option value="城镇职工基本医疗保险" <c:if test="${patient.insurance_type eq '城镇职工基本医疗保险' }">selected="selected"</c:if>>城镇职工基本医疗保险</option>
							<option value="新型农村合作医疗" <c:if test="${patient.insurance_type eq '新型农村合作医疗' }">selected="selected"</c:if>>新型农村合作医疗</option>
							<option value="城镇居民基本医疗保险" <c:if test="${patient.insurance_type eq '城镇居民基本医疗保险' }">selected="selected"</c:if>>城镇居民基本医疗保险</option>
						</select>
					</td>
					<td style="width: 7%;">就诊科室：</td>
					<td style="width: 12%;">
						<select name="department_code" id="department" style="width: 100%;">
							<c:forEach items="${departments }" var="department">
								<option value="${department.code }" <c:if test="${department.code eq department_code }">selected="selected"</c:if>>${department.name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>现病史</td>
					<td colspan="9" class="td_9"><input type="text" id="present_illness" name="present_illness" value="${patient.present_illness }"></td>
				</tr>
				<tr>
					<td>既病史</td>
					<td colspan="9" class="td_9"><input type="text" id="past_illness" name="past_illness" value="${patient.past_illness }"></td>
				</tr>
				<tr>
					<td>过敏史</td>
					<td colspan="9" class="td_9"><input type="text" id="allergy" name="allergy" value="${patient.allergy }"></td>
				</tr>
				<tr>
					<td>家庭地址：</td>
					<td colspan="4"><input type="text" id="address" style="width: 90%;" name="address" value="${patient.address }"></td>
					<td>联系电话：</td>
					<td colspan="4"><input type="text" id="phone" style="width: 40%;" name="phone" value="${patient.phone }"></td>
				</tr>
			</table>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/registered.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			if (${!empty msg }) {
				alert('${msg }');
			}
		});
	</script>
	<script>
		var main = document.getElementById('main');
		main.style.height = $(window).height()-72+"px";
	</script>
</body>
</html>