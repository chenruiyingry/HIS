function $(id) {
	return document.getElementById(id);
}
function $A(ca) {
	return document.getElementsByTagName(ca);
}
function mov() {
	$('submit').style.cssText = "background-color: rgb(208, 71, 61);";
}
function mou() {
	$('submit').style.cssText = "background-color: rgb(230, 89, 78);";
}
(function (){
	var y = null;
	function time(){
	 dt = new Date();
	 var y=dt.getFullYear();
	 var m=dt.getMonth()+1;
	 var d=dt.getDate();
	 var h=dt.getHours();
	 var mm=dt.getMinutes();
	 var s=dt.getSeconds();
	 if(m < 10 && d < 10) {
	 	$("timeShow").innerHTML="0"+m+" - "+"0"+d+" - "+y;
	 }
	 else if(m < 10 && d >= 10) {
	 	$("timeShow").innerHTML="0"+m+" - "+d+" - "+y;
	 }
	 else if(m >= 10 && d < 10) {
	 	$("timeShow").innerHTML=m+" - "+"0"+d+" - "+y;
	 }
	 else {
	 	$("timeShow").innerHTML=m+" - "+d+" - "+y;
	 }
	 if(h < 10 && mm < 10 && s < 10) {
	 	$("timeShow_1").innerHTML="0"+h+" : "+"0"+mm+" : "+"0"+s;
	 }
	 else if(h < 10 && mm < 10 && s >= 10) {
	 	$("timeShow_1").innerHTML="0"+h+" : "+"0"+mm+" : "+s;
	 }
	 else if(h < 10 && mm >= 10 && s < 10) {
	 	$("timeShow_1").innerHTML="0"+h+" : "+mm+" : "+"0"+s;
	 }
	 else if(h >= 10 && mm < 10 && s < 10) {
	 	$("timeShow_1").innerHTML=h+" : "+"0"+mm+" : "+"0"+s;
	 }
	 else if(h < 10 && mm >= 10 && s >= 10) {
	 	$("timeShow_1").innerHTML="0"+h+" : "+mm+" : "+s;
	 }
	 else if(h >= 10 && mm < 10 && s >= 10) {
	 	$("timeShow_1").innerHTML=h+" : "+"0"+mm+" : "+s;
	 }
	 else if(h >= 10 && mm >= 10 && s < 10) {
	 	$("timeShow_1").innerHTML=h+" : "+mm+" : "+"0"+s;
	 }
	 else {
	 	$("timeShow_1").innerHTML=h+" : "+mm+" : "+s;
	 }
	 $("timeShow_1").style.cssText = "right: 200px;";
	 y = setTimeout(time,1000);    
	} 
	window.onload=function(){time()}
})();
function check() {
	var username = $("username").value;
	var userpwd = $("userpwd").value;
	if (username.length < 1 || userpwd.length < 1) {
		$("loginbar").style.cssText = "background: rgba(230, 89, 78, 0.65);";
		$("si").style.cssText = "color: rgb(255, 255, 255);";
		$("submit").style.cssText = "background-color: rgba(208, 208, 208, 0.80); box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px;";
		$("submit").disabled = true;
	}
	if (username.length < 1 && userpwd.length < 1) {
		$("username").placeholder = "用户名不能为空";
		$("userpwd").placeholder = "密码不能为空";
		return false;
	}
	else if (username.length < 1 && userpwd.length >= 1) {
		$("username").placeholder = "用户名不能为空";
		return false;
	}
	else if (username.length >= 1 && userpwd.length < 1) {
		$("userpwd").placeholder = "密码不能为空";
		return false;
	}
	else
		$("loginform").action = "../admin/login.do";
		return true;
}
function check1() {
	var username = $("username").value;
	var userpwd = $("userpwd").value;
	if (username.length < 1 || userpwd.length < 1) {
		$("loginbar").style.cssText = "background: rgba(230, 89, 78, 0.65);";
		$("si").style.cssText = "color: rgb(255, 255, 255);";
		$("submit").style.cssText = "background-color: rgba(208, 208, 208, 0.80); box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px;";
		$("submit").disabled = true;
	}
	if (username.length < 1 && userpwd.length < 1) {
		$("username").placeholder = "用户名不能为空";
		$("userpwd").placeholder = "密码不能为空";
		return false;
	}
	else if (username.length < 1 && userpwd.length >= 1) {
		$("username").placeholder = "用户名不能为空";
		return false;
	}
	else if (username.length >= 1 && userpwd.length < 1) {
		$("userpwd").placeholder = "密码不能为空";
		return false;
	}
	else
		$("loginform").action = "../login.action";
		return true;
}