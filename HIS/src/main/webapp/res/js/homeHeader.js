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
	document.getElementById('bar').style.cssText = "z-index: 3; right: 130px;";
	document.getElementById('bar_a').innerHTML = "&nbsp>";
	document.getElementById('bar_a').style.cssText = "width: 370px;";
}
function mou() {
	document.getElementById('bar').style.cssText = "z-index: -1; right: -185px;";
	document.getElementById('bar_a').innerHTML = "<";
	document.getElementById('bar_a').style.cssText = "width: 16.33px;";
}
$(document).ready(function (){
	$('.bar').mouseover(function (){
		$('.bar').css({"right": "130px", "z-index": "3",});
		$('.bar_a').html("&nbsp>");
		$('.bar_a').css({"width": "370px", "color": "#E25D5D",});
	});
	$('.bar_1').mouseover(function (){
		$('.bar_1').css({"right": "130px", "z-index": "3",});
		$('.bar_a').html("&nbsp>");
		$('.bar_a').css({"width": "370px", "color": "#E25D5D",});
	});
	$('.bar_c_a').mouseover(function (){
		$('.auther_head').css({"width":"29px", "height": "29px", "top":"20px", "right":"95px",});
		$('.username_1').css({"left":"-88px", "z-index":"3",});
		$('.update').css({"z-index": "4",});
	});
	$('.update').mouseover(function (){
		$('.auther_head').css({"width":"29px", "height": "29px", "top":"20px", "right":"95px",});
		$('.username_1').css({"left":"-88px", "z-index":"3",});
	});
	$('.update').mouseout(function (){
		$('.auther_head').css({"width":"40px", "height": "40px", "top":"10px", "right":"55px",});
		$('.username_1').css({"left":"-150px", "z-index":"-1",});
		$('.update').css({"z-index": "0",});
	});
});
