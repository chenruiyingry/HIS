// JavaScript Document
var err='';

/*  通用函数--获取指定id的object*/
function getID(id){
    obj=document.getElementById(id);
    if (obj==null) obj=document.all.id;
    return obj;
}

/*判断电话号码的长度*/
function chPhone(){
 	var phone = getID('phone').value;
	if(phone==null || phone==""){
		err+='电话不能为空！\n';	
		return false;
	}else if(phone.length == 11){
		return true;	
	}else{
		err+='电话长度应为十一位！\n';
		return false;	
	}
}

/*判断姓名是否为空*/
function isNull(){
	var name = getID('name').value;
	var age = getID('age').value;
	if(name==null || name==""){
		err+='姓名不能为空！\n';
		return false;
	}else if(age==null || age==""){
		err+='请填写年龄！\n';
		return false;
	}else{
		return true;	
	}
}

function check(){
	if(chPhone() && isNull()){
		return true;	
	}else{
		err = "";
		chPhone();
		isNull();
		swal({
			title: '操作失败...',
			text: err,
			type: 'error'
		})
		return false;	
	}
}