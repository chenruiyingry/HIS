var main = document.getElementById('main');
main.style.height = $(window).height()-72+"px";
$(document).ready(function (){
	$('.main_content_2').niceScroll({cursorcolor: "rgb(204, 204, 204)", mousescrollspeed: "20"});
	$('.td_3').attr({"readonly": "readonly",});
	$('button').click(function (){
		$('.td_3').removeAttr('readonly');
		$('.td_3').css({"border": "1px solid rgb(120, 120, 120)", "border-radius": "3px",});
		$('.td_3_gdd').css({"display": "none",});
		$('.addlink').css({"z-index": "2",});
		$('.gender').css({"display": "inline",});
		$('.td_3_insurance_type').css({"display": "block",});
		$('.mf').css({"display": "inline",});
		$('.faz').css({"z-index": "1",});
		$('.fa-check').css({"left": "19%",});
		$('.fa-times').css({"left": "29%",});
		$('button').css({"width": "22%", "background-color": "#d2565600",});
	});
});