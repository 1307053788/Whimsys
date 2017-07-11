<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>奇思妙享-注册</title>
<!--图标-->
<link rel="icon" href="images/public/icon.png">
<!--重置-->
<link rel="stylesheet" type="text/css" href="css/reset.css">
<!--共有-->
<link rel="stylesheet" type="text/css" href="css/public.css">
<!--注册-->
<link rel="stylesheet" type="text/css" href="css/register.css">
<!-- 弹出窗口 -->
<link rel="stylesheet" type="text/css" href="css/xcConfirm.css" />
<script src="jquery/jquery-1.9.1.js" type="text/javascript"
	charset="utf-8"></script>
<script src="jquery/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
<!--注册jquery-->
<script type="text/javascript" src="jquery/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="jquery/jquery-1.5.1.min.js"></script>
<!--注册js-->
<script type="text/javascript" src="js/register.js"></script>
</head>
<body>
	<div class="register">
		<div class="W_width W_logo_wave">
			<a target="_self" href="Wmain"><img src="images/public/logo.png"></a>
		</div>
		<div class="reg_content">
			<div class="tab_line">
				<h1>
					<a class="w_prn">个人注册</a>
				</h1>
				<div class="tab_line_login">
					<h2>
						已有账号<a href="Wlogin">去登陆</a>
					</h2>
				</div>
			</div>
			<div name="register-form"
				id="register-form">
				<div class="chunk">
					<label for="userCount">用&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;名</label>
					<input type="text" name="userCount" id="userCount" class="same"
						placeholder="您的帐户名和登录名">
				</div>
				<div class="input-tip">
					<span></span>
				</div>
				<div class="chunk">
					<label for="userPassword">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
					<input type="password" name="userPassword" id="userPassword"
						class="same" placeholder="建议至少使用两种字符组合">
				</div>
				<div class="input-tip">
					<span></span>
				</div>
				<div class="chunk">
					<label for="spwd">确&nbsp;认&nbsp;密&nbsp;码</label> <input
						type="password" name="spwd" id="spwd" class="same"
						placeholder="请再次输入密码">
				</div>
				<div class="input-tip">
					<span></span>
				</div>
				<div class="chunk">
					<label for="userEmail">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
					<input type="text" name="userEmail" id="userEmail" class="same"
						placeholder="请输入邮箱">
					<ul class="on_changes">
						<li email="">请选择邮箱类型</li>
						<li email="" class=""></li>
						<li email="@sina.com" class="">@sina.com</li>
						<li email="@163.com">@163.com</li>
						<li email="@qq.com">@qq.com</li>
						<li email="@hotmail.com">@hotmail.com</li>
						<li email="@126.com">@126.com</li>
						<li email="@gmail.com">@gmail.com</li>
						<li email="@yahoo.com" class="active">@yahoo.com</li>
					</ul>
				</div>
				<div class="input-tip">
					<span></span>
				</div>
				<div class="chunk">
					<label for="code">验&nbsp;&nbsp;&nbsp;证&nbsp;&nbsp;&nbsp;码</label> <input
						type="text" id="code" name="code" class="same"
						placeholder="请输入验证码"> <a href="javascript:loadimage();">
						<img class="img-code" title="换一换" id="imgAuthCode" src="code.jsp">
					</a>
				</div>
				<div class="input-tip">
					<span></span>
				</div>
				<div class="chunk_a">
					<input type="checkbox" class="required" name="agree" id="agree">
					我已阅读并同意 <a id="protocol">《奇思妙享用户注册协议》</a>
					<div class="input-tip">
						<span></span>
					</div>
				</div>
				<div class="input-tip">
					<span></span>
				</div>
				<div class="chunk">
					<input type="button" class="btn-register" name="send" id="send"
						value="立即注册" />
				</div>
			</div>
		</div>
		<div class="footer">
			<div class="left_link">
				<strong class="company_name">北京弑晓风技术有限公司</strong> <a href=""
					class="company_name">京网文[2011]521-1314号</a> <a href=""
					class="company_name">京ICP备12002058号</a>
			</div>
			<div class="copy">
				<span class="company_name">Copyright © 2009-2016 WEIBO</span> <select
					class="changeLanguage">
					<option selected="selected" value="zh-cn">中文(简体)</option>
					<option value="en-us">English</option>
				</select>
			</div>
		</div>
	</div>
</body>
</html>