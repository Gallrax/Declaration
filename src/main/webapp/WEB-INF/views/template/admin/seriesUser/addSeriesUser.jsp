<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4 0004
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/tools/layui/css/layui.css" media="all"/>
</head>
<body class="layui-layout-body">
<div class="layui-form-item">
    <form id="addSeriesUser" class="layui-form" style="width: 70%">
        <%--<div class="layui-form-item">
            <label class="layui-form-label">输入框</label>
            <div class="layui-input-block">
                <input type="text" name="id" id="seriesUserId" class="layui-input">
            </div>
        </div>--%>
        <div class="layui-form-item">
            <label class="layui-form-label">专家</label>
            <div class="layui-input-block">
                <input type="checkbox" name="userIds" title="写作" checked="">
                <input type="checkbox" name="userIds" title="阅读">
                <input type="checkbox" name="userIds" title="游戏">
            </div>
        </div>
            <input type="button" title="刷新" onclick="reloadForm()"/>
        <%--<input type="checkbox" name="写作" title="写作">
        <input type="checkbox" name="写作" title="写作">
        <input type="checkbox" name="写作" title="写作">
        <input type="checkbox" name="写作" title="写作">--%>
    </form>
</div>
</body>
</html>
<script src="/static/tools/layui/layui.js"></script>
<script>

    var $;
    var form;
    layui.use('form', function () {
        $ = layui.$;
        form = layui.form;

        form.on('submit(*)', function (data) {
            console.log(data);
            $.ajax({
                url: "/seriesUser/insert",
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

    function reloadForm() {
        console.log($(".layui-input-block").html());
        form.render();
        console.log($(".layui-input-block").html());
    }
</script>
