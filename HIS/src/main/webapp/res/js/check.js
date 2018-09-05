/*下面是表示输入项是否有效的标志变量，初始值为false*/
var pw_valid = false;
var pw1_valid = false;

/*  通用函数--获取指定id的object*/
function getID(id){
    obj=document.getElementById(id);
    if (obj==null) obj=document.all.id;
    return obj;
}

/*通用函数----返回字符串的长度，双字节字符计为2个字符*/
/*String.prototype.chkLength=function(){
    var len = this.replace(/[^\x00-\xff]/g, "**").length;
    return len;
}*/
function chkLength() {
	var len = this.replace(/[^\x00-\xff]/g, "**").length;
    return len;
}


/*检验两次输入密码是否一致*/
function chkPasswd(){
	pw1_valid = false;
	var pw1 = getID('pw1').value;
	var pw2 = getID('pw2').value;
	if(pw1==null || pw1==""){
		getID("msg1").innerHTML ='新密码不能为空';
	}else if(pw2==null || pw2==""){
		getID("msg2").innerHTML ='再次输入密码不能为空';
	}else{
		if(pw1.length<6 && pw2.length<6){
			getID("msg1").innerHTML='密码长度应大于等于6';
			getID("msg2").innerHTML='密码长度应大于等于6';
		}else if(pw1 != pw2){
			getID("msg1").innerHTML ='两次密码不一致';
			getID("msg2").innerHTML ='两次密码不一致';
		}else{
				pw1_valid = true;
		}
	}
	return pw1_valid;
	
}
/*验证原密码长度*/
function chkPasswdnull(){
	pw_valid = false;
	var pw = getID('pw').value;
	if(pw==null || pw==''){
		getID("msg").innerHTML='原密码不能为空';
	} else{
		pw_valid = true;
	}
	return pw_valid;
}
function chkAll(){

	if(chkPasswdnull() && chkPasswd()){
		return true;
	}else{
		chkPasswd();
		chkPasswdnull();
		return false;
	}
}
