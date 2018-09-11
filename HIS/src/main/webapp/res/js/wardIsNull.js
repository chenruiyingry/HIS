// JavaScript Document
var err='';

/*获取id*/
function getID(id){
    obj=document.getElementById(id);
    if (obj==null) obj=document.all.id;
    return obj;
}

/*添加病房信息*/
function insertWard(){
	var ward_code = getID('ward_code1').value;	
	if(ward_code.length < 1){
		alert("请完整填写信息！");
		return false;	
	}else{
		return true;
	}
}

