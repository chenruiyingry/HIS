function ENLanguage() {
	$A("title")[0].innerText = "Sign in";
	$("EZ").innerHTML = "EN";
	$('his').src = '/HIS/res/img/login_logo_2.png';
	$("bom").innerHTML = "—— Back Office Management";
	$("bom").style.cssText = "font-family: STXinwei; font-size: 18px; left: 18%;";
	$("si").innerHTML = "Sign in";
	$("username").placeholder = "User ID";
	$("userpwd").placeholder = "Password";
	$("submit").value = "Sign In";
}
function ZHLanguage() {
	$A("title")[0].innerText = "登录";
	$("EZ").innerHTML = "ZH";
	$('his').src = '/HIS/res/img/login_logo_1.png';
	$("bom").innerHTML = "—— 后台管理";
	$("bom").style.cssText = "font-family: STXingkai; font-size: 24px; left: 18%;";
	$("si").innerHTML = "登录";
	$("username").placeholder = "用户名";
	$("userpwd").placeholder = "密码";
	$("submit").value = "登录";
}