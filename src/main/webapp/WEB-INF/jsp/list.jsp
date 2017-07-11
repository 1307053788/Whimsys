<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>列表页</title>
    <!--图标-->
    <link rel="icon" href="images/public/icon.png">
    <!--重置-->
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <!--icon字体-->
    <link rel="stylesheet" type="text/css" href="css/iconfont.css">

    <link rel="stylesheet" type="text/css" href="css/list.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    <!--主页jquery-->
    <script type="text/javascript" src="jquery/jquery-3.1.0.min.js"></script>
    <!--header-->
    <script type="text/javascript" src="js/header.js"></script>

    <script type="text/javascript" src="js/list.js"></script>
</head>
<body>
<div class="WB_miniblog">
    <!--头部-->
    <div class="header">
        <div class="head ftr">
            <div id="header">
                <div class="h_index">
                    <a target="_self" href="main.html"><img src="images/public/logo.png"></a>
                </div>
                <div class="h_form">
                    <input id="form-text" name="form-text" type="text" placeholder="大家都在搜:爱生活，爱超哥" class="form-text">
                    <i class="iconfont" id="search"title="搜索" >&#xe613;</i>
                </div>
                <div class="h_menu">
                    <ul>
                        <li><h2><a rel=""><i class="iconfont">&#xe623;</i>分享</a></h2></li>
                        <li><h2><a href="register.html"><i class="iconfont">&#xe60c;</i>注册</a></h2></li>
                        <li><h2><a href="login.html"><i class="iconfont">&#xe62a;</i>登陆</a></h2></li>
                        <li><h2><a href="index.html"><i class="iconfont">&#xe62b;</i>我的主页</a></h2></li>
                        <li><h2><a target="_self" href="main.html"><i class="iconfont">&#xe60b;</i>首页</a></h2></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--头部end-->

    <!--中间-->
    <div class="container">
        <div class="contain ftr" style="position: relative">
            <!--左边-->
            <div class="navigation nav_1">
                <div class="l1">
                    <ul>
                        <li><a><h3>热门微博</h3></a></li>
                        <li><a><h3>微话题</h3></a></li>
                        <li><a><h3>找人</h3></a></li>
                        <li><a><h3>电影</h3></a></li>
                        <li><a><h3>听歌</h3></a></li>
                        <li><a><h3>股票</h3></a></li>
                        <li><a><h3>播客</h3></a></li>
                        <li><a><h3>视频</h3></a></li>
                        <li><a><h3>旅游</h3></a></li>
                        <li><a><h3>购物</h3></a></li>
                        <li><a><h3>直播</h3></a></li>
                        <li><a><h3>新闻</h3></a></li>
                    </ul>
                </div>
            </div>
            <!--左边end-->

            <!--center-->
            <div class="content">
                <!--第一栏-->
                <div class="ct_1">
                    <div class="sdinfo">
                            <div class="kind">
                                <ul>
                                    <li><a>首页</a></li>
                                    <li><a>24H热门</a></li>
                                    <li><a>推荐关注</a></li>
                                    <li><a>好友关注</a></li>
                                    <li><a>明星</a></li>
                                    <li><a>商界</a></li>
                                    <li><a>媒体精英</a></li>
                                    <li><a>作家</a></li>
                                    <li><a>更多</a></li>
                                </ul>
                            </div>
                    </div>
                </div>
                <!--第一栏end-->

                <!--内容-->
                <div class="ct_2">
                    <div class="homefeed">
                        <!--内容第一栏-->
                        <div class="l2"><ul><li><h3>24小时热门人物</h3></li></ul></div>
                        <div class="WB_tab_a">
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t1.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                                    <li>胡子一刮[傻眼] 又是一个新男友[色]</li>
                                    <li>热门话题人物:美梦成真，瑜你同行</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>

                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t2.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li class=><a target="_blank" href="">实习医生格蕾</a><img src="images/listimages/V.jpg"></li>
                                    <li class=>之前的链接失效了 大家尽快下载</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t3.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">胡夏</a><img src="images/listimages/V.jpg"></li>
                                    <li>新歌必定燎原～[haha]</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t4.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">于建嵘</a><img src="images/listimages/V.jpg"></li>
                                    <li>兄弟啊，你这样做</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                        </div>
                        <div class="l3">
                            <ul>
                                <li><a target="_blank" href="">查看更多 ></a></li>
                            </ul>
                        </div>
                        <!--内容第一栏end-->

                        <!--list-->

                        <!--内容第二栏-->
                        <div class="l2"><ul><li><h3>明星</h3></li></ul></div>
                        <div class="WB_tab_a">
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t1.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                                    <li>胡子一刮[傻眼] 又是一个新男友[色]</li>
                                    <li>热门话题人物:美梦成真，瑜你同行</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>

                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t2.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li class=><a target="_blank" href="">实习医生格蕾</a><img src="images/listimages/V.jpg"></li>
                                    <li class=>之前的链接失效了 大家尽快下载</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t3.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">胡夏</a><img src="images/listimages/V.jpg"></li>
                                    <li>新歌必定燎原～[haha]</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t4.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">于建嵘</a><img src="images/listimages/V.jpg"></li>
                                    <li>兄弟啊，你这样做</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                        </div>
                        <div class="l31">
                            <ul class="l32">
                                <li>热门标签</li>
                            </ul>
                            <ul class="l33">
                                <li><a target="_blank" href="">内地明星</a></li>
                                <li><a target="_blank" href="">港台明星</a></li>
                                <li><a target="_blank" href="">欧美明星</a></li>
                                <li><a target="_blank" href="">日韩明星</a></li>
                                <li><a target="_blank" href="">影视明星</a></li>
                                <li><a target="_blank" href="">相声演员</a></li>
                            </ul>
                            <ul class="l34">
                                <li><a target="_blank" href="">歌手</a></li>
                                <li><a target="_blank" href="">模特</a></li>
                                <li><a target="_blank" href="">主持人</a></li>
                                <li><a target="_blank" href="">导演</a></li>
                                <li><a target="_blank" href="">DJ</a></li>
                                <li><a target="_blank" href="">经纪人</a></li>
                            </ul>
                        </div>
                        <div class="l3">
                            <ul>
                                <li><a target="_blank" href="">查看更多 ></a></li>
                            </ul>
                        </div>
                        <!--内容第二栏end-->

                        <!--内容第三栏-->
                        <div class="l2"><ul><li><h3>商界</h3></li></ul></div>
                        <div class="WB_tab_a">
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t1.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                                    <li>胡子一刮[傻眼] 又是一个新男友[色]</li>
                                    <li>热门话题人物:美梦成真，瑜你同行</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>

                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t2.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li class=><a target="_blank" href="">实习医生格蕾</a><img src="images/listimages/V.jpg"></li>
                                    <li class=>之前的链接失效了 大家尽快下载</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t3.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">胡夏</a><img src="images/listimages/V.jpg"></li>
                                    <li>新歌必定燎原～[haha]</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t4.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">于建嵘</a><img src="images/listimages/V.jpg"></li>
                                    <li>兄弟啊，你这样做</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                        </div>
                        <div class="l31">
                            <ul class="l32">
                                <li>热门标签</li>
                            </ul>
                            <ul class="l33">
                                <li><a target="_blank" href="">企业家</a></li>
                                <li><a target="_blank" href="">创投</a></li>
                                <li><a target="_blank" href="">经济学家</a></li>
                                <li><a target="_blank" href="">新锐CEO</a></li>
                            </ul>
                        </div>
                        <div class="l3">
                            <ul>
                                <li><a target="_blank" href="">查看更多 ></a></li>
                            </ul>
                        </div>
                        <!--内容第三栏end-->

                        <!--内容第四栏-->
                        <div class="l2"><ul><li><h3>作家</h3></li></ul></div>
                        <div class="WB_tab_a">
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t1.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                                    <li>胡子一刮[傻眼] 又是一个新男友[色]</li>
                                    <li>热门话题人物:美梦成真，瑜你同行</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>

                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t2.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li class=><a target="_blank" href="">实习医生格蕾</a><img src="images/listimages/V.jpg"></li>
                                    <li class=>之前的链接失效了 大家尽快下载</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t3.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">胡夏</a><img src="images/listimages/V.jpg"></li>
                                    <li>新歌必定燎原～[haha]</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t4.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">于建嵘</a><img src="images/listimages/V.jpg"></li>
                                    <li>兄弟啊，你这样做</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                        </div>
                        <div class="l31">
                            <ul class="l32">
                                <li>热门标签</li>
                            </ul>
                            <ul class="l33">
                                <li><a target="_blank" href="">编辑</a></li>
                                <li><a target="_blank" href="">出版人</a></li>
                                <li><a target="_blank" href="">青春文学</a></li>
                                <li><a target="_blank" href="">言情</a></li>
                                <li><a target="_blank" href="">武侠</a></li>
                                <li><a target="_blank" href="">玄幻</a></li>
                            </ul>
                            <ul class="l34">
                                <li><a target="_blank" href="">科幻</a></li>
                                <li><a target="_blank" href="">惊悚</a></li>
                                <li><a target="_blank" href="">纪实文学</a></li>
                                <li><a target="_blank" href="">少儿文学</a></li>
                                <li><a target="_blank" href="">影视文学</a></li>
                                <li><a target="_blank" href="">网络文学</a></li>
                            </ul>
                        </div>
                        <div class="l3">
                            <ul>
                                <li><a target="_blank" href="">查看更多 ></a></li>
                            </ul>
                        </div>
                        <!--内容第四栏end-->

                        <!--内容第五栏-->
                        <div class="l2"><ul><li><h3>时尚</h3></li></ul></div>
                        <div class="WB_tab_a">
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t1.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                                    <li>胡子一刮[傻眼] 又是一个新男友[色]</li>
                                    <li>热门话题人物:美梦成真，瑜你同行</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>

                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t2.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li class=><a target="_blank" href="">实习医生格蕾</a><img src="images/listimages/V.jpg"></li>
                                    <li class=>之前的链接失效了 大家尽快下载</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t3.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">胡夏</a><img src="images/listimages/V.jpg"></li>
                                    <li>新歌必定燎原～[haha]</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t4.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">于建嵘</a><img src="images/listimages/V.jpg"></li>
                                    <li>兄弟啊，你这样做</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                        </div>
                        <div class="l31">
                            <ul class="l32">
                                <li>热门标签</li>
                            </ul>
                            <ul class="l33">
                                <li><a target="_blank" href="">编辑</a></li>
                                <li><a target="_blank" href="">出版人</a></li>
                                <li><a target="_blank" href="">青春文学</a></li>
                                <li><a target="_blank" href="">言情</a></li>
                                <li><a target="_blank" href="">武侠</a></li>
                                <li><a target="_blank" href="">玄幻</a></li>
                            </ul>
                            <ul class="l34">
                                <li><a target="_blank" href="">科幻</a></li>
                                <li><a target="_blank" href="">惊悚</a></li>
                                <li><a target="_blank" href="">纪实文学</a></li>
                                <li><a target="_blank" href="">少儿文学</a></li>
                                <li><a target="_blank" href="">影视文学</a></li>
                                <li><a target="_blank" href="">网络文学</a></li>
                            </ul>
                        </div>
                        <div class="l3">
                            <ul>
                                <li><a target="_blank" href="">查看更多 ></a></li>
                            </ul>
                        </div>
                        <!--内容第五栏end-->

                        <!--内容第六栏-->
                        <div class="l2"><ul><li><h3>美女</h3></li></ul></div>
                        <div class="WB_tab_a">
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t1.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                                    <li>胡子一刮[傻眼] 又是一个新男友[色]</li>
                                    <li>热门话题人物:美梦成真，瑜你同行</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>

                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t2.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li class=><a target="_blank" href="">实习医生格蕾</a><img src="images/listimages/V.jpg"></li>
                                    <li class=>之前的链接失效了 大家尽快下载</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t3.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">胡夏</a><img src="images/listimages/V.jpg"></li>
                                    <li>新歌必定燎原～[haha]</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t4.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">于建嵘</a><img src="images/listimages/V.jpg"></li>
                                    <li>兄弟啊，你这样做</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                        </div>
                        <div class="l31">
                            <ul class="l32">
                                <li>热门标签</li>
                            </ul>
                            <ul class="l33">
                                <li><a target="_blank" href="">编辑</a></li>
                                <li><a target="_blank" href="">出版人</a></li>
                                <li><a target="_blank" href="">青春文学</a></li>
                                <li><a target="_blank" href="">言情</a></li>
                                <li><a target="_blank" href="">武侠</a></li>
                                <li><a target="_blank" href="">玄幻</a></li>
                            </ul>
                            <ul class="l34">
                                <li><a target="_blank" href="">科幻</a></li>
                                <li><a target="_blank" href="">惊悚</a></li>
                                <li><a target="_blank" href="">纪实文学</a></li>
                                <li><a target="_blank" href="">少儿文学</a></li>
                                <li><a target="_blank" href="">影视文学</a></li>
                                <li><a target="_blank" href="">网络文学</a></li>
                            </ul>
                        </div>
                        <div class="l3">
                            <ul>
                                <li><a target="_blank" href="">查看更多 ></a></li>
                            </ul>
                        </div>
                        <!--内容第六栏end-->

                        <!--内容第七栏-->
                        <div class="l2"><ul><li><h3>美妆</h3></li></ul></div>
                        <div class="WB_tab_a">
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t1.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                                    <li>胡子一刮[傻眼] 又是一个新男友[色]</li>
                                    <li>热门话题人物:美梦成真，瑜你同行</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>

                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t2.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li class=><a target="_blank" href="">实习医生格蕾</a><img src="images/listimages/V.jpg"></li>
                                    <li class=>之前的链接失效了 大家尽快下载</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t3.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">胡夏</a><img src="images/listimages/V.jpg"></li>
                                    <li>新歌必定燎原～[haha]</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t4.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">于建嵘</a><img src="images/listimages/V.jpg"></li>
                                    <li>兄弟啊，你这样做</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                        </div>
                        <div class="l31">
                            <ul class="l32">
                                <li>热门标签</li>
                            </ul>
                            <ul class="l33">
                                <li><a target="_blank" href="">编辑</a></li>
                                <li><a target="_blank" href="">出版人</a></li>
                                <li><a target="_blank" href="">青春文学</a></li>
                                <li><a target="_blank" href="">言情</a></li>
                                <li><a target="_blank" href="">武侠</a></li>
                                <li><a target="_blank" href="">玄幻</a></li>
                            </ul>
                            <ul class="l34">
                                <li><a target="_blank" href="">科幻</a></li>
                                <li><a target="_blank" href="">惊悚</a></li>
                                <li><a target="_blank" href="">纪实文学</a></li>
                                <li><a target="_blank" href="">少儿文学</a></li>
                                <li><a target="_blank" href="">影视文学</a></li>
                                <li><a target="_blank" href="">网络文学</a></li>
                            </ul>
                        </div>
                        <div class="l3">
                            <ul>
                                <li><a target="_blank" href="">查看更多 ></a></li>
                            </ul>
                        </div>
                        <!--内容第七栏end-->

                        <!--内容第八栏-->
                        <div class="l2"><ul><li><h3>作家</h3></li></ul></div>
                        <div class="WB_tab_a">
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t1.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                                    <li>胡子一刮[傻眼] 又是一个新男友[色]</li>
                                    <li>热门话题人物:美梦成真，瑜你同行</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>

                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t2.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li class=><a target="_blank" href="">实习医生格蕾</a><img src="images/listimages/V.jpg"></li>
                                    <li class=>之前的链接失效了 大家尽快下载</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t3.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">胡夏</a><img src="images/listimages/V.jpg"></li>
                                    <li>新歌必定燎原～[haha]</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                            <div class="wb">
                                <ul class="wb_a">
                                    <li class="l21"><img src="images/listimages/touxiang/t4.jpg"></li>
                                </ul>
                                <ul class="wb_b">
                                    <li><a target="_blank" href="">于建嵘</a><img src="images/listimages/V.jpg"></li>
                                    <li>兄弟啊，你这样做</li>
                                    <li>24小时热门搜索</li>
                                    <li class="l22"><button class="44" type="submit">+关注</button></li>
                                </ul>
                            </div>
                        </div>
                        <div class="l31">
                            <ul class="l32">
                                <li>热门标签</li>
                            </ul>
                            <ul class="l33">
                                <li><a target="_blank" href="">编辑</a></li>
                                <li><a target="_blank" href="">出版人</a></li>
                                <li><a target="_blank" href="">青春文学</a></li>
                                <li><a target="_blank" href="">言情</a></li>
                                <li><a target="_blank" href="">武侠</a></li>
                                <li><a target="_blank" href="">玄幻</a></li>
                            </ul>
                            <ul class="l34">
                                <li><a target="_blank" href="">科幻</a></li>
                                <li><a target="_blank" href="">惊悚</a></li>
                                <li><a target="_blank" href="">纪实文学</a></li>
                                <li><a target="_blank" href="">少儿文学</a></li>
                                <li><a target="_blank" href="">影视文学</a></li>
                                <li><a target="_blank" href="">网络文学</a></li>
                            </ul>
                        </div>
                        <div class="l3">
                            <ul>
                                <li><a target="_blank" href="">查看更多 ></a></li>
                            </ul>
                        </div>
                        <!--内容第八栏end-->
                    </div>
                </div>
                <!--内容end-->
            </div>
            <!--center end-->

            <!--右边-->
            <div class="contain-r">
                <!--右第一栏-->
                <div class="cc">
                    <div class="cc1">
                        <ul>
                            <li><a href="kind.html"><img src="images/listimages/bq.png">标签导航页</a></li>
                            <li class="cc11"> > </li>
                        </ul>
                    </div>
                </div>
                <!--右第一栏end-->

                <!--右第二栏-->
                <div class="cc2"><ul><li><h1>推荐关注</h1></li></ul></div>
                <div class="cc3">
                    <ul>
                        <li class="cc31"><img src="images/listimages/touxiang/t1.jpg"></li>
                    </ul>
                    <ul>
                            <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                            <li>胡子一刮[傻眼]</li>
                            <li>美梦成真，瑜你同行</li>
                    </ul>
                    <ul>
                        <li class="cc32"><button class="44" type="submit">+关注</button></li>
                    </ul>
                    <ul>
                        <li class="cc31"><img src="images/listimages/touxiang/t2.jpg"></li>
                    </ul>
                    <ul>
                        <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                        <li>胡子一刮[傻眼]</li>
                        <li>美梦成真，瑜你同行</li>
                    </ul>
                    <ul>
                        <li class="cc32"><button class="44" type="submit">+关注</button></li>
                    </ul>
                </div>
                <div class="cc4">
                    <ul>
                        <li><a target="_blank" href="">查看更多 ></a></li>
                    </ul>
                </div>
                <!--右第二栏end-->

                <!--右第三栏-->
                <div class="WB_cardwrap">
                    <ul>
                        <li><h3>热门话题<span>换一换</span></h3></li>
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
                        <li class="wc1"><a>查看更多 ></a></li>
                    </ul>
                </div>
                <!--右第三栏end-->

                <!--右第四栏-->
                <div class="wc2">
                    <ul>
                        <li class="wc21"><img src="images/listimages/gg.jpg"></li>
                        <li class="wc22"><a target="_blank" href="">广告</a></li>
                    </ul>
                </div>
                <!--右第四栏end-->

                <!--右第五栏-->
                <div class="wc3">
                    <ul>
                        <li><h3>好友关注状态</h3></li>
                    </ul>
                </div>
                <div class="wc4">
                    <ul>
                        <li class="cc31"><img src="images/listimages/touxiang/t7.jpg"></li>
                    </ul>
                    <ul>
                        <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                        <li>胡子一刮[傻眼]</li>
                        <li>美梦成真，瑜你同行</li>
                    </ul>
                    <ul>
                        <li class="cc32"><button class="44" type="submit">+关注</button></li>
                    </ul>
                    <ul>
                        <li class="cc31"><img src="images/listimages/touxiang/t5.jpg"></li>
                    </ul>
                    <ul>
                        <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                        <li>胡子一刮[傻眼]</li>
                        <li>美梦成真，瑜你同行</li>
                    </ul>
                    <ul>
                        <li class="cc32"><button class="44" type="submit">+关注</button></li>
                    </ul>
                    <ul>
                        <li class="cc31"><img src="images/listimages/touxiang/t6.jpg"></li>
                    </ul>
                    <ul>
                        <li><a target="_blank" href="">Johnny黄景瑜</a><img src="images/listimages/V.jpg"></li>
                        <li>胡子一刮[傻眼]</li>
                        <li>美梦成真，瑜你同行</li>
                    </ul>
                    <ul>
                        <li class="cc32"><button class="44" type="submit">+关注</button></li>
                    </ul>
                </div>
                <div class="cc4">
                    <ul>
                        <li><a target="_blank" href="">查看更多 ></a></li>
                    </ul>
                </div>
                <!--右第五栏end-->

                <!--右第六栏-->
                <div class="wc3">
                    <ul>
                        <li><h3>奇思妙享榜单</h3></li>
                    </ul>
                </div>
                <div class="wc6">
                    <div class="wc61">
                        <ul>
                            <li class="wc63"><a target="_blank" href=""><img src="images/listimages/tb1.png">&nbsp;&nbsp;垂直V影响力榜</a></li>
                            <li class="wc62"> > </li>
                        </ul>
                        <ul>
                            <li class="wc63"><a target="_blank" href=""><img src="images/listimages/tb2.png">&nbsp;&nbsp;人气V影响力榜</a></li>
                            <li class="wc62"> > </li>
                        </ul>
                        <ul>
                            <li class="wc63"><a target="_blank" href=""><img src="images/listimages/tb3.png">&nbsp;&nbsp;媒体势力榜</a></li>
                            <li class="wc62"> > </li>
                        </ul>
                        <ul>
                            <li class="wc63"><a target="_blank" href=""><img src="images/listimages/tb4.png">&nbsp;&nbsp;政务指数榜</a></li>
                            <li class="wc62"> > </li>
                        </ul>
                        <ul>
                            <li class="wc63"><a target="_blank" href=""><img src="images/listimages/tb5.png">&nbsp;&nbsp;全部榜单</a></li>
                            <li class="wc62"> > </li>
                        </ul>
                    </div>
                </div>
                <!--右第六栏end-->

                <!--右第七栏-->
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
                <!--右第七栏end-->
            </div>
            <div style="clear: both"></div>
            <!--右边end-->
        </div>
    </div>
    <!--中间end-->

    <!--底部-->
    <div class="clr"></div>
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
    <div class="W_gotop">
        <em class="W_icon"></em>
    </div>
    <div class="W_gotop">
        <em class="W_icon"></em>
    </div>
</div>
</body>
</html>