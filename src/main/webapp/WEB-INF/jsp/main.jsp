<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>我的首页 奇思妙享-随时随地分享你的快乐！</title>
<!--图标-->
<link rel="icon" href="images/public/icon.png">
<!--icon字体-->
<link rel="stylesheet" type="text/css" href="css/iconfont.css">
<!--重置-->
<link rel="stylesheet" type="text/css" href="css/reset.css">
<!--主页CSS-->
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<!--评论框-->
<link rel="stylesheet" type="text/css" href="css/sinaFaceAndEffec.css" />
<!--主页jquery-->
<script type="text/javascript" src="jquery/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="jquery/jquery-1.8.3.min.js"></script>
<!--头部-->
<script src="js/header.js"></script>
<!--主页js-->
<script type="text/javascript" src="js/main.js"></script>
<!--评论框jquery-->
<script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
<!--音乐置顶-->
<link href='css/styles.css' rel='stylesheet'>
<link href='css/footer.css' rel='stylesheet'>
<script type="text/javascript" src="jquery/elevator.js"></script>
<!-- 弹出窗口 -->
<link rel="stylesheet" type="text/css" href="css/xcConfirm.css" />
<script src="jquery/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div class="WB_miniblog">
		<div class="header">
			<div class="head ftr">
				<div id="header">
					<div class="h_index">
						<a target="_self" href="main.html"><img
							src="images/public/logo.png"></a>
					</div>
					<div class="h_form">
						<input id="form-text" name="form-text" type="text"
							placeholder="大家都在搜:爱生活，爱超哥" class="form-text"> <i
							class="iconfont" id="search" title="搜索">&#xe613;</i>
					</div>
					<div class="h_menu">
						<ul>
							<li><h2>
									<a rel=""><i class="iconfont">&#xe623;</i>分享</a>
								</h2></li>
							<li><h2>
									<a href="register.html"><i class="iconfont">&#xe60c;</i>注册</a>
								</h2></li>
							<li><h2>
									<a href="login.html"><i class="iconfont">&#xe62a;</i>登陆</a>
								</h2></li>
							<li><h2>
									<a href="index.html"><i class="iconfont">&#xe62b;</i>我的主页</a>
								</h2></li>
							<li><h2>
									<a target="_self" href="main.html"><i class="iconfont">&#xe60b;</i>首页</a>
								</h2></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="contain ftr">
				<div class="navigation">
					<!-- 左侧列表 -->
					<div class="navigation_top">
						<ul>
							<li><a href="#"><h3>首页</h3></a></li>
							<li><a href="kind.html"><h3>全部分类</h3></a></li>
							<li><a href="list.html"><h3>我要找人</h3></a></li>
						</ul>
					</div>
					<div class="n1">
						<ul>
							<li><a target="_blank" href="">热门文章</a></li>
						</ul>
					</div>
					<div class="n2">
						<ul>
							<li><a target="_blank" href="">好友圈</a></li>
							<li><a target="_blank" href="">特别关注</a></li>
							<li><a target="_blank" href="">那些话</a></li>
							<li><a target="_blank" href="">搞笑</a></li>
							<li><a target="_blank" href="">吐槽</a></li>
							<li class="n3">展开</li>
						</ul>
					</div>
				</div>
				<div class="content">
					<div class="ct_1">
						<div class="title_area">
							有什么新鲜事想与大家分享？ <span class="figure">您还可以输入<strong
								id="num_txt">140</strong>字
							</span>
						</div>
						<!-- 需分享内容 -->
						<div class="wrap">
							<div class="comment">
								<div class="content">
									<div class="cont-box">
										<textarea class="text" placeholder="请输入..." maxlength="140"></textarea>
									</div>
									<div class="tools-box">
										<div class="operator-box-btn">
											<span class="face-icon">☺</span><span class="img-icon">▧</span>
										</div>
										<div class="submit-btn">
											<input type="button" onClick="out()" value="发布" id="send" />
										</div>
									</div>
								</div>
								<div class="clr"></div>
							</div>
						</div>
					</div>
					<div class="ct_2">
						<div class="homefeed">
							<!--feed list-->
							<!-- 循环显示分享内容 -->
							<div class="ww">
								<div id="info-show">
									<ul></ul>
								</div>
								<script type="text/javascript">
									// 绑定表情
									$('.face-icon').SinaEmotion($('.text'));
									// 测试本地解析
									function out() {
										//  使用ajax将发送的内容传入后台
										var inputText = $('.text').val()
												.replace(/\n/g, '<br/>');
										$('#info-show ul')
												.append(
														reply(AnalyticEmotion(inputText)));
										$(".text").val("");
									}
									var html;
									function reply(content) {
										html = '<li>';
										html += '<div class="head-face">';
										html += '<img src="images/face/face1.png" / >';
										html += '</div>';
										html += '<div class="reply-cont">';
										html += '<p class="userName">陈安硕</p><p class="msgTime">2016年9月15日</p>';
										html += '<div class="comment-body">'
												+ content + '</div>';
										html += '</div>';
										html += '<div class="clr"></div>';
										html += '<div class="comment-footer">';
										html += '<div class="cftr_ul">';
										html += '<span class="cftr_s bor">收藏</span>';
										html += '<span class="cftr_s">转发<strong>0</strong></span>';
										html += '<span class="cftr_s">评论<strong>0</strong></span>';
										html += '<span class="cftr_s ">点赞<strong>0</strong></span>';
										html += '</div>';
										html += '</div>';
										html += '</li>';
										return html;
									}
								</script>
								<div class="clr"></div>
							</div>


						</div>
					</div>
				</div>
				<!-- 右侧个人信息 -->
				<div class="contain-r">
					<div class="cc">
						<div class="cc1">
							<p class="cc1_img">
								<img src="images/face/face1.png">
							</p>
						</div>
						<div class="cc2">用陈安硕来凑齐10个字</div>
						<div class="cc3">
							<ul>
								<li><a target="_blank" href=""> <strong
										class="c_left_top11">123</strong> <span>关注</span>
								</a></li>

								<li><a target="_blank" href=""> <strong
										class="c_left_top11">223</strong> <span>粉丝</span>
								</a></li>

								<li><a target="_blank" href=""> <strong
										class="c_left_top11">442</strong> <span>分享</span>
								</a></li>
							</ul>
						</div>
					</div>
					<!-- 右侧热门话题 -->
					<div class="WB_cardwrap">
						<ul>
							<li><h3>
									热门话题<span>换一换</span>
								</h3></li>
							<li><a target="_blank" href="">#杨幂0912生日快乐#</a><span>113万</span></li>
							<li><a target="_blank" href="">#张国荣六十岁生日快乐#</a><span>13万</span></li>
							<li><a target="_blank" href="">#真心真技只为你#</a><span>63万</span></li>
							<li><a target="_blank" href="">#914七月与安生#</a><span>233万</span></li>
							<li><a target="_blank" href="">#全新一代奥迪A4L#</a><span>173万</span></li>
							<li><a target="_blank" href="">#少年火星人之烦恼#</a><span>13万</span></li>
							<li><a target="_blank" href="">#真心真技只为你#</a><span>63万</span></li>
							<li><a target="_blank" href="">#914七月与安生#</a><span>233万</span></li>
							<li><a target="_blank" href="">#全新一代奥迪A4L#</a><span>173万</span></li>
							<li><a target="_blank" href="">#少年火星人之烦恼#</a><span>13万</span></li>
						</ul>
					</div>
					<div class="wc">
						<ul>
							<li class="wc1"><a target="_blank" href="">查看更多 ></a></li>
						</ul>
					</div>
					<!-- 右下角广告 -->
					<div class="wc2">
						<ul>
							<li class="wc21"><img src="images/main/gg.jpg"></li>
							<li class="wc22"><a target="_blank" href="">广告</a></li>
						</ul>
					</div>
					<!-- 右下角好友关注状态 -->
					<div class="wc3">
						<ul>
							<li><h3>好友关注状态</h3></li>
						</ul>
					</div>
					<div class="wc4">
						<ul>
							<li><a target="_blank" href="">@菊白灰</a>等135万人关注了</li>
							<li><a target="_blank" href=""><img
									src="images/main/ncpp.jpg">陈伟霆</a>&nbsp;&nbsp; 职业：歌手+演员<span><button
										class="44" type="submit">+关注</button></span></li>
							<li><a target="_blank" href="">@韩剧萌主</a>也关注</li>
							<li><a target="_blank" href=""><img
									src="images/main/ncpp.jpg">七月</a>&nbsp;&nbsp; 职业：知名博主<span><button
										class="44" type="submit">+关注</button></span></li>
							<li><a target="_blank" href="">@Aom_SusharManaying</a>也关注</li>
							<li><a target="_blank" href=""><img
									src="images/main/ncpp.jpg">少年火星人</a>&nbsp;&nbsp; 职业：相声演员<span><button
										class="44" type="submit">+关注</button></span></li>
							<li><a target="_blank" href="">@turbosun </a>等13万人关注了</li>
							<li><a target="_blank" href=""><img
									src="images/main/ncpp.jpg">七月生</a>&nbsp;&nbsp; 职业：知名搞笑幽默<span><button
										class="44" type="submit">+关注</button></span></li>
							<li><a target="_blank" href="">@turbosun </a>等13万人关注了</li>
							<li><a target="_blank" href=""><img
									src="images/main/ncpp.jpg">七月生</a>&nbsp;&nbsp; 职业：知名搞笑幽默<span><button
										class="44" type="submit">+关注</button></span></li>
						</ul>
					</div>
					<!-- 右下角公告栏 -->
					<div class="wc3">
						<ul>
							<li><h3>公告栏</h3></li>
						</ul>
					</div>
					<div class="wc5">
						<ul>
							<li><a target="_blank" href="">《​全国辟谣平台》</a></li>
							<li><a target="_blank" href="">《首都互联网协会发布坚守七条底线倡议书》</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="clr"></div>
		<div class="footer_back">
			<div class="do-the-thing">
				<div class="elevator">
					<i class="iconfont" id="top">&#xe615;</i>
				</div>
			</div>
		</div>
		<div class="footer">
			<p class="footer_a">
				<a class="f_a">客服</a> <a class="f_a">意见反馈</a> <a class="f_a">舞弊举报</a>
				<a class="f_a">开放平台</a> <a class="f_a">招聘</a> <a class="f_a">举报处理大厅</a>
				<select>
					<option value="zh_cn">中文（简体）</option>
					<option value="en">English</option>
				</select>
			</p>
			<p class="footer_b">
				<a class="f_a">京ICP证100780号</a> <a class="f_a">互联网药品服务许可证</a> <a
					class="f_a">互联网医疗保健许可证</a> <a class="f_a">京网文[2014]2046-296号</a> <a
					class="f_a">京ICP备12002058号</a> <a class="f_a">增值电信业务经营许可证B2-20140447</a>
			</p>
		</div>
		<script>
			var elementButton = document.querySelector('.elevator');
			var elevator = new Elevator({
				element : elementButton,
				mainAudio : 'music/footer/elevator.mp3',
				endAudio : 'music/footer/ding.mp3'
			});
		</script>
		<div class="W_gotop">
			<em class="W_icon"></em>
		</div>
		<div id="wb_music_show" class="wb_music_show">
			<div class="wb_music_show_button">
				<a><<</a>
			</div>
		</div>
		<div class="wb_music_show_up">
			<a>>></a>
		</div>
		<div class="wb_litter">
			<a><h2>私信</h2></a>
		</div>
		<div class="wb_litter_content">
			<div class="wb_litter_delete">
				<a>X</a>
			</div>
		</div>
		<div class="WsendImg">
			<div class="Wimg_Content">
				<div class="W_close">
					<p class="close">X</p>
				</div>
				<div class="W_inner">
					<div class="W_clearfix">
						<div class="W_layer_con_tit">
							<h1>上传图片</h1>
							<h2>
								共<span>0</span>张， 还能上传<span>9</span>张
							</h2>
						</div>
						<ul>
							<c:if test="${fList!=null}">
								<c:forEach items="${fList}" var="fList">
									<li class="pic">
										<div class="addImgPic">
											<img src="${fList}" id="imgPic">
										</div>
									</li>
								</c:forEach>
							</c:if>
							<li class="add"><a class="Wadd">+</a>
								<div class="addImg">
									<form method="post" enctype="multipart/form-data"
										id="uploadForm" name="uploadForm" action="upLoad">
										<input type="file" multiple="multiple" id="file" name="file"
											accept=".png,.jpg,.jpeg,.gif">
									</form>
								</div></li>
						</ul>
					</div>


				</div>
			</div>
		</div>
	</div>
</body>
</html>