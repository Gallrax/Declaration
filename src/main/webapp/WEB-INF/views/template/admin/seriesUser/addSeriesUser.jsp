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
        <input type="hidden" name="seriesId" id="seriesId">
        <div class="layui-form-item" lay-filter="users">
            <label class="layui-form-label">专家</label>
            <div id="users" class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="*">立即提交</button>
            </div>
        </div>
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
            $.ajax({
                url: "/seriesUser/insert",
                type: "post",
                data: $("#addSeriesUser").serialize(),
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

    //父iframe调用此方法刷新form
    function reloadForm() {
        console.log("1");
        form.render();
    }
</script>
