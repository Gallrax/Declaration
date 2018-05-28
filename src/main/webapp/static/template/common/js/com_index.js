// JavaScript Document

$('.title_row').click(function(){
	$(this).parent().addClass('declare_cell_active').siblings().removeClass('declare_cell_active')
})

$('.declare_class li').click(function(){
	$('.declare_class li').removeClass('current')
	$(this).addClass('current')
	
})


$(function(){
	$(".subNav").click(function(){
		$(this).toggleClass("currentDd").siblings(".subNav").removeClass("currentDd")
		$(this).toggleClass("currentDt").siblings(".subNav").removeClass("currentDt")
			
		// 修改数字控制速度， slideUp(500)控制卷起速度
		$(this).next(".navContent").slideToggle(500).siblings(".navContent").slideUp(500);
	})	
})

//活动内容--more查看更多
$('.more_an').click(function(){
	$('.act_text').css({'height':'auto'})
	$('.more_bottom').hide()
})