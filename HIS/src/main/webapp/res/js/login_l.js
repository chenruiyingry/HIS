function ENLanguage() {
	$A("title")[0].innerText = "Sign in";
	$("EZ").innerHTML = "EN";
	$("his").innerHTML = "Hospital Information System";
	$("bom").innerHTML = "—— Back Office Management";
	$("his").style.cssText = "letter-spacing: initial; right: 0px;";
	$("si").innerHTML = "Sign in";
	$("username").placeholder = "User ID";
	$("userpwd").placeholder = "Password";
	$("submit").value = "Sign In";
}
function ZHLanguage() {
	$A("title")[0].innerText = "登录";
	$("EZ").innerHTML = "ZH";
	$("his").innerHTML = "医院信息管理系统";
	$("bom").innerHTML = "—— 后台管理";
	$("his").style.cssText = "letter-spacing: 20px; right: -20px; position: relative;";
	$("bom").style.cssText = "left: 20px;";
	$("si").innerHTML = "登录";
	$("username").placeholder = "用户名";
	$("userpwd").placeholder = "密码";
	$("submit").value = "登录";
}