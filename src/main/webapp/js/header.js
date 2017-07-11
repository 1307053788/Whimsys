/**
 * Created by Michael on 2016/9/13.
 */
$(function(){
    $("#search").click(function(){
        alert("OK");
    });
    $(document).bind("click",function(e){
        $(".form-text").each(function(){
            if(e.target == this){
                $(this).css("border","1px solid red");
            }else{
                $(this).css("border","1px solid #DFDFDF");
            }
        });
    });
});