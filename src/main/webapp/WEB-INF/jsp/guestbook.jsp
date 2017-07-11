<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>留言板-个人主页</title>
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
    <style>
        .article {
            border: 1px solid #a6cbe7;
            margin-top: 5px;
        }

        .author {
            background-color: #c5c5c5;
            width: 100%;
            height: 24px;
            line-height: 24px;
        }

        .content {
            height: 40px;
            padding: 10px;
        }

        .author span {
            float: right;
            padding-right: 10px;
        }

        .time {
            border-top: solid 1px #a6cbe7;
        }

        .page {
            text-align: right;
            height: 30px;
            line-height: 30px;
            padding-right: 10px;
        }
        .weizi_con textarea:focus{
            outline: none;
        }
    </style>
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
        </div>
        <!--header end-->
        <!--nav-->
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
        <!--nav end-->
        <!--content start-->
        <div id="content">
            <!--left-->
            <div class="left" id="guestbook">
                <div class="weizi">
                    <div class="wz_text">当前位置：<a href="#">首页</a>><h1>留言板</h1></div>
                </div>
                <div class="g_content">
                    <div>
                        <form action="" method="post">
                            <div class="weizi_con">
                                留句话吧: <textarea name="message" rows="5" cols="72"></textarea>
                            </div>
                            <div align="center"><input type="reset" value="清除"/> <input type="submit" value="发表"/></div>
                        </form>
                    </div>
                    <br>
                    <div>
                        <div class="article">
                            <div class="author">用户:张三<span>12#</span></div>
                            <div class="content">测试一下</div>
                            <div class="time page">发表于:2016-02-09 13:12:23</div>
                        </div>
                        <div class="article">
                            <div class="author">用户:张三<span>11#</span></div>
                            <div class="content">测试一下</div>
                            <div class="time page">发表于:2016-02-09 13:12:23</div>
                        </div>
                        <div class="article">
                            <div class="author">用户:张三<span>10#</span></div>
                            <div class="content">测试一下</div>
                            <div class="time page">发表于:2016-02-09 13:12:23</div>
                        </div>
                    </div>

                    <div class="page">
                        <input class="btn1" type="button" value="上一页" onClick="">
                        <input class="btn1" type="button" value="下一页" onClick="">
                    </div>
                </div>
            </div>
            <!--end left -->
            <!--right-->
            <div class="right" id="c_right">
                <div class="s_about">
                    <h2>个人中心</h2>
                    <img src="images/myhome/my.jpg" width="230" height="230" alt="博主"/>
                    <p>昵称：XX</p>
                    <p>职业：web前端、视觉设计</p>
                    <p>自我介绍：</p>
                </div>
                <!--栏目分类-->
                <div class="lanmubox">
                    <div class="hd">
                        <ul>
                            <li>关注</li>
                            <li>粉丝</li>
                            <li class="hd_3">分享</li>
                        </ul>
                    </div>
                    <div class="bd">
                        <ul>
                            <li>
                                <a href="#" title="陈伟霆">陈伟霆</a>
                                &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">取消关注</button>
                            </li>
                            <li><a href="#" title="李易峰">李易峰</a>
                                &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">取消关注</button>
                            </li>
                            <li><a href="#" title="陈伟霆">陈伟霆</a>
                                &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">取消关注</button>
                            </li>
                            <li><a href="#" title="李易峰">李易峰</a>
                                &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">取消关注</button>
                            </li>
                            <li><a href="#" title="陈伟霆">陈伟霆</a>
                                &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">取消关注</button>
                            </li>
                        </ul>
                        <ul>
                            <li><a href="#" title="陈伟霆">陈伟霆</a> &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">+关注</button>
                            </li>
                            <li><a href="#" title="李易峰">李易峰</a> &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">+关注</button>
                            </li>
                            <li><a href="#" title="陈伟霆">陈伟霆</a> &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">+关注</button>
                            </li>
                            <li><a href="#" title="李易峰">李易峰</a> &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">+关注</button>
                            </li>
                            <li><a href="#" title="陈伟霆">陈伟霆</a> &nbsp;
                                职业：歌手+演员
                                <button class="44" type="submit">+关注</button>
                            </li>
                        </ul>
                        <ul>
                            <li><a href="#" title="陈伟霆">陈伟霆</a></li>
                            <li><a href="#" title="李易峰">李易峰</a></li>
                            <li><a href="#" title="陈伟霆">陈伟霆</a></li>
                            <li><a href="#" title="李易峰">李易峰</a></li>
                            <li><a href="#" title="陈伟霆">陈伟霆</a></li>
                        </ul>
                    </div>
                </div>
                <!--end-->
            </div>
            <!--end  right-->
            <div class="clear"></div>

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

