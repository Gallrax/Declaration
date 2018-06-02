<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/1
  Time: 14:43
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
    <div>
        <button class="layui-btn layuiadmin-btn-tags" data-type="add">添加</button>
    </div>
    <table id="series" class="layui-table" lay-filter="series">
    </table>
</div>
</body>
</html>
<script src="/static/tools/layui/layui.js"></script>
<script>

    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: "#series",
            url: "/activity/activities",
            page: true,
            cols: [[ //表头
                {field: 'id', title: 'ID', fixed: 'left'},
                {field: 'name', title: '名称'},
                {field: 'content', title: '内容'},
                {field: 'place', title: '地点'},
                {field: 'hoster', title: '发起者'},
                {field: 'beginTime', title: '开始时间'},
                {field: 'endTime', title: '结束时间'}
                // {field: 'tool', title: '操作', toolbar: '#barDemo'}
            ]],
            request: {
                pageName: 'current',
                limintName: 'size'
            },
            response: {
                statusName: 'code',
                statusCode: 200
            },
            renderResponse: function (data) {
                var tempData = {};
                tempData[this.response.dataName] = data.data.records;
                tempData[this.response.countName] = data.data.total;
                tempData[this.response.statusName] = data.code;
                return tempData;
            }
        });

        table.on('tool(series)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'detail') { //查看
                console.log(data);
                //do somehing
            } else if (layEvent === 'del') { //删除
                layer.confirm('真的删除行么', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if (layEvent === 'edit') { //编辑
                //do something
                console.log(data);
                //同步更新缓存对应的值
                obj.update({
                    username: '123'
                    , title: 'xxx'
                });
            }
        });
    });

    layui.use('layer', function () {
        var $ = layui.$;

        $('.layui-btn.layuiadmin-btn-tags').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        var active = {
            add: function () {
                layer.open({
                    type: 2,
                    area: ['50%', '80%'],
                    title: '添加',
                    content: '/admin/activity/addActivity.html'
                });
            }
        }
    });
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

    <!-- 这里同样支持 laytpl 语法，如： -->
    {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  } }}
</script>