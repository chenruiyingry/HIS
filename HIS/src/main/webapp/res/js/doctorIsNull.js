// JavaScript Document
var err='';

/*获取id*/
function getID(id){
    obj=document.getElementById(id);
    if (obj==null) obj=document.all.id;
    return obj;
}

/*判断表单容内是否为空*/
function isNull(){
	var name = getID('name').value;
	var nation = getID('nation').value;	
	var native_place = getID('native_place').value;
	var birth = getID('birth').value;
	var code = getID('code').value;
	var degree = getID('degree').value;
	var graduate = getID('graduate').value;
	var address = getID('address').value;
	var qualificationv = getID('qualification').value;
	var license = getID('license').value;
	var title = getID('title').value;
	var hiredate = getID('hiredate').value;
	var major = getID('major').value;
	var work_time = getID('work_time').value;
	var outwork_time = getID('outwork_time').value;
	if(name.length<1 || nation.length<1 || native_place.length<1 || birth.length<1 || code.length<1 || degree.length<1 || 
	graduate.length<1 || address.length<1 || qualificationv.length<1 || license.length<1 || title.length<1 || 
	hiredate.length<1 || major.length<1 || work_time.length<1 || outwork_time.length<1 ){
		err+='请完整填写表单！\n';
		return false;
	}else{
		return true;
	}
}

/*判断电子邮箱格式*/
function chEmail(){
	var email = getID("email").value;
	var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
	if(!reg.test(email)){
		err+='邮箱格式错误，请重新填写！\n';
		return false;
	}else{
		return true;
	}
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

function check(){
	if(isNull() && chEmail() && chPhone()){
		return true;
	}else{
		err='';
		isNull();
		chEmail();
		chPhone();
		alert(err);
		return false;
	}
}