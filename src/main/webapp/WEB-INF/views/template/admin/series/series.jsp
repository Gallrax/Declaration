<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/1
  Time: 16:52
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
    <table id="series" class="layui-table" lay-filter="series">
    </table>
</div>
</body>
</html>
<script src="/static/tools/layui/layui.js"></script>
<script src="/static/template/common/js/jquery-1.7.2.min.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: "#series",
            url: "/series/series",
            page: true,
            cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'},
                {field: 'name', title: '名称', width: 80}
            ]],
            request: {
                pageName: 'current',
                limintName: 'size'
            },
            response: {
                statusName: 'code',
                statusCode: 200
            }
        })


    });
</script>
