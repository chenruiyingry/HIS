var main = document.getElementById('main');
main.style.height = $(window).height()-72+"px";
$(document).ready(function (){
	$('.modif').mousedown(function (){
		timeout = setTimeout(function() {
			$('#module').css({"color": "rgba(74, 74, 74, 0.56)",});
			$('.name').css({"color": "rgba(74, 74, 74, 0.56)", "z-index": "2",});
			$('.textarea').css({"color": "rgba(74, 74, 74, 0.56)", "z-index": "2",});
			$('.cs').css({"display": "block",});
			$('.modif').css({"background-color": "rgba(0, 0, 0, 0.16)", "width": "100%",});
		}, 300);
	});
	$('.delete').mousedown(function (){
		timeout = setTimeout(function() {
			$('#module').css({"color": "rgba(74, 74, 74, 0.56)", "background-color": "#ffc8c8",});
			$('.name').css({"color": "rgba(74, 74, 74, 0.56)",});
			$('.textarea').css({"color": "rgba(74, 74, 74, 0.56)",});
			$('.delete').css({"background-color": "rgba(0, 0, 0, 0.16)", "width": "100%",});
			setTimeout(function() {
				$('.delete_a')[0].click();
			}, 3500);
			$(function (){
				var s = 2;
				setInterval(function (){
					$('#time').html("0." + s + "s 后删除");
					s--;
				}, 1000)
			});
		}, 200);
	});
	$('.md').mouseup(function (){
		clearTimeout(timeout);
		$('#module').css({"color": "rgba(74, 74, 74)",});
		$('.name').css({"color": "rgba(74, 74, 74)",});
		$('.textarea').css({"color": "rgba(74, 74, 74)",});
		$('.modif').css({"background-color": "rgba(0, 0, 0, 0)","width": "50%",});	
	});
	$('.md').mouseout(function (){
		$('#module').css({"color": "rgba(74, 74, 74)",});
		$('.name').css({"color": "rgba(74, 74, 74)",});
		$('.textarea').css({"color": "rgba(74, 74, 74)",});
		$('.modif').css({"background-color": "rgba(0, 0, 0, 0)","width": "50%",});
	});
	$('.plus').click(function (){
		$('.plus').css({"z-index": "0",});
		$('.fa-plus-square-o').css({"font-size": "0em", "top": "0%", "right": "0%", "width": "0%", "height": "0%", "color": "#0000", "transition": ".3s",});
		$('.return_p').animate({width: '60px', height: '60px',}, ".1s");
		$('.return_p').animate({width: '40px', height: '40px',}, ".2s");
		$('.name_2').animate({width: '60%', padding: '2% 4%',}, ".1s");
		$('.name_2').animate({width: '50%',}, ".2s");
		$('.plusresume').animate({height: '50%', padding: '5px 0px',}, ".1s");
		$('.save').css({"height": "10%", "border-radius": "0%", "width": "90%", "left": "5%", "bottom": "5%",});
	});
	$('.return_p').click(function (){
		$('.plus').css({"z-index": "1",});
		$('.fa-plus-square-o').css({"font-size": "6em", "top": "31%", "right": "0%", "width": "100%", "height": "38%", "color": "rgb(74, 74, 74)", "transition-delay": ".7s",});
		$('.return_p').animate({width: '60px', height: '60px',}, ".1s");
		$('.return_p').animate({width: '0px', height: '0px',}, ".2s");
		$('.name_2').animate({width: '60%',}, ".1s");
		$('.name_2').animate({width: '0%', padding: '3% 0%',}, ".2s");
		$('.plusresume').animate({height: '0%', padding: '0px 0px',}, ".1s");
		$('.save').css({"height": "0%", "border-radius": "50%", "width": "0%", "left": "50%", "bottom": "10%",});
	});
	$('.cancel').click(function (){
		$('.name').css({"z-index": "0",});
		$('.textarea').css({"z-index": "0",});
		$('.cs').css({"display": "none",});
	});
});