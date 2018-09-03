(function (){
	function $(id) {
		return document.getElementById(id);
	}
	var y = null;
	function time(){
	 dt = new Date();
	 var y=dt.getFullYear();
	 var m=dt.getMonth()+1;
	 var d=dt.getDate();
	 var h=dt.getHours();
	 var mm=dt.getMinutes();
	 var s=dt.getSeconds();
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
	 y = setTimeout(time,1000);    
	} 
	window.onload=function(){time()}
})();
function mov() {
	document.getElementById('bar').style.cssText = "z-index: 1; right: 130px;";
	document.getElementById('bar_a').innerHTML = "&nbsp>";
	document.getElementById('bar_a').style.cssText = "width: 370px;";
}
function mou() {
	document.getElementById('bar').style.cssText = "z-index: -1; right: -100px;";
	document.getElementById('bar_a').innerHTML = "<";
	document.getElementById('bar_a').style.cssText = "width: 16.33px;";
}
