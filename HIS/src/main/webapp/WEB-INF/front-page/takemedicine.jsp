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
	<title>取药</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/takemedicine.css">
</head>
<body>
	<c:import url="/toHead.action">
		<c:param name="name" value="drug"></c:param>
	</c:import>
	<div class="main" id="main">
		<div class="main_bar">
			<p class="main_bar_title">取药登记表</p>
			<div class="main_header">
				<input type="text" value="${medical_record.code }" readonly>
				<input type="text" value="${patient.name }" readonly>
				<input type="text" value="<c:if test="${patient.sex eq 'MAN' }">男</c:if><c:if test="${patient.sex eq 'WOMAN' }">女</c:if>" readonly>
				<input type="text" value="${status }" readonly class="status">
				<a href="/HIS/takeDrug.action?medical_record=${medical_record.code }">取药</a>
				
			</div>
			<div class="th">
				<table>
					<tr>
						<td class="td_1">药品编号</td>
						<td class="td_2">药品名字</td>
						<td class="td_3">数量</td>
						<td class="td_4">单位</td>
						<td class="td_5">规格</td>
						<td class="td_6">生产日期</td>
						<td class="td_7">有效日期</td>
						<td class="td_8">备注</td>
					</tr>
				</table>
			</div>
			<div class="tf">
				<table>
					<c:forEach items="${druglist }" var="druglist">
						<tr><!-- 循环 -->
							<td class="td_1">${druglist.drug.code }</td>
							<td class="td_2">${druglist.drug.name }</td>
							<td class="td_3">${druglist.number }</td>
							<td class="td_4">${druglist.drug.unit }</td>
							<td class="td_5">${druglist.drug.spec }/${druglist.drug.unit }</td>
							<td class="td_6">${druglist.drug.produce_date }</td>
							<td class="td_7">${druglist.drug.effective_date }</td>
							<td class="td_8">一日服用2次</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery.nicescroll.js"></script>
	<script>
		var main = document.getElementById('main');
		main.style.height = $(window).height()-72+"px";
		$('.tf').niceScroll({cursorcolor: "rgb(204, 204, 204)", mousescrollspeed: "20"});
	</script>
</body>
</html>