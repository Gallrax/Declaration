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
                    <a href="javascript:;">后台首页1</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-url="page/main.html">A</a></dd>
                        <dd><a href="javascript:;" data-url="page/main.html">B</a></dd>
                        <dd><a href="javascript:;" data-url="page/main.html">C</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;" data-url="page/main.html">后台首页2</a>
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
                </li>
            </ul>
        </div>
    </div>

    <!-- 右侧tab选项卡和内容 -->
    <div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
        <div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab" lay-allowclose="true">
            <ul class="layui-tab-title">  <!-- tab选项卡标题 -->
                <li class="layui-this" lay-id="1">Aa</li>
                <li lay-id="2">Bb</li>
                <li lay-id="3">Cc</li>
            </ul>
            <div class="layui-tab-content" style="min-height: 150px; padding: 5px 0 0 0;">  <!-- tab选项卡内容 -->
                <div class="layui-tab-item layui-show">
                    <iframe src="/admin/login.html" width="100%" height="100%"></iframe>
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
                console.log("-");
                element.tabAdd('demo', {
                    title: 'new tab',
                    content: 'new tab content',
                }).call(elem);
                element.tabChange('demo', 1);
            }
        });

        /*$(".layui-nav-child a").click(function (e) {
            console.log(e);
            var url = $(this).attr("data-url");
            console.log(url);
        });*/
    });

</script>