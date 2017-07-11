/**
 * Created by Michael on 2016/9/8.
 */
$(function() {
	$("#userEmail").changeTips({
		divTip : ".on_changes"
	});
})
$(function() {
	$("#register-form input")
			.blur(
					function() {
						var $msg = $(this).parent().next().children(0);
						$msg.find(".i-error").remove();
						$(this).parent().removeClass("form-item-error");
						// //验证用户名
						if ($(this).is('#userCount')) {
							if (this.value == "" || this.value.length < 4
									|| this.value.length > 20) {
								var errormsg = '请输入4~20个字符';
								$msg.append('<i class="i-error">' + errormsg
										+ '</i>');
								$(this).parent().addClass("form-item-error");
							}
						}
						// 验证密码
						if ($(this).is('#userPassword')) {
							if (this.value == "" || this.value.length < 4
									|| this.value.length > 20) {
								var errormsg = '请输入4~20个字符';
								$msg.append('<i class="i-error">' + errormsg
										+ '</i>');
								$(this).parent().addClass("form-item-error");
							}
						}
						// 验证确认密码
						if ($(this).is('#spwd')) {
							if (this.value != $('#userPassword').val()) {
								var errormsg = '两次输入密码不一致';
								$msg.append('<i class="i-error">' + errormsg
										+ '</i>');
								$(this).parent().addClass("form-item-error");
							}
						}
						// 验证邮箱格式
						if ($(this).is('#userEmail')) {
							if (this.value == ""
									|| !/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
											.test(this.value)) {
								var errormsg = '邮箱格式错误';
								$msg.append('<i class="i-error">' + errormsg
										+ '</i>');
								$(this).parent().addClass("form-item-error");
							}
						}
						// 验证单选框
						if ($(this).is('#agree')) {
							if (!this.checked) {
								var errormsg = '请同意协议并勾选';
								$msg.append('<i class="i-error">' + errormsg
										+ '</i>');
							}
						}
					});
	// 提交表单时的验证
	$("#send").click(
			function() {
				$("#register-form input").trigger('blur');
				var numError = $(".i-error").length;
				var formError = $(".form-item-error").length;
				var sum = numError + formError;
				if (sum) {
					var txt = "注册失败，请重新注册！";
					window.wxc.xcConfirm(txt,
							window.wxc.xcConfirm.typeEnum.error);
					return false;
				} else {
					$.ajax({
						type : "POST",
						url : "userRegister",
						data : {
							userCount : $("#userCount").val(),
							userPassword : $("#userPassword").val(),
							userEmail : $("#userEmail").val()
						},
						dataType : "json",
						success : function(data) {
							if (data.success == "true") {
								var txt = "注册成功！";
								var option = {
									title : "消息提示",
									btn : parseInt("0011", 2),
									onOk : function() {
										window.location.href = "Wlogin";
									}
								}
								window.wxc.xcConfirm(txt, "success", option);
							} else {
								var txt = "注册失败，请重新注册！";
								window.wxc.xcConfirm(txt,
										window.wxc.xcConfirm.typeEnum.error);
							}
						}

					});
				}

			});
	// 禁用Enter键表单自动提交
	document.onkeydown = function(event) {
		var target, code, tag;
		if (!event) {
			event = window.event; // 针对ie浏览器
			target = event.srcElement;
			code = event.keyCode;
			if (code == 13) {
				tag = target.tagName;
				if (tag == "TEXTAREA") {
					return true;
				} else {
					return false;
				}
			}
		} else {
			target = event.target; // 针对遵循w3c标准的浏览器，如Firefox
			code = event.keyCode;
			if (code == 13) {
				tag = target.tagName;
				if (tag == "INPUT") {
					return false;
				} else {
					return true;
				}
			}
		}
	};
	// 检查用户名是否存在
	$("#userCount").blur(function() {
		var $msg = $(this).parent().next().children(0);
		$msg.find(".i-info").remove();
		$(this).parent().removeClass("i-warn");
		$.ajax({
			type : "POST",
			url : "checkUserExist",
			data : {
				userCount : $("#userCount").val()
			},
			dataType : "json",
			success : function(data) {
				if (data.success == "true") {
					var errormsg = '用户已存在';
					$msg.append('<i class="i-info">' + errormsg + '</i>');
					$(this).parent().addClass("i-warn");
				} else {
					$msg.find(".info").remove();
					$(this).parent().removeClass("i-warn");
				}
			}

		});
	});
	// 检查验证码
	$("#code").blur(function() {
		var $msg = $(this).parent().next().children(0);
		$msg.find(".i-error").remove();
		$(this).parent().removeClass("form-item-error");
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
					$msg.append('<i class="i-error">' + errormsg + '</i>');
					$(this).parent().addClass("form-item-error");
				} else {
					$msg.find(".i-error").remove();
					$(this).parent().removeClass("form-item-error");
				}
			}

		});

	});
});
// 更换验证码
function loadimage() {
	document.getElementById("imgAuthCode").src = "code.jsp?" + Math.random();
}
// 邮箱自动补全
(function($) {
	$.fn.extend({
		"changeTips" : function(value) {
			value = $.extend({
				divTip : ""
			}, value)

			var $this = $(this);
			var indexLi = 0;

			// 点击document隐藏下拉层
			$(document).click(
					function(event) {
						if ($(event.target).attr("class") == value.divTip
								|| $(event.target).is("li")) {
							var liVal = $(event.target).text();
							$this.val(liVal);
							blus();
						} else {
							blus();
						}
					})

			// 隐藏下拉层
			function blus() {
				$(value.divTip).hide();
			}

			// 键盘上下执行的函数
			function keychang(up) {
				if (up == "up") {
					if (indexLi == 1) {
						indexLi = $(value.divTip).children().length - 1;
					} else {
						indexLi--;
					}
				} else {
					if (indexLi == $(value.divTip).children().length - 1) {
						indexLi = 1;
					} else {
						indexLi++;
					}
				}
				$(value.divTip).children().eq(indexLi).addClass("active")
						.siblings().removeClass();
			}

			// 值发生改变时
			function valChange() {
				var tex = $this.val();// 输入框的值
				var fronts = "";// 存放含有“@”之前的字符串
				var af = /@/;
				var regMail = new RegExp(tex.substring(tex.indexOf("@")));// 有“@”之后的字符串,注意正则字面量方法，是不能用变量的。所以这里用的是new方式。

				// 让提示层显示，并对里面的LI遍历
				if ($this.val() == "") {
					blus();
				} else {
					$(value.divTip).show().children()
							.each(
									function(index) {
										var valAttr = $(this).attr("email");
										if (index == 1) {
											$(this).text(tex)
													.addClass("active")
													.siblings().removeClass();
										}
										// 索引值大于1的LI元素进处处理
										if (index > 1) {
											// 当输入的值有“@”的时候
											if (af.test(tex)) {
												// 如果含有“@”就截取输入框这个符号之前的字符串
												fronts = tex.substring(tex
														.indexOf("@"), 0);
												$(this).text(fronts + valAttr);
												// 判断输入的值“@”之后的值，是否含有和LI的email属性
												if (regMail.test($(this).attr(
														"email"))) {
													$(this).show();
												} else {
													if (index > 1) {
														$(this).hide();
													}
												}

											}
											// 当输入的值没有“@”的时候
											else {
												$(this).text(tex + valAttr);
											}
										}
									})
				}
			}

			// 输入框值发生改变的时候执行函数，这里的事件用判断处理浏览器兼容性;
			if ($.browser.msie) {
				$(this).bind("propertychange", function() {
					valChange();
				})
			} else {
				$(this).bind("input", function() {
					valChange();
				})
			}

			// 鼠标点击和悬停LI
			$(value.divTip).children().hover(function() {
				indexLi = $(this).index();// 获取当前鼠标悬停时的LI索引值;
				if ($(this).index() != 0) {
					$(this).addClass("active").siblings().removeClass();
				}
			})

			// 按键盘的上下移动LI的背景色
			$this.keydown(function(event) {
				if (event.which == 38) {// 向上
					keychang("up")
				} else if (event.which == 40) {// 向下
					keychang()
				} else if (event.which == 13) { // 回车
					var liVal = $(value.divTip).children().eq(indexLi).text();
					$this.val(liVal);
					blus();
				}
			})
		}
	})
})(jQuery)