<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/6/4
  Time: 15:36
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
        <input type="hidden" name="id" id="seriesUserId">
        <input type="hidden" name="seriesIds" id="seriesId">
        <div class="layui-form-item">
            <label class="layui-form-label">奖项名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" placeholder="请输入" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">奖项类型</label>
            <div class="layui-input-block">
                <input type="text" name="type" placeholder="请输入" lay-verify="required" autocomplete="off"
                       class="layui-input">
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
                url: "/seriesUser/update",
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
