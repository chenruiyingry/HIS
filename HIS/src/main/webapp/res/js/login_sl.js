(function (){
	$("timeShow").style.cssText = "color: rgb(189, 189, 189);";
})();
function ENLanguage() {
	$A("title")[0].innerText = "Sign in";
	$("EZ").innerHTML = "EN";
	$('his').src = '/HIS/res/img/login_logo_2.png';
	$("si").innerHTML = "Sign in";
	$("username").placeholder = "User ID";
	$("userpwd").placeholder = "Password";
	$("submit").value = "Sign In";
	$("en_1").style.cssText = "display: block;";
	$("en_2").style.cssText = "display: block;";
	$("en_3").style.cssText = "display: block;";
	$("en_4").style.cssText = "display: block;";
	$("en_5").style.cssText = "display: block;";
	$("zh_1").style.cssText = "display: none;";
	$("zh_2").style.cssText = "display: none;";
	$("zh_3").style.cssText = "display: none;";
	$("zh_4").style.cssText = "display: none;";
	$("zh_5").style.cssText = "display: none;";
}
function ZHLanguage() {
	$A("title")[0].innerText = "登录";
	$("EZ").innerHTML = "ZH";
	$('his').src = '/HIS/res/img/login_logo_1.png';
	$("si").innerHTML = "登录";
	$("username").placeholder = "用户名";
	$("userpwd").placeholder = "密码";
	$("submit").value = "登录";
	$("en_1").style.cssText = "display: none;";
	$("en_2").style.cssText = "display: none;";
	$("en_3").style.cssText = "display: none;";
	$("en_4").style.cssText = "display: none;";
	$("en_5").style.cssText = "display: none;";
	$("zh_1").style.cssText = "display: block;";
	$("zh_2").style.cssText = "display: block;";
	$("zh_3").style.cssText = "display: block;";
	$("zh_4").style.cssText = "display: block;";
	$("zh_5").style.cssText = "display: block;";
}