/**
 * Created by Administrator on 2016/9/12.
 */
$(function(){
    $(window).scroll(function(){
        var i = $(".footer").offset().top - $(".navigation").offset().top;
        $(".navigation").css("height",i);
    })
    var i = $(".footer").offset().top - $(".navigation").offset().top;
    $(".navigation").css("height",i);
});
$(function(){
    $(".wb_music_show_up").bind("click",function(){
        $(".wb_music_show").css("margin-left","0px");
        $(".wb_music_show_up").css("margin-left","-40px");
    });
    $(".wb_music_show_button").bind("click",function(){
        $(".wb_music_show").css("margin-left","-220px");
        $(".wb_music_show_up").css("margin-left","0px");
    });
    $(".wb_litter").bind("click",function(){
        $(".wb_litter_content").css("margin-bottom","0px");
        $(".wb_litter").css("margin-bottom","-40px");
    });
    $(".wb_litter_delete").bind("click",function(){
        $(".wb_litter_content").css("margin-bottom","-320px");
        $(".wb_litter").css("margin-bottom","0px");
    });
    $(".wb_music_show").css("margin-left","-220px");
    $(".wb_music_show_up").css("margin-left","0px");
    $(".wb_litter_content").css("margin-bottom","-320px");
    $(".wb_litter").css("margin-bottom","0px");
});

//消息框
(function($) {
    $.fn.extend({
        insertContent: function(myValue, t) {
            var $t = $(this)[0];
            if (document.selection) { //ie
                this.focus();
                var sel = document.selection.createRange();
                sel.text = myValue;
                this.focus();
                sel.moveStart('character', -l);
                var wee = sel.text.length;
                if (arguments.length == 2) {
                    var l = $t.value.length;
                    sel.moveEnd("character", wee + t);
                    t <= 0 ? sel.moveStart("character", wee - 2 * t - myValue.length) : sel.moveStart("character", wee - t - myValue.length);
                    sel.select();
                }
            } else if ($t.selectionStart || $t.selectionStart == '0') {
                var startPos = $t.selectionStart;
                var endPos = $t.selectionEnd;
                var scrollTop = $t.scrollTop;
                $t.value = $t.value.substring(0, startPos) + myValue + $t.value.substring(endPos, $t.value.length);
                this.focus();
                $t.selectionStart = startPos + myValue.length;
                $t.selectionEnd = startPos + myValue.length;
                $t.scrollTop = scrollTop;
                if (arguments.length == 2) {
                    $t.setSelectionRange(startPos - t, $t.selectionEnd + t);
                    this.focus();
                }
            }
            else {
                this.value += myValue;
                this.focus();
            }
        }
    })
})(jQuery);
$(document).ready(function(){
    $(".img-icon").click(function(){
        $(".WsendImg").show();
    });
});
//上传图片
$(function(){
    //关闭并取消上传
    $(".close").click(function(){
        $(".WsendImg").hide();
    });
    //颜色变换
    $(".W_clearfix .add").hover(function(){
        $(this).css("border","2px dashed #eb7350");
        $(this).children().eq(0).css("color","#eb7350");
    },function(){
        $(this).css("border","2px dashed #ccc");
        $(this).children().eq(0).css("color","#ccc");
    });
      //使用ajax上传图片
    $("#file").change(function(){
    	alert("上传成功！");
    	$("#uploadForm").submit();
    	return false;
//    	$.ajax({
//			type : "POST",
//			url : "upLoad",
//			data: {
//				file:$("this").val()
//			},
//			dataType : "json",
//			success : function(data) {
//				if (data.success == "true") {
//					var errormsg = '上传成功！';
//					window.wxc.xcConfirm(errormsg,
//							window.wxc.xcConfirm.typeEnum.error);
//				}
//			}
//		});
    });
});
//获取剩余字数
$(function(){
    $('.text').on('keyup',function(){
        var txtval = $('.text').val().length;
        console.log(txtval);
        var str = parseInt(140-txtval);
        console.log(str);
        if(str > 0 ){
            $('#num_txt').html(str);
        }else{
            $('#num_txt').html(0);
            $('#text_txt').val($('#text_txt').val().substring(0,140)); //这里意思是当里面的文字小于等于0的时候，那么字数不能再增加，只能是600个字
        }
    });
});
