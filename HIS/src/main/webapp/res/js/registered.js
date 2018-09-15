// JavaScript Document
var err='';

/*获取id*/
function getID(id){
    obj=document.getElementById(id);
    if (obj==null) obj=document.all.id;
    return obj;
}

/*判断电话号码的长度*/
function chPhone(){
 	var phone = getID('phone').value;
	if(phone==null || phone==""){
		err+='电话不能为空\n';	
		return false;
	}else if(phone.length == 11){
		return true;	
	}else{
		err+='电话长度应为十一位\n';
		return false;	
	}
}

/*判断其他内容是否为空*/
function isNull(){
	var name = getID('name').value;
	var age = getID('age').value;
	var address = getID('address').value;
	if(name.length<1 || age.length<1 || address.length <1){
		err+='请完整填写表单\n';
		return false;
	}else{
		return true;
	}
}

function check(){

	if(chPhone() && isNull()){
		return true;	
	}else{
		err = "" ;
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