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
	<title>收费</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/fee_s.css">
	<!-- <link rel="stylesheet" href="/HIS/res/css/homeHeader.css"> -->
</head>
<body>
	<c:import url="/toHead.action?name=fee"></c:import>
	<form action="pay.action" method="post">
	<div class="main" id="main">
		<div class="main_bar">
			<div class="main_header main_b">
				<table>
					<tr>
						<td class="main_header_td1 main_header_attribute">卡号</td>
						<td class="main_header_td2 main_header_box">${patient.code }</td>
						<td class="main_header_td3 main_header_attribute">流水号</td>
						<td class="main_header_td4 main_header_box">${tradeNo }</td>
						<td class="main_header_td5 main_header_attribute">姓名</td>
						<td class="main_header_td6 main_header_box">${patient.name }</td>
						<td class="main_header_td7 main_header_attribute">性别</td>
						<td class="main_header_td8 main_header_box">${patient.sex.name }</td>
						<td class="main_header_td9 main_header_attribute">年龄</td>
						<td class="main_header_td10 main_header_box">${patient.age }</td>
						<td class="main_header_td11 main_header_attribute">科室</td>
						<td class="main_header_td12 main_header_box">${department.name }</td>
						<td class="main_header_td13 main_header_attribute">医生</td>
						<td class="main_header_td14 main_header_box">${doctor.name }</td>
						<input type="hidden" name="medicalcode" value="${medical_record.code }">
						<input type="hidden" name="bedcode" value="${medical_record.bed_number }">
						<input type="hidden" name="hospitalday" value="${medical_record.hospitalization_days }">
						<input type="hidden" name="tradeNo" value="${tradeNo }">
						<input type="hidden" name="patientcode" value="${patient.code }">
						<input type="hidden" name="patientname" value="${patient.name }">
						<input type="hidden" name="doctorlevel" value="${doctor.level }">
					</tr>
				</table>
			</div>
			<div class="main_content main_b">
				<table>
					<tr>
						<td class="main_content_td1 main_content_attribute" colspan="3">费用项目</td>
						<td class="main_content_td2 main_content_attribute" colspan="7">金额</td>
					</tr>
					<tr>
						<td class="main_content_td3 main_content_attribute">药品名称</td>
						<td class="main_content_td4 main_content_attribute">药品规格</td>
						<td class="main_content_td5 main_content_attribute">单价</td>
						<td class="main_content_td6 main_content_attribute">数量</td>
						<td class="main_content_td7 main_content_attribute">单位</td>
						<td class="main_content_td8 main_content_attribute">金额</td>
						<td class="main_content_td9 main_content_attribute">报销金额</td>
						<td class="main_content_td10 main_content_attribute">应付金额</td>
						<td class="main_content_td11 main_content_attribute">优惠比例</td>
						<td class="main_content_td12 main_content_attribute">发票类型</td>
					</tr>
					<!-- 医药费 -->
					<c:forEach var="drug" items="${druglist }">
						<tr><!-- 循环 -->
						<input type="checkbox" name="codes" checked="checked" style="display: none;" value="${drug.code }">
						<td>${drug.drug.name }</td>
						<td>${drug.drug.spec }/${drug.drug.unit }</td>
						<td>${drug.drug.sale_price }</td>
						<td>${drug.number }</td>
						<td>${drug.drug.unit }</td>
						<td>${drug.totalmoney }</td>
						<td>0.00</td>
						<td>${drug.totalmoney }</td>
						<td>100.00%</td>
						<td>医药费</td>
					</tr>
					</c:forEach>
					<!-- 其他费用 -->
					<c:forEach var="other" items="${others }">
						<tr><!-- 循环 -->
						<td>${other.key }</td>
						<td></td>
						<td>${other.value }</td>
						<td>1</td>
						<td>次</td>
						<td>${other.value }</td>
						<td>0.00</td>
						<td>${other.value }</td>
						<td>100.00%</td>
						<td>${other.key }</td>
						<input type="checkbox" name="others" value="${other.key }" checked="checked" style="display: none;">
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class="main_footer main_b">
				<table>
					<tr>
						<td class="main_footer_td1 main_footer_attribute">项目编号</td>
						<td class="main_footer_td2 main_footer_box"></td>
						<td class="main_footer_td3 main_footer_attribute">数量</td>
						<td class="main_footer_td4 main_footer_box">${totalnum }</td>
						<td class="main_footer_td5 main_footer_attribute">执行科室</td>
						<td class="main_footer_td6 main_footer_box">${department.name }</td>
						<td class="main_footer_td7 main_footer_attribute">规格</td>
						<td class="main_footer_td8 main_footer_box"></td>
					</tr>
					<input type="hidden" name="department" value="${department.name }">
					<input type="hidden" name="totalnum" value="${totalnum }">
					<tr>
						<td class="main_footer_td11 main_footer_attribute">发票号</td>
						<td class="main_footer_td12 main_footer_box">NO 02995606</td>
						<td class="main_footer_td13 main_footer_attribute">记账</td>
						<td class="main_footer_td14 main_footer_box">0.00</td>
						<td class="main_footer_td15 main_footer_attribute">总金额</td>
						<td class="main_footer_td16 main_footer_box">${totalfee }</td>
						<td class="main_footer_td17 main_footer_attribute">单位</td>
						<td class="main_footer_td18 main_footer_box">元</td>
						
					</tr>
				</table>
				<button type="button" class="pay" id="pay">收款</button>
			</div>
			<div class="paybox" id="paybox">
				<div class="paybox_main">
					<div class="paybox_main_bar">
						<p>请选择支付方式</p>
					</div>
					
					<p class="sum">￥${totalfee }</p>
					<div class="wxpay payway">
						<input type="hidden" value="1000100" name="doctorcode">
						<input type="hidden" value="${totalfee }" name="totalfee">
						<img src="/HIS/res/img/wxpay.png" alt="img">
						<input type="radio" name="pay" value="wxpay" class="pay_r">
					</div>
					<div class="alipay payway">
						<img src="/HIS/res/img/alipay.png" alt="img">
						<input type="radio" name="pay" value="alipay" class="alipay_r">
					</div>
					<div class="unionpay payway">
						<img src="/HIS/res/img/unionpay.png" alt="img">
						<input type="radio" name="pay" value="unionpay" class="pay_r">
					</div>
					<div class="cashpay payway">
						<img src="/HIS/res/img/cashpay.png" alt="img">
						<input type="radio" name="pay" value="cashpay" class="pay_r" checked>
					</div>
					<div class="paynumber">
						<input type="text" placeholder="付款码" name="authcode">
					</div>
					<input type="submit" class="pay_submit" value="确定支付">
				</div>
				<button type="button" class="pay_back" id="pay_back"><i class="fa fa-reply" aria-hidden="true"></i></button>
			</div>
		</div>
	</div>
	</form>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/fee_s.js"></script>
</body>
</html>