<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/26
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/tools/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/static/template/admin/css/login.css" media="all"/>
</head>
<body>
<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="1080" data-width="1920" height="1080" width="1920">
    <source src="/static/template/admin/video/login.mp4" type="video/mp4">
</video>
<div class="video_mask"></div>
<div class="login">
    <h1>运营管理平台登录</h1>
    <form class="layui-form">
        <div class="layui-form-item">
            <input class="layui-input" name="account" placeholder="用户名" lay-verify="required" type="text"
                   autocomplete="off" value="admin">
        </div>
        <div class="layui-form-item">
            <input class="layui-input" name="password" placeholder="密码" lay-verify="required" type="password"
                   autocomplete="off" value="123456">
        </div>
        <div class="layui-form-item form_code">
            <input class="layui-input" name="captchaValue" placeholder="验证码" lay-verify="required|code" type="text"
                   autocomplete="off">
            <div class="code">
                <img src="../../images/loading.gif" id="captchaImg" alt="点击刷新验证码" width="116" height="36"/>
            </div>
            <input type="hidden" name="captchaId" id="captchaId" value="0"/>
        </div>
        <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
    </form>
</div>
<%--<div class="login">
    <h1>运营管理平台登录</h1>
    <form class="layui-form">
        <div class="layui-form-item">
            <input class="layui-input" name="username" placeholder="用户名" lay-verify="required" type="text"
                   autocomplete="off" value="admin">
        </div>
        <div class="layui-form-item">
            <input class="layui-input" name="password" placeholder="密码" lay-verify="required" type="password"
                   autocomplete="off" value="123456">
        </div>
        &lt;%&ndash;<div class="layui-form-item form_code">
            <input class="layui-input" name="captchaValue" placeholder="验证码" lay-verify="required|code" type="text"
                   autocomplete="off">
            <div class="code">
                <img src="../../images/loading.gif" id="captchaImg" alt="点击刷新验证码" width="116" height="36"/>
            </div>
            <input type="hidden" name="captchaId" id="captchaId" value="0"/>
        </div>&ndash;%&gt;
        <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
    </form>
</div>--%>
</body>
</html>
<script type="text/javascript" src="/static/tools/layui/layui.js"></script>
<script>
    layui.use('form', function () {
        var $ = layui.jquery;
        var form = layui.form;
        form.on('submit(login)', function(data){
            console.log(data.field);
            $.ajax({
                url: "/admin/user/login",
                data: data.field,
                type: "post",
                success: function (data) {
                    var result = $.parseJSON(data);
                    if (result.code == 200) {
                        location.href = "/admin/index.html";
                    } else {
                        layer.msg("登录失败");
                    }
                }

            });
            return false;
        });
    });
</script>
