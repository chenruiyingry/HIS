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
	<title>就诊</title>
	<link rel="shortcut icon" href="/HIS/res/img/favicon.ico">
	<link rel="stylesheet" href="/HIS/res/css/font-awesome.min.css">
	<link rel="stylesheet" href="/HIS/res/css/visit.css">
</head>
<body>
	<c:import url="/toHead.action">
		<c:param name="name" value="visit"></c:param>
	</c:import>
	<form action="/HIS/treatment.action" onSubmit="return isNull()">
	<input type="hidden" name="code" value="${medical_record.code }">
	<input type="hidden" name="patient_code" value="${medical_record.patient_code }">
	<input type="hidden" name="doctor_code" value="${doctorsession.code }">
	<input type="hidden" name="department_code" value="${doctorsession.department_code }">
	<div class="main" id="main">
		<div class="main_bar">
			<p class="main_bar_title">诊疗表</p>
			<input type="button" value="开药" class="pre">
			<div class="main_table">
				<table>
					<tr>
						<td class="td_1">病人编号</td>
						<td>${medical_record.patient_code }</td>
						<td class="td_1">医生编号</td>
						<td>${doctorsession.code }</td>
					</tr>
					<tr>
						<td>是否化验</td>
						<td>
							<input type="radio" name="assay" value="true">是
							<input type="radio" name="assay" value="false" checked="checked">否
						</td>
						<td>是否检查</td>
						<td>
							<input type="radio" name="examination" value="true">是
							<input type="radio" name="examination" value="false" checked="checked">否
						</td>
						<td class="td_1">是否住院</td>
						<td>
							<input type="radio" name="hospitalization" id="hospitalization" class="td_it" value="true">是
							<input type="radio" name="hospitalization" id="hospitalization" class="td_if" value="false" checked="checked">否
						</td>
					</tr>
					<tr>
						<td>化验结果</td>
						<td colspan="5" class="td_5"><input type="text" name="assay_result"></td>
					</tr>
					<tr>
						<td>检查结果</td>
						<td colspan="5" class="td_5"><input type="text" name="examination_result"></td>
					</tr>
					<tr>
						<td>诊断结果</td>
						<td colspan="5" class="td_5"><input type="text" id="diagnostic_result" name="diagnostic_result"></td>
					</tr>
					<tr>
						<td>现状处理</td>
						<td colspan="5" class="td_5"><input type="text" id="treatment" name="treatment"></td>
					</tr>
					<tr class="tr_1">
						<td>病房号</td>
						<td class="td_2">
							<select name="ward_number" id="ward_number" onchange="beds(this.value)">
								<option value="" selected>病房号</option>
								<c:forEach items="${wards }" var="ward">
									<option value="${ward.ward_code }">${ward.ward_code }/${ward.type }</option>
								</c:forEach>
							</select>
						</td>
						<td>病床号</td>
						<td class="td_2">
							<select name="bed_number" id="bed">
								
							</select>
						</td>
						<td>住院天数</td>
						<td><input type="text" name="hospitalization_days" value="0"></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="prescriptions">
			<p class="main_bar_title">开药单</p>
			<div class="prescriptions_header">
				<table>
					<tr>
						<td style="width: 40%; padding: 0px 4% 1%;">药品名称</td>
						<td style="width: 20%">数量</td>
						<td style="width: 20%">单位</td>
						<td style="width: 20%">规格</td>
					</tr>
				</table>
			</div>
			<div class="prescriptions_main">
				<table class="table_1" id="table">
					<tbody id="tbody">
					<tr id="tr_1">
						<td style="width: 40%; padding: 1% 0% 1% 4%;">
							<i class="fa fa-times" aria-hidden="true" id="tr_1_fa" onclick="remove(1)"></i>
							<select name="druglist" id=""  style="width: 80%" class="si" onchange="drugInfo(this.value, 1)">
								<option value="">---请选择药名---</option>
								<c:forEach items="${drugs }" var="drug">
									<option value="${drug.code }">${drug.name }</option>
								</c:forEach>
							</select>
						</td>
						<td style="width: 20%">
							<input type="text" style="width: 70%" id="num" class="si" name="num">
						</td>
						<td style="width: 20%" class="unit_1">盒</td>
						<td style="width: 20%" class="spec_1">10颗/盒</td>
					</tr>
					</tbody>
				</table>
				<div id="plus"><i class="fa fa-plus" aria-hidden="true" onclick="add(1)"></i></div>
			</div>
			<div class="prescriptions_foot">
				<input type="submit" class="save" value="确定">
			</div>
		</div>
	</div>
	</form>
    <script type="text/javascript" src="/HIS/res/js/visitIsNull.js"></script>
	<script type="text/javascript" src="/HIS/res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/HIS/res/js/visit.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			if (${!empty msg }) {
				alert('${msg }');
			}
		});
	</script>
	<script type="text/javascript">
	function drugInfo(code, num){
		$.ajax({
			type: 'POST',
			url: '/HIS/drugInfo.action',
			data: {
				code: code
			},
			dataType: "json",
			success: function(data) {
				$(".unit_" + num).html(data.unit);
				$(".spec_" + num).html(data.spec + "/" + data.unit);
			}
		});
	}
	function beds(ward_code){
		$.ajax({
			type: 'POST',
			url: '/HIS/beds.action',
			data: {
				ward_code: ward_code
			},
			dataType: "json",
			success: function(data) {
				var beds = data.beds;
				var html = '<option value="" selected>病床号</option>';
				for(var i = 0; i < beds.length; i++) {
					html += '<option value="'+ beds[i].bed_code + '" >' + beds[i].bed_code + '</option>';
				}
				$("#bed").html(html);
			}
		});
	}
	</script>
	<script type="text/javascript">
	function remove(num) {
		$('#tr_' + num).remove();
	}
	function add(num) {
		var html = '';
		html += '	<tr id=tr_' + (num + 1) + '>'
		html += '	<td style="width: 40%; padding: 1% 0% 1% 4%;">'
		html += '		<i class="fa fa-times" aria-hidden="true" id="tr_1_fa" onclick="remove(' + (num+1) +')"></i>'
		html += '		<select name="druglist" id=""  style="width: 80%" class="si" onchange="drugInfo(this.value, ' + (num+1) +')">'
		html += '           <option value="">---请选择药名---</option>'
		html += '			<c:forEach items="${drugs }" var="drug">'
		html += '				<option value="${drug.code }">${drug.name }</option>'
		html += '			</c:forEach>'
		html += '		</select>'
		html += '	</td>'
		html += '	<td style="width: 20%">'
		html += '		<input type="text" style="width: 70%" id="num" class="si" name="num">'
		html += '	</td>'
		html += '	<td style="width: 20%" class="unit_' + (num+1) + '">盒</td>'
		html += '	<td style="width: 20%" class="spec_' + (num+1) + '">10颗/盒</td>'
		html += '	</tr>'
		$("#tbody").append(html);
		$("#plus").html('<i class="fa fa-plus" aria-hidden="true" onclick="add(' + (num+1) +')"></i>')
	}
	</script>
</body>
</html>