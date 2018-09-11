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
	var num = getID('num').value;
	var hospitalization = getID('hospitalization').value;
	if(diagnostic_result==null || diagnostic_result==""){
		alert('诊断结果不能为空');
		return false;
	}else if(treatment==null || treatment==""){
		alert('现状处理不能为空');
		return false;
	}else if(num==null || num==""){
		alert('药品数量不能为空！');
		return false;
	}else if(hospitalization) {
		var ward_num = getID('ward_num').value;
		var bed_num = getID('bed').value;
		if(ward_num == null || ward_num == "" || bed_num == null || bed_num == "") {
			alert('请选择病房');
			return false;
		}
	}else{
		return true;	
	}
}