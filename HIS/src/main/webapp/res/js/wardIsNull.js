// JavaScript Document
var err='';

/*获取id*/
function getID(id){
    obj=document.getElementById(id);
    if (obj==null) obj=document.all.id;
    return obj;
}

/*修改病房编号以及病房类型*/
function updateWard(){
	var ward_code = getID(ward_code).value;	
	if(ward_code.length < 1){
		err += '请完整填写信息！';
		return false;	
	}else{
		return true;
	}
}

/*修改病床信息*/
function updateBed(){
	var bed_code = getID(bed_code).value;
	var price = getID(price).value;
	var isOccupy = getID(isOccupy).value;
	if(bed_code.length < 1 || price.length <1 || isOccupy.length < 1){
		err += '请完整填写信息！';
		return false;	
	}else{
		return true;
	}
}

/*添加病房信息*/
function insertWard(){
	var ward_code = getID(ward_code1).value;	
	var price = getID(price1).value;
	if(ward_code.length < 1 || price.length <1){
		err += '请完整填写信息！';
		return false;	
	}else{
		return true;
	}
}