var main = document.getElementById('main');
main.style.height = $(window).height()-72+"px";
$(document).ready(function (){
	$('.td_it').click(function (){
		$('.tr_1').css({"display": "table-row",});
	});
	$('.td_if').click(function (){
		$('.tr_1').css({"display": "none",});
	});
	$('.pre').click(function (){
		$('.main_bar').css({"-webkit-transform": "rotateY(180deg)", "background-color": "#ccc", "transition": "1s",});
		$('.main_bar').animate({left: '3%',}, ".5s");
		$('.prescriptions').css({"left": "7%", "z-index": "1", "-webkit-transform": "rotateY(360deg)", "box-shadow": "rgb(120, 120, 120) 0px 0px 12px",});
		$('.main_bar').addClass("main_bar_b");
		$('.main_bar_b').attr({"title": "双击返回",});
		$('.main_bar_b').mouseover(function (){
			$('.main_bar_b').css({"background-color": "#fff", "box-shadow": "rgb(255, 117, 117) -2px 0px 1px",});
		});
		$('.main_bar_b').mouseout(function (){
			$('.main_bar_b').css({"background-color": "#ccc", "box-shadow": "rgb(255, 117, 117) 0px 0px 0px",});
		});
		$('.main_bar_b').dblclick(function (){
			$('.main_bar').removeAttr('title');
			$('.prescriptions').css({"left": "-86%",});
			$('.main_bar').css({"-webkit-transform": "rotateY(360deg)", "transition": "0s", "box-shadow": "rgb(255, 117, 117) 0px 0px 0px",});
			$('.main_bar').removeClass('main_bar_b');
			$('.main_bar').animate({left: '0%',}, "1s");
		});
	});	
});