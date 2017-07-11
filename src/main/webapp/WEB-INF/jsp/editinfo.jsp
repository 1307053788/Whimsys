<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>编辑我的个人信息</title>
<!--图标-->
<link rel="icon" href="images/public/icon.png">
<!--重置-->
<link rel="stylesheet" type="text/css" href="css/reset.css">
<!--共有-->
<link rel="stylesheet" type="text/css" href="css/public.css">
<!--编辑我的主页CSS-->
<link rel="stylesheet" type="text/css" href="css/editinfo.css">
<!--编辑标签的CSS-->
<link rel="stylesheet" type="text/css" href="css/tip.css" />
<!--jquery-->
<script type="text/javascript" src="jquery/jquery-3.1.0.min.js"></script>

<!--[if lt IE 9]>
    <script src="jquery/html5shiv.js"></script>
    <![endif]-->

<link href="css/normalize.css" rel="stylesheet" />
<link href="css/jquery-ui.css" rel="stylesheet" />
<link href="css/jquery.idealforms.min.css" rel="stylesheet"
	media="screen" />
</head>
<body>
	<div class="register">
		<div class="W_width W_logo_wave">
			<a target="_self" href="Wmain"><img src="images/public/logo.png"></a>
		</div>
		<div class="eightcol last">

			<!-- Begin Form -->

			<form id="my-form">

				<section name="第一步">

					<div>
						<label>昵称:</label><input id="userNickname" name="userNickname"
							type="text" />
					</div>
					<div>
						<label>真实姓名:</label><input id="userRealname" name="userRealname"
							type="text" />
					</div>
					<div>
						<label>性别:</label><select id="userSex" name="userSex"><option>男</option>
							<option>女</option></select>
					</div>
					<div>
						<label>年龄:</label><input id="userAge" name="userAge" type="text" />
					</div>
					<div>
						<label>上传头像:</label><input id="userFace" name="userFace" multiple
							type="file" />
					</div>
					<div
						style="width: 200px; height: 200px; background-color: #1a8fc9; margin-top: 50px; margin-left: 430px"></div>
				</section>

				<section name="第二步">
					<div>
						<label>QQ:</label><input id="userQq" name="userQq" type="text" />
					</div>
					<div>
						<label>邮箱:</label><input id="userEmail" name="userEmail"
							type="text" />
					</div>
					<div>
						<label>手机号:</label><input id="userPhone" name="userPhone"
							type="text" />
					</div>
					<div>
						<label>毕业院校:</label><input id="userUniversity"
							name="userUniversity" type="text" />
					</div>
				</section>
				<section name="第三步">
					<div class="site">
						<div class="title">标签：</div>
						<div class="tip">
							<div class="tip-container">
								<span class="jia"></span>添加标签
							</div>
						</div>
					</div>
					<div>
						<label>自我描述:</label>
						<textarea id="userIntroduce" name="userIntroduce"
							style="width: 340px; height: 90px"></textarea>
					</div>
				</section>

				<div>
					<hr />
				</div>
				<div>
					<input type="submit" value="提交"> <input id="reset"
						type="submit" value="重置">
				</div>
				<div class="into_my_home">
					返回 <a href="index.html">我的主页</a>

				</div>
			</form>

			<!--End Form -->

		</div>
		<!--标签的js -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/tip.js"></script>

		<script type="text/javascript" src="jquery/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="jquery/jquery-ui.min.js"></script>
		<script type="text/javascript" src="jquery/jquery.idealforms.js"></script>
		<script type="text/javascript">
			var options = {

				onFail : function() {
					alert($myform.getInvalid().length + ' invalid fields.')
				},

				inputs : {
					'password' : {
						filters : 'required pass',
					},
					'username' : {
						filters : 'required username',
						data : {
						//ajax: { url:'validate.php' }
						}
					},
					'file' : {
						filters : 'extension',
						data : {
							extension : [ 'jpg' ]
						}
					},
					'comments' : {
						filters : 'min max',
						data : {
							min : 50,
							max : 200
						}
					},
					'states' : {
						filters : 'exclude',
						data : {
							exclude : [ 'default' ]
						},
						errors : {
							exclude : '选择国籍.'
						}
					},
					'langs[]' : {
						filters : 'min max',
						data : {
							min : 2,
							max : 3
						},
						errors : {
							min : 'Check at least <strong>2</strong> options.',
							max : 'No more than <strong>3</strong> options allowed.'
						}
					}
				}

			};

			var $myform = $('#my-form').idealforms(options).data('idealforms');

			$('#reset').click(function() {
				$myform.reset().fresh().focusFirst();
			});

			$myform.focusFirst();
		</script>

	</div>
</body>
</html>