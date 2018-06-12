<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/2
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/tools/layui/css/layui.css" media="all"/>
</head>
<body class="layui-layout-body">
<div>
    <form class="layui-form" style="width: 70%">
        <input type="hidden" name="categoryId" value="6">
        <div class="layui-form-item">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" placeholder="请输入" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地点</label>
            <div class="layui-input-block">
                <input type="text" name="place" placeholder="请输入" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">发起</label>
            <div class="layui-input-block">
                <input type="text" name="hoster" placeholder="请输入" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">开始时间</label>
            <div class="layui-input-block">
                <input type="date" name="beginTime" lay-verify="required" class="layui-date">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-block">
                <input type="date" name="endTime" lay-verify="required" class="layui-date">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">是否免审核</label>
            <div class="layui-input-block">
                <input type="radio" name="isVerify" value="1" title="是">
                <input type="radio" name="isVerify" value="0" title="否" checked>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">请填写描述</label>
            <div class="layui-input-block">
                <textarea name="content" placeholder="请输入内容" lay-verify="required" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script src="/static/tools/layui/layui.js"></script>
<script>
    layui.use('form', function () {
        var $ = layui.$;
        var form = layui.form;

        form.on('submit(*)', function (data) {
            console.log(data);
            $.ajax({
                url: "/activity/saveActivity",
                type: "post",
                data: data.field,
                success: function (data) {
                    var result = $.parseJSON(data);
                    if (result.code == 200) {
                        layer.alert("发布成功");
                        layer.closeAll('iframe');
                        parent.location.reload();
                    } else {
                        layer.alert("发布失败")
                    }
                }
            });
            return false;
        });

    });
</script>