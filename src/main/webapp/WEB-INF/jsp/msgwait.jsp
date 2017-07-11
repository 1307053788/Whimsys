<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>碎言碎语-个人主页</title>
    <meta name="keywords" content="个人主页"/>
    <meta name="description" content=""/>
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link type="text/css" rel="stylesheet" href="css/footer.css">
    <script type="text/javascript" src="js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
</head>

<body>
<div id="container">
    <div id="top">
        <a href="main.html"><img src="images/public/logo.png" style="margin: 20px auto;"></a>
    </div>
    <div id="content1">
        <!--header start-->
        <div id="header">
            <h1>个人主页</h1>
            <p>青春是打开了,就合不上的书。人生是踏上了，就回不了头的路，爱情是扔出了，就收不回的赌注。</p>
            <div id="nav">
                <ul>
                    <li><a href="index.html">首页</a></li>
                    <li><a href="about.html">关于我</a></li>
                    <li><a href="shuo.html">碎言碎语</a></li>
                    <li><a href="riji.html">个人收藏</a></li>
                    <li><a href="xc.html">相册展示</a></li>
                    <li><a href="guestbook.html">留言板</a></li>
                    <div class="clear"></div>
                </ul>
            </div>
        </div>
        <!--header end-->
        <!--content start-->
        <div id="say">
            <div class="weizi">
                <div class="wz_text">当前位置：<a href="#">首页</a>><h1>碎言碎语</h1></div>
            </div>
            <div>
                <form action="" method="post">
                    <br>
                    <div class="form-news">
                        <textarea name="message"></textarea>
                    </div>
                    <div align="center"><input type="reset" value="清除"/> <input type="submit" value="发表"/></div>
                </form>
            </div>
            <ul class="say_box">
                <div class="sy">
                    <p> 过去就像回形针，把青春一页页的固定，然后变成了一本不被出版的书。</p>
                </div>
                <span class="dateview">2014-5-31</span>
            </ul>
        </div>
        <!--content end-->
        <!--footer-->

        <!--footer end-->
    </div>
</div>
<div class="footer">
    <p class="footer_a">
        <a class="f_a">客服</a>
        <a class="f_a">意见反馈</a>
        <a class="f_a">舞弊举报</a>
        <a class="f_a">开放平台</a>
        <a class="f_a">招聘</a>
        <a class="f_a">举报处理大厅</a>
        <select>
            <option value="zh_cn">中文（简体）</option>
            <option value="en">English</option>
        </select>
    </p>
    <p class="footer_b">
        <a class="f_a">京ICP证100780号</a>
        <a class="f_a">互联网药品服务许可证</a>
        <a class="f_a">互联网医疗保健许可证</a>
        <a class="f_a">京网文[2014]2046-296号</a>
        <a class="f_a">京ICP备12002058号</a>
        <a class="f_a">增值电信业务经营许可证B2-20140447</a>
    </p>
</div>
<script type="text/javascript">jQuery(".lanmubox").slide({easing: "easeOutBounce", delayTime: 400});</script>
<script type="text/javascript" src="js/nav.js"></script>
</body>
</html>
