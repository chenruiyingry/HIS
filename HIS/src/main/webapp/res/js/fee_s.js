var main = document.getElementById('main');
main.style.height = $(window).height()-72+"px";
$(document).ready(function (){
	$('.alipay_r').click(function (){
		$('.paynumber').slideDown('.2s');
		$('.cashpay').css({"top":"64%",});
	});
	$('.pay_r').click(function (){
		$('.paynumber').slideUp('.2s');
		$('.cashpay').css({"top":"58%",});
	});
	$('.pay').mouseover(function (){
		$('.pay').css({"background-color":"#ce3232",});
	});
	$('.pay').mouseout(function (){
		$('.pay').css({"background-color":"rgb(223, 66, 66)",});
	});
	$('.pay').click(function (){
		$('.paybox').css({"top":"0%",});
	});
	$('.pay_back').click(function (){
		$('.paybox').css({"top":"100%", "transition":".3s",});
	});
	$('.pay_submit').mouseover(function (){
		$('.pay_submit').css({"background-color":"#319b79",});
	});
	$('.pay_submit').mouseout(function (){
		$('.pay_submit').css({"background-color":"#56c6a2",});
	});
});