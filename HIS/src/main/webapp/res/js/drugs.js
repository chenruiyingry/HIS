var main = document.getElementById('main');
main.style.height = $(window).height()-72+"px";
$(document).ready(function (){
	$('.main_content').mouseover(function (){
		$('.main_right_bottom').css({"height": "5%",});
		$('.main_right_top').css({"height": "61%",});
		$('.drop_b').css({"z-index": "-1", "padding-top": "0%",});
		$('.submit_bar').css({"height": "100%",});
		$('.submit_2').css({"margin-bottom": "0%", "left": "0px", "width": "100%", "height": "40px", "background-color": "#57a0d2cf",});
		$('.submit_2').val("返回");
		$('.button_1').css({"z-index": "3","background-color": "rgb(255, 138, 138)",});
		$('.main_content').css({"box-shadow": "rgba(0, 0, 0, 0.43) -3px 3px 5px", "left": "3px",});
	});
	$('.main_content').mouseout(function (){
		$('.main_content').css({"box-shadow": "rgba(0, 0, 0, 0.43) 0px 0px 0px", "left": "0%",});
	});
	$('.main_a').mouseout(function (){
		$('.main_right_bottom').css({"height": "70%",});
		$('.main_right_top').css({"height": "0%",});
		$('.drop_b').css({"z-index": "3", "padding-top": "3%",});
		$('.submit_bar').css({"height": "15%",});
		$('.submit_2').css({"margin-bottom": "5%", "left": "10%", "width": "80%", "height": "35px", "background-color": "rgb(255, 138, 138)",});
		$('.submit_2').val("添加");
		$('.drop_t').css({"z-index": "0",});
		$('.button_1').css({"background-color": "rgb(255, 138, 138, 0)",});
		$('.submit_3').css({"z-index": "0", "background-color": "rgb(255, 138, 138, 0)",});
		$('.drop_t_i').css({"border": "none", "border-bottom": "1px solid rgb(120, 120, 120)", "margin-top": "4%", "border-radius": "0px",});
	});
	$('.button_1').mouseover(function (){
		$('.main_right_bottom').css({"height": "5%",});
		$('.main_right_top').css({"height": "61%",});
		$('.drop_b').css({"z-index": "-1", "padding-top": "0%",});
		$('.submit_bar').css({"height": "100%",});
		$('.submit_2').css({"margin-bottom": "0%", "left": "0px", "width": "100%", "height": "40px", "background-color": "#57a0d2cf",});
		$('.submit_2').val("返回");
		$('.button_1').css({"background-color": "#f67272",});
	});
	$('.submit_3').mouseover(function (){
		$('.main_right_bottom').css({"height": "5%",});
		$('.main_right_top').css({"height": "61%",});
		$('.drop_b').css({"z-index": "-1", "padding-top": "0%",});
		$('.submit_bar').css({"height": "100%",});
		$('.submit_2').css({"margin-bottom": "0%", "left": "0px", "width": "100%", "height": "40px", "background-color": "#57a0d2cf",});
		$('.submit_2').val("返回");
		$('.drop_t').css({"z-index": "3",});
		$('.submit_3').css({"z-index": "3","background-color": "rgb(255, 138, 138)",});
		$('.drop_t_i').css({"border": "1px solid rgb(120, 120, 120)", "height": "40%", "margin-top": "4%", "border-radius": "3px",});
	});
	$('.drop_t').mouseover(function (){
		$('.main_right_bottom').css({"height": "5%",});
		$('.main_right_top').css({"height": "61%",});
		$('.drop_b').css({"z-index": "-1", "padding-top": "0%",});
		$('.submit_bar').css({"height": "100%",});
		$('.submit_2').css({"margin-bottom": "0%", "left": "0px", "width": "100%", "height": "40px", "background-color": "#57a0d2cf",});
		$('.submit_2').val("返回");
		$('.drop_t').css({"z-index": "3",});
		$('.button_1').css({"background-color": "#f67272",});
		$('.submit_3').css({"z-index": "3","background-color": "rgb(255, 138, 138)",});
		$('.drop_t_i').css({"border": "1px solid rgb(120, 120, 120)", "height": "40%", "margin-top": "4%", "border-radius": "3px",});
	});
	$('.button_1').mouseout(function (){
		$('.button_1').css({"background-color": "rgb(255, 138, 138)",});
	});
	$('.button_1').click(function (){
		$('.drop_t').css({"z-index": "3",});
		$('.button_1').css({"z-index": "-1",});
		$('.submit_3').css({"z-index": "3", "background-color": "rgb(255, 138, 138)",});
		$('.drop_t_i').css({"border": "1px solid rgb(120, 120, 120)", "height": "40%", "margin-top": "4%", "border-radius": "3px",});
	});
});