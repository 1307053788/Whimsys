/**
 * Created by Administrator on 2016/9/16.
 */
$(function(){
    $(window).scroll(function(){
        if($(document).scrollTop()+$(window).height()==$(".footer").offset().top+100){
            $(".navigation").addClass('nav_2').removeClass('nav_1');
        }else{
            $(".navigation").addClass('nav_1').removeClass('nav_2');
        }
    });
});
