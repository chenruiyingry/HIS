<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>收费管理</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/cost.css">
</head>
<body>
	<c:import url="/admin/toHead.do">
		<c:param name="headname" value="cost"></c:param>
	</c:import>
	<div class="main" id="main">
		<div class="main_bar">
			<div class="main_content main_b">
				<table class="table1">
					<tr>
						<td class="main_content_td1 main_content_attribute" colspan="10">收费信息</td>
					</tr>
					<tr>
						<td class="main_content_td3 main_content_attribute">收费编号</td>
						<td class="main_content_td4 main_content_attribute">流水号</td>
						<td class="main_content_td5 main_content_attribute">时间</td>
						<td class="main_content_td6 main_content_attribute">支付方式</td>
						<td class="main_content_td6 main_content_attribute">总收费</td>
						<td class="main_content_td7 main_content_attribute">药费</td>
						<td class="main_content_td8 main_content_attribute">住院费</td>
						<td class="main_content_td9 main_content_attribute">化验费</td>
						<td class="main_content_td10 main_content_attribute">检查费</td>
						<td class="main_content_td11 main_content_attribute">挂号费</td>
					</tr>
				</table>
				<div class="main_content_2">
					<table class="table2">
						<c:forEach var="list" items="${list }">
							<tr><!-- 循环 -->
								<td class="main_content_td3 main_content_attribute_2">${list.code }</td>
								<td class="main_content_td4 main_content_attribute_2">${list.flow_number }</td>
								<td class="main_content_td5 main_content_attribute_2">${list.date }</td>
								<td class="main_content_td6 main_content_attribute_2">
								<c:if test="${list.payment eq 'ALIPAY' }">支付宝</c:if>
								<c:if test="${list.payment eq 'CASH' }">现金</c:if>
								<c:if test="${list.payment eq 'WECHAT' }">微信</c:if>
								<c:if test="${list.payment eq 'CARD' }">银行卡</c:if>
								</td>
								<td class="main_content_td6 main_content_attribute_2">${list.total }</td>
								<td class="main_content_td7 main_content_attribute_2">${list.drug_cost }</td>
								<td class="main_content_td8 main_content_attribute_2">${list.hospitalization_cost }</td>
								<td class="main_content_td9 main_content_attribute_2">${list.assay_cost }</td>
								<td class="main_content_td10 main_content_attribute_2">${list.examination_cost }</td>
								<td class="main_content_td11 main_content_attribute_2">${list.register_cost }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery.nicescroll.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery.form.js"></script>
	<script type="text/javascript" src="/HIS/res/js/patient_i.js"></script>
</body>
</html>