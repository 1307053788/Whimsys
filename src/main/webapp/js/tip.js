    $(function () {
        $('.tip-container').click(function () {
            if($("div [class='tip-input']").length < 4){
                var tipcon = '<div class="tip-input">' +
                    '<input type="text" class="house-tip" placeholder="个性标签">' +
                    '<span class="del"></span>' +
                    '</div>';
                $('.tip').prepend(tipcon);
                // 删除表单
                $('.del').click(function () {
                    $(this).parent().remove();
                });
            }else{
                alert("最多四个标签");
            }
        });
        /*---------------------年龄*/

    });
