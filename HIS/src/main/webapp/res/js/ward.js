var main = document.getElementById('main');
main.style.height = $(window).height()-72+"px";
main.onwheel = function(event){  
    event.preventDefault();  
    var step = 20;  
    if(event.deltaY < 0){   
        this.scrollLeft -= step;  
    } else {   
        this.scrollLeft += step;  
    }  
}
$(document).ready(function (){
	$('.main').niceScroll({cursorcolor: "rgb(204, 204, 204)", mousescrollspeed: "20"});
	$('.plus').click(function (){
		$('.plus').css({"z-index": "-1",});
		$('.fa-plus-square-o').css({"font-size": "0em", "top": "0%", "right": "0%", "width": "0%", "height": "0%", "color": "#0000", "transition": ".3s",});
		$('.return_p').animate({width: '60px', height: '60px',}, ".1s");
		$('.return_p').animate({width: '40px', height: '40px',}, ".2s");
		$('.ngps').animate({width: '100%',}, ".1s");
		$('.np').animate({width: '70%', margin: '8% 10%', padding: '5%',}, ".2s");
		$('.gs').animate({width: '80%', margin: '8% 10%', padding: '5%',}, ".2s");
	});
	$('.return_p').click(function (){
		$('.plus').css({"z-index": "1",});
		$('.fa-plus-square-o').css({"font-size": "6em", "top": "42%", "right": "0%", "width": "100%", "height": "13%", "color": "rgb(74, 74, 74)", "transition-delay": ".7s",});
		$('.return_p').animate({width: '60px', height: '60px',}, ".1s");
		$('.return_p').animate({width: '0px', height: '0px',}, ".2s");
		$('.ngps').animate({width: '100%', margin: '8% 0%', padding: '5% 0%',}, ".1s");
		$('.ngps').animate({width: '0%',}, ".2s");
	});
});