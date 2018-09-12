// JavaScript Document

/*  通用函数--获取指定id的object*/
function getID(id){
    obj=document.getElementById(id);
    if (obj==null) obj=document.all.id;
    return obj;
}

function isNull(){
	var diagnostic_result = getID('diagnostic_result').value;
	var treatment = getID('treatment').value;
	var num = document.getElementsByName('num');
	var druglist = document.getElementsByName('druglist');
	var hospitalization_days = getID('hospitalization_days').value;
	var hospitalizations = document.getElementsByName('hospitalization');
	var assays = document.getElementsByName('assay');
	var examinations = document.getElementsByName('examination');
	for(var i = 0; i < 2; i++) {
		if(hospitalizations[i].checked) {
			var hospitalization = hospitalizations[i].value;
		}
		if(assays[i].checked) {
			var assay = assays[i].value;
		}
		if(examinations[i].checked) {
			var examination = examinations[i].value;
		}
	}
	if(diagnostic_result==null || diagnostic_result==""){
		alert('诊断结果不能为空！');
		return false;
	}else if(treatment==null || treatment==""){
		alert('现状处理不能为空！');
		return false;
	}else{
		if(assay == 'true'){
			var assay_result = getID('assay_result').value;
			if(assay_result == null || assay_result == "") {
				alert('化验结果不能为空！');
				return false;
			}
		}
		if(examination == 'true') {
			var examination_result = getID('examination_result').value;
			if(examination_result == null || examination_result == "") {
				alert('检查结果不能为空！');
				return false;
			}
		} 
		if(hospitalization == 'true') {
			var ward_nums = getID('ward_number');
			var ward_numindex = ward_nums.selectedIndex;
			var ward_num = ward_nums.options[ward_numindex].value;
			if(ward_num == null || ward_num == "") {
				alert('病房号不能为空！');
				return false;
			} else {
				var bed_nums = getID('bed');
				var bed_numindex = bed_nums.selectedIndex;
				var bed_num = bed_nums.options[bed_numindex].value;
			}
			if(bed_num == null || bed_num == "") {
				alert('床号不能为空！');
				return false;
			} 
			if(hospitalization_days == 0) {
				alert('请填写住院天数！');
				return false;
			}
		}
		for(var i = 0; i < druglist.length; i++) {
			if(druglist[i].value == "" || druglist[i].value == null) {
				alert('请选择药名！');
				return false;
			} else {
				if(num[i].value == 0) {
					alert('请填写数量！');
					return false;
				}
			}
		}
		return true;	
	}
}