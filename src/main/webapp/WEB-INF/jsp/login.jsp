<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>奇思妙享-登陆</title>
<!--图标-->
<link rel="icon" href="images/public/icon.png">
<!--重置-->
<link rel="stylesheet" type="text/css" href="css/reset.css">
<!--共有-->
<link rel="stylesheet" type="text/css" href="css/public.css">
<!--登陆-->
<link rel="stylesheet" type="text/css" href="css/login.css">
<!--登陆jquery-->
<script type="text/javascript" src="jquery/jquery-3.1.0.min.js"></script>
<!-- 弹出窗口 -->
<link rel="stylesheet" type="text/css" href="css/xcConfirm.css" />
<script src="jquery/jquery-1.9.1.js" type="text/javascript"
	charset="utf-8"></script>
<script src="jquery/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
<!--cookie-->
<script type="text/javascript" src="jquery/jquery.cookie.js"></script>
<!--登陆js-->
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<div class="register">
		<div class="W_width W_logo_wave">
			<a target="_self" href="Wmain"><img src="images/public/logo.png"></a>
		</div>
		<div class="login_content">
			<div class="tab_line">
				<h1>
					<a class="w_prn">个人登陆</a>
				</h1>
				<div class="tab_line_login">
					<h2>
						未注册<a href="Wregister">请先注册</a>
					</h2>
				</div>
			</div>
			<!--用户登录-->
			<div name="register-form" id="register-form" action="" method="post">
				<div class="chunk">
					<label for="userCount">用&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;名</label>
					<input type="text" name="userCount" id="userCount" class="same"
						placeholder="邮箱/会员账号/手机号">
				</div>
				<div class="input-tip"></div>
				<div class="chunk">
					<label for="userPassword">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
					<input type="password" name="userPassword" id="userPassword"
						class="same" placeholder="请输入密码">
				</div>
				<div class="input-tip"></div>
				<div class="lgn_chunk">
					<input type="checkbox" class="required" name="remember"
						id="remember" checked> <span class="font">下次自动登陆</span> <span
						id="forget"> <a class="font rempwd">忘记密码</a>
					</span>
				</div>
				<div class="chunk lgn_chunk lgn_color">
					<a class="btn-register" name="send" id="send">
						登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陆</a>
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