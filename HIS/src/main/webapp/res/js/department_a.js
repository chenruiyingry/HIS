var main = document.getElementById('main');
var del = document.getElementById('del');
main.style.height = $(window).height()-72+"px";
$(document).ready(function (){
	$('.main').niceScroll({cursorcolor: "rgb(204, 204, 204)", mousescrollspeed: "20"});
	$('.plus').click(function (){
		$('.plus').css({"z-index": "0",});
		$('.fa-plus-square-o').css({"font-size": "0em", "top": "0%", "right": "0%", "width": "0%", "height": "0%", "color": "#0000", "transition": ".3s",});
		$('.return_p').animate({width: '60px', height: '60px',}, ".1s");
		$('.return_p').animate({width: '40px', height: '40px',}, ".2s");
		$('.name_2').animate({width: '60%', padding: '3% 4%',}, ".1s");
		$('.name_2').animate({width: '50%',}, ".2s");
		$('.plusresume').animate({height: '53%', padding: '5px 0px',}, ".1s");
		$('.save').css({"height": "10%", "border-radius": "0%", "width": "90%", "left": "5%", "bottom": "5%",});
	});
	$('.return_p').click(function (){
		$('.plus').css({"z-index": "1",});
		$('.fa-plus-square-o').css({"font-size": "8em", "top": "31%", "right": "0%", "width": "100%", "height": "38%", "color": "rgb(74, 74, 74)", "transition-delay": ".7s",});
		$('.return_p').animate({width: '60px', height: '60px',}, ".1s");
		$('.return_p').animate({width: '0px', height: '0px',}, ".2s");
		$('.name_2').animate({width: '60%',}, ".1s");
		$('.name_2').animate({width: '0%', padding: '3% 0%',}, ".2s");
		$('.plusresume').animate({height: '0%', padding: '0px 0px',}, ".1s");
		$('.save').css({"height": "0%", "border-radius": "50%", "width": "0%", "left": "50%", "bottom": "10%",});
	});
});