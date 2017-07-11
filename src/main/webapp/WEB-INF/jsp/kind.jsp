<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>分类页</title>
    <!--图标-->
    <link rel="icon" href="images/public/icon.png">
    <!--重置-->
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <!--icon字体-->
    <link rel="stylesheet" type="text/css" href="css/iconfont.css">

    <link rel="stylesheet" type="text/css" href="css/kind.css">
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

    <!--header-->
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
    <!--header end-->

    <!--center-->
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

            <!--中间-->
            <div class="content">
                <!--中间第一栏-->
                <div class="ct_1">
                    <div class="sdinfo">
                        <div class="kind">
                            <ul>
                                <li><a target="_blank" href="">全部</a></li>
                                <li><a target="_blank" href="">名人</a></li>
                                <li><a target="_blank" href="">兴趣</a></li>
                                <li><a target="_blank" href="">专家</a></li>
                                <li><a target="_blank" href="">机构</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!--中间第一栏end-->

                <!--内容-->
                <div class="ct_2">
                    <div class="homefeed">

                        <!--名人-->
                        <div class="l2"><ul><li><h3>名人</h3></li></ul></div>
                        <div class="WB_tab_a">
                            <div class="l31">
                                <ul class="l32">
                                    <li>明星</li>
                                </ul>
                                <ul class="l33">
                                    <li><a>内地明星</a></li>
                                    <li><a>港台明星</a></li>
                                    <li><a>欧美明星</a></li>
                                    <li><a>日韩明星</a></li>
                                    <li><a>影视明星</a></li>
                                    <li><a>相声演员</a></li>
                                </ul>
                                <ul class="l34">
                                    <li><a>歌手</a></li>
                                    <li><a>模特</a></li>
                                    <li><a>主持人</a></li>
                                    <li><a>导演</a></li>
                                    <li><a>DJ</a></li>
                                    <li><a>经纪人</a></li>
                                </ul>
                            </div>

                            <div class="lx">
                                <ul class="l32">
                                    <li>商界</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">企业家</a></li>
                                    <li><a target="_blank" href="">创投</a></li>
                                    <li><a target="_blank" href="">经济学家</a></li>
                                    <li><a target="_blank" href="">新锐CEO</a></li>
                                </ul>
                            </div>
                            <div class="lx1">
                                <ul class="l32">
                                    <li>媒体人</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">编辑</a></li>
                                    <li><a target="_blank" href="">记者</a></li>
                                    <li><a target="_blank" href="">主持人</a></li>
                                    <li><a target="_blank" href="">制片人</a></li>
                                </ul>
                            </div>
                            <div class="lx2">
                                <ul class="l32">
                                    <li>作家</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">编辑</a></li>
                                    <li><a target="_blank" href="">出版人</a></li>
                                    <li><a target="_blank" href="">青春文学</a></li>
                                    <li><a target="_blank" href="">言情</a></li>
                                    <li><a target="_blank" href="">武侠</a></li>
                                    <li><a target="_blank" href="">玄幻</a></li>
                                    <li><a target="_blank" href="">科幻</a></li>
                                    <li><a target="_blank" href="">惊悚</a></li>
                                    <li><a target="_blank" href="">纪实文学</a></li>
                                    <li><a target="_blank" href="">少儿文学</a></li>
                                    <li><a target="_blank" href="">影视文学</a></li>
                                    <li><a target="_blank" href="">网络文学</a></li>
                                    <li><a target="_blank" href="">散文</a></li>
                                    <li><a target="_blank" href="">诗歌</a></li>
                                    <li><a target="_blank" href="">寓言</a></li>
                                    <li><a target="_blank" href="">耽美</a></li>
                                    <li><a target="_blank" href="">科散</a></li>
                                    <li><a target="_blank" href="">书评</a></li>
                                </ul>

                            </div>
                            <div class="l31">
                                <ul class="l32">
                                    <li>官员</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">公安</a></li>
                                    <li><a target="_blank" href="">司法</a></li>
                                    <li><a target="_blank" href="">团委</a></li>
                                    <li><a target="_blank" href="">旅游</a></li>
                                    <li><a target="_blank" href="">交通</a></li>
                                    <li><a target="_blank" href="">医疗卫生</a></li>
                                </ul>
                                <ul class="l34">
                                    <li><a target="_blank" href="">市政</a></li>
                                    <li><a target="_blank" href="">涉外</a></li>
                                    <li><a target="_blank" href="">工商税务</a></li>
                                    <li><a target="_blank" href="">其他</a></li>
                                </ul>
                            </div>
                            <div class="lx3">
                                <ul class="l32">
                                    <li>时评</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">时评</a></li>
                                </ul>
                            </div>
                            <div class="lx4">
                                <ul class="l32">
                                    <li>猜你喜欢</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">国民老公</a></li>
                                    <li><a target="_blank" href="">国民少女</a></li>
                                    <li><a target="_blank" href="">小鲜肉</a></li>
                                    <li><a target="_blank" href="">明星萌娃</a></li>
                                    <li><a target="_blank" href="">表情包</a></li>
                                    <li><a target="_blank" href="">春晚</a></li>
                                    <li><a target="_blank" href="">太子妃</a></li>
                                </ul>
                            </div>
                        </div>
                        <!--名人end-->

                        <!--兴趣-->
                        <div class="l2"><ul><li><h3>兴趣</h3></li></ul></div>
                        <div class="xq">
                            <div class="l31">
                                <ul class="l32">
                                    <li>时尚</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">时尚名博</a></li>
                                    <li><a target="_blank" href="">时尚买手</a></li>
                                    <li><a target="_blank" href="">潮人潮牌</a></li>
                                    <li><a target="_blank" href="">街拍</a></li>
                                    <li><a target="_blank" href="">名表</a></li>
                                    <li><a target="_blank" href="">时装</a></li>
                                </ul>
                                <ul class="l34">
                                    <li><a target="_blank" href="">珠宝</a></li>
                                    <li><a target="_blank" href="">时尚首饰</a></li>
                                    <li><a target="_blank" href="">时尚杂志</a></li>
                                </ul>
                            </div>
                            <div class="lx">
                                <ul class="l32">
                                    <li>收藏</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">翡翠</a></li>
                                    <li><a target="_blank" href="">和田玉</a></li>
                                    <li><a target="_blank" href="">琥珀蜜蜡</a></li>
                                    <li><a target="_blank" href="">黄花梨</a></li>
                                    <li><a target="_blank" href="">绿松石</a></li>
                                    <li><a target="_blank" href="">文玩核桃</a></li>
                                </ul>
                            </div>
                            <div class="lx1">
                                <ul class="l32">
                                    <li>星座</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">占卜师</a></li>
                                    <li><a target="_blank" href="">运势</a></li>
                                    <li><a target="_blank" href="">星座</a></li>
                                    <li><a target="_blank" href="">周易</a></li>
                                    <li><a target="_blank" href="">风水</a></li>
                                    <li><a target="_blank" href="">相学</a></li>
                                    <li><a target="_blank" href="">血型</a></li>
                                    <li><a target="_blank" href="">塔罗牌</a></li>
                                </ul>
                            </div>
                            <div class="lx2">
                                <ul class="l32">
                                    <li>美女</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">平面模特</a></li>
                                    <li><a target="_blank" href="">时装模特</a></li>
                                    <li><a target="_blank" href="">T台模特</a></li>
                                    <li><a target="_blank" href="">影视模特</a></li>
                                    <li><a target="_blank" href="">车模</a></li>
                                    <li><a target="_blank" href="">网络模特</a></li>
                                    <li><a target="_blank" href="">showgirl</a></li>
                                    <li><a target="_blank" href="">经纪人</a></li>
                                    <li><a target="_blank" href="">校花</a></li>
                                    <li><a target="_blank" href="">网红草根</a></li>
                                    <li><a target="_blank" href="">美女图片</a></li>
                                    <li><a target="_blank" href="">帅哥图片</a></li>
                                    <li><a target="_blank" href="">美腿</a></li>
                                    <li><a target="_blank" href="">美胸</a></li>
                                </ul>

                            </div>
                            <div class="l31">
                                <ul class="l32">
                                    <li>动漫</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">动漫作者</a></li>
                                    <li><a target="_blank" href="">声优CV</a></li>
                                    <li><a target="_blank" href="">cosploy</a></li>
                                    <li><a target="_blank" href="">漫画原型</a></li>
                                    <li><a target="_blank" href="">动漫资讯</a></li>
                                    <li><a target="_blank" href="">动漫周边</a></li>
                                </ul>
                                <ul class="l34">
                                    <li><a target="_blank" href="">动漫摄影</a></li>
                                    <li><a target="_blank" href="">国产动漫</a></li>
                                    <li><a target="_blank" href="">港台动漫</a></li>
                                    <li><a target="_blank" href="">日本动漫</a></li>
                                    <li><a target="_blank" href="">欧美动漫</a></li>
                                    <li><a target="_blank" href="">宅腐动漫</a></li>
                                </ul>
                            </div>
                            <div class="lx3">
                                <ul class="l32">
                                    <li>搞笑</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">逗B</a></li>
                                    <li><a target="_blank" href="">搞笑段子</a></li>
                                    <li><a target="_blank" href="">搞笑视频</a></li>
                                    <li><a target="_blank" href="">搞笑图片</a></li>
                                    <li><a target="_blank" href="">三俗</a></li>
                                    <li><a target="_blank" href="">重口味</a></li>
                                    <li><a target="_blank" href="">新闻趣事</a></li>
                                </ul>
                            </div>
                            <div class="lx4">
                                <ul class="l32">
                                    <li>情感</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">恋爱</a></li>
                                    <li><a target="_blank" href="">性爱</a></li>
                                    <li><a target="_blank" href="">同性</a></li>
                                    <li><a target="_blank" href="">情感婚姻</a></li>
                                    <li><a target="_blank" href="">婆媳关系</a></li>
                                    <li><a target="_blank" href="">八卦杂谈</a></li>
                                    <li><a target="_blank" href="">人生感悟</a></li>
                                </ul>
                            </div>
                            <div class="lx5">
                                <ul class="l32">
                                    <li>电视剧</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">导演</a></li>
                                    <li><a target="_blank" href="">演员</a></li>
                                    <li><a target="_blank" href="">资讯</a></li>
                                    <li><a target="_blank" href="">剧评</a></li>
                                    <li><a target="_blank" href="">内地剧</a></li>
                                    <li><a target="_blank" href="">港台剧</a></li>
                                    <li><a target="_blank" href="">韩剧</a></li>
                                    <li><a target="_blank" href="">日剧</a></li>
                                    <li><a target="_blank" href="">美剧</a></li>
                                    <li><a target="_blank" href="">英剧</a></li>
                                    <li><a target="_blank" href="">泰剧</a></li>
                                    <li><a target="_blank" href="">偶像剧</a></li>
                                    <li><a target="_blank" href="">言情剧</a></li>
                                    <li><a target="_blank" href="">战争剧</a></li>
                                    <li><a target="_blank" href="">都市剧</a></li>
                                    <li><a target="_blank" href="">古装剧</a></li>
                                    <li><a target="_blank" href="">家庭剧</a></li>
                                    <li><a target="_blank" href="">字幕翻译</a></li>
                                </ul>
                            </div>
                            <div class="lx5">
                                <ul class="l32">
                                    <li>电影</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">导演</a></li>
                                    <li><a target="_blank" href="">演员</a></li>
                                    <li><a target="_blank" href="">影讯</a></li>
                                    <li><a target="_blank" href="">影评</a></li>
                                    <li><a target="_blank" href="">国产</a></li>
                                    <li><a target="_blank" href="">港台</a></li>
                                    <li><a target="_blank" href="">日韩</a></li>
                                    <li><a target="_blank" href="">欧美</a></li>
                                    <li><a target="_blank" href="">爱情</a></li>
                                    <li><a target="_blank" href="">动作</a></li>
                                    <li><a target="_blank" href="">科幻</a></li>
                                    <li><a target="_blank" href="">恐怖</a></li>
                                    <li><a target="_blank" href="">喜剧</a></li>
                                    <li><a target="_blank" href="">传记</a></li>
                                    <li><a target="_blank" href="">纪实</a></li>
                                    <li><a target="_blank" href="">微电影</a></li>
                                    <li><a target="_blank" href="">字幕翻译</a></li>
                                </ul>
                            </div>
                            <div class="lx5">
                                <ul class="l32">
                                    <li>音乐</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">作词</a></li>
                                    <li><a target="_blank" href="">作曲</a></li>
                                    <li><a target="_blank" href="">演奏家</a></li>
                                    <li><a target="_blank" href="">钢琴家</a></li>
                                    <li><a target="_blank" href="">小提琴家</a></li>
                                    <li><a target="_blank" href="">音乐资讯</a></li>
                                    <li><a target="_blank" href="">乐评</a></li>
                                    <li><a target="_blank" href="">华语流行</a></li>
                                    <li><a target="_blank" href="">港台流行</a></li>
                                    <li><a target="_blank" href="">日韩流行</a></li>
                                    <li><a target="_blank" href="">欧美流行</a></li>
                                    <li><a target="_blank" href="">美声</a></li>
                                    <li><a target="_blank" href="">古典</a></li>
                                    <li><a target="_blank" href="">乡村音乐</a></li>
                                    <li><a target="_blank" href="">摇滚</a></li>
                                    <li><a target="_blank" href="">民谣</a></li>
                                    <li><a target="_blank" href="">说唱</a></li>
                                    <li><a target="_blank" href="">爵士乐</a></li>
                                    <li><a target="_blank" href="">电子音乐</a></li>
                                    <li><a target="_blank" href="">音乐制作</a></li>
                                    <li><a target="_blank" href="">乐器</a></li>
                                </ul>
                            </div>
                            <div class="lx6">
                                <ul class="l32">
                                    <li>综艺</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">综艺主持人</a></li>
                                    <li><a target="_blank" href="">真人秀</a></li>
                                    <li><a target="_blank" href="">脱口秀</a></li>
                                    <li><a target="_blank" href="">内地综艺</a></li>
                                    <li><a target="_blank" href="">港台综艺</a></li>
                                    <li><a target="_blank" href="">日韩综艺</a></li>
                                    <li><a target="_blank" href="">欧美综艺</a></li>
                                    <li><a target="_blank" href="">播报类</a></li>
                                    <li><a target="_blank" href="">访谈类</a></li>
                                    <li><a target="_blank" href="">亲子类</a></li>
                                    <li><a target="_blank" href="">相亲类</a></li>
                                    <li><a target="_blank" href="">选秀类</a></li>
                                    <li><a target="_blank" href="">音乐类</a></li>
                                    <li><a target="_blank" href="">舞蹈类</a></li>
                                    <li><a target="_blank" href="">曲艺类</a></li>
                                    <li><a target="_blank" href="">搞笑类</a></li>
                                    <li><a target="_blank" href="">情感类</a></li>
                                    <li><a target="_blank" href="">生活类</a></li>
                                    <li><a target="_blank" href="">时尚类</a></li>
                                    <li><a target="_blank" href="">美食类</a></li>
                                    <li><a target="_blank" href="">旅游类</a></li>
                                    <li><a target="_blank" href="">纪实类</a></li>
                                    <li><a target="_blank" href="">益智类</a></li>
                                </ul>
                            </div>
                            <div class="lx7">
                                <ul class="l32">
                                    <li>游戏</li>
                                </ul>
                                <ul class="l33">
                                    <li><a target="_blank" href="">游戏选手</a></li>
                                    <li><a target="_blank" href="">游戏战队</a></li>
                                    <li><a target="_blank" href="">游戏解说</a></li>
                                    <li><a target="_blank" href="">手机游戏</a></li>
                                    <li><a target="_blank" href="">单机游戏</a></li>
                                    <li><a target="_blank" href="">网络游戏</a></li>
                                    <li><a target="_blank" href="">电视游戏</a></li>
                                    <li><a target="_blank" href="">桌游</a></li>
                                    <li><a target="_blank" href="">电子竞技</a></li>
                                    <li><a target="_blank" href="">棋牌游戏</a></li>
                                    <li><a target="_blank" href="">Dota</a></li>
                                    <li><a target="_blank" href="">LOL</a></li>
                                    <li><a target="_blank" href="">魔兽</a></li>
                                    <li><a target="_blank" href="">炉石传说</a></li>
                                    <li><a target="_blank" href="">星际争霸</a></li>
                                    <li><a target="_blank" href="">游戏应用</a></li>
                                    <li><a target="_blank" href="">游戏公司</a></li>
                                </ul>
                            </div>
                        </div>
                        <!--兴趣end-->
                    </div>
                </div>
                <!--内容end-->
            </div>
            <!--中间end-->


            <!--右边-->
            <div class="contain-r">

                <!--右第一栏-->
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
                <!--右第一栏end-->

                <!--右第二栏-->
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
                <!--右第二栏end-->

                <!--右第三栏-->
                <div class="wc2">
                    <ul>
                        <li class="wc21"><img src="images/listimages/gg.jpg"></li>
                        <li class="wc22"><a target="_blank" href="">广告</a></li>
                    </ul>
                </div>
                <!--右第三栏end-->

                <!--右第四栏-->
                <div class="wc3">
                    <ul>
                        <li><h3>好友关注状态</h3></li>
                    </ul>
                </div>
                <div class="wc4">
                    <ul>
                        <li class="cc31"><img src="images/listimages/touxiang/t3.jpg"></li>
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
                        <li class="cc31"><img src="images/listimages/touxiang/t4.jpg"></li>
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
                <!--右第四栏end-->

                <!--右第五栏-->
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
                <!--右第五栏end-->
            </div>
            <div style="clear: both"></div>
            <!--右边end-->
        </div>
    </div>
    <!--center end-->

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
</div>
</body>
</html>