<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/26
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/tools/layui/css/layui.css" media="all"/>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">layui 后台布局</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退出</a></li>
        </ul>
    </div>

    <!-- 左侧导航 -->
    <div class="layui-side layui-bg-black">
        <div class="navBar layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="tempNav">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">后台首页</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="/admin/activity/activities.html">活动管理</a></dd>
                        <dd><a href="javascript:;" data-url="/admin/series/series.html">系列管理</a></dd>
                        <dd><a href="javascript:;" data-url="/admin/index.html">资源管理</a></dd>
                    </dl>
                </li>
                <%--<li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;" data-url="/admin/index.html">后台首页2</a>
                    <dl class="layui-nav-child">
                        <dd><a>A</a></dd>
                        <dd><a>B</a></dd>
                        <dd><a>C</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-url="page/main.html">后台首页3</a>
                    <dl class="layui-nav-child">
                        <dd><a>A</a></dd>
                        <dd><a>B</a></dd>
                        <dd><a>C</a></dd>
                    </dl>
                </li>--%>
            </ul>
        </div>
    </div>

    <!-- 右侧tab选项卡和内容 -->
    <div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
        <div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab" lay-allowclose="true">
            <%--因初学阶段，没有学习多iframe，暂只使用一个iframe --%>
            <%--<ul class="layui-tab-title">  <!-- tab选项卡标题 -->
                <li class="layui-this" lay-id="1">Aa</li>
            </ul>--%>
            <div class="layui-tab-content" style="min-height: 150px; padding: 5px 0 0 0;">  <!-- tab选项卡内容 -->
                <div class="layui-tab-item layui-show">
                    <iframe id="tempIframe" src="/admin/login.html" width="100%" height="100%"></iframe>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
</body>
</html>
<script src="/static/tools/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element'], function () {
        var $ = layui.jquery;
        var element = layui.element;

        //监听导航点击
        element.on('nav(tempNav)', function (elem) {
            var url = (elem).attr("data-url");
            console.log(url);
            if (url != null) {
                $("#tempIframe").attr("src", url);
            }
        });

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        //触发事件
        var active = {
            tabAdd: function(){
                //新增一个Tab项
                element.tabAdd('demo', {
                    title: '新选项'+ (Math.random()*1000|0) //用于演示
                    ,content: '内容'+ (Math.random()*1000|0)
                    ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                })
                console.log("-");
            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('demo', '1'); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('demo', '2'); //切换到：用户管理
            }
        };

    });

</script>