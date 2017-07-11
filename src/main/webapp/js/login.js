$(function() {
	// 检查验证码
	$("#code").blur(
			function() {
				$.ajax({
					type : "POST",
					url : "checkCode",
					data : {
						code : $("#code").val()
					},
					dataType : "json",
					success : function(data) {
						if (data.success == "false") {
							var errormsg = '验证码错误';
							window.wxc.xcConfirm(errormsg,
									window.wxc.xcConfirm.typeEnum.error);
						}
					}
				});
			});
	// 提交表单
	$('#send').click(
			function() {

				if ($('#userCount').val() == '') {
					var txt = "账号不能为空！";
					window.wxc.xcConfirm(txt,
							window.wxc.xcConfirm.typeEnum.warning);
					$('#userCount').focus();
				} else if ($('#userPassword').val() == '') {
					var txt = "密码不能为空！";
					window.wxc.xcConfirm(txt,
							window.wxc.xcConfirm.typeEnum.warning);
					$('#userPassword').focus();
				} else {
					// 使用ajax提交登陆表单
					$.ajax({
						type : "POST",
						url : "checkLogin",
						data : {
							userCount : $("#userCount").val(),
							userPassword : $('#userPassword').val()
						},
						dataType : "json",
						success : function(data) {
							if (data.success == "true") {
								var txt = "登陆成功！";
								var option = {
									title : "消息提示",
									btn : parseInt("0011", 2),
									onOk: function(){
										window.location.href="Wmain";
									}
								}
								window.wxc.xcConfirm(txt, "success", option);
							} else {
								var txt = "用户名或者密码错误！";
								window.wxc.xcConfirm(txt,
										window.wxc.xcConfirm.typeEnum.error);
							}
						}
					});
				}
			});
	// 记住密码
	var COOKIE_NAME = 'userCount';
	if ($.cookie(COOKIE_NAME)) {
		$("#userCount").value($.cookie(COOKIE_NAME));
	}
	$("#remember").click(function() {
		if (this.checked) {
			$.cookie(COOKIE_NAME, $("#userCount").val(), {
				path : '/',
				expires : 7
			});
		} else {
			$.cookie(COOKIE_NAME, null, {
				path : '/'
			});
		}
	});
});