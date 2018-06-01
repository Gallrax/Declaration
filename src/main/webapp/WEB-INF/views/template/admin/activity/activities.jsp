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
    <table id="activities" class="layui-table" lay-filter="activities">
        <thead>
        <tr>
            <th lay-data="{field:'id'}">id</th>
            <th lay-data="{field:'name'}">name</th>
            <th lay-data="{field:'right', toolbar: '#barDemo'}">操作</th>
        </tr>
        </thead>
        <tbody id="tempTbody">
        </tbody>
    </table>
    <div id="page">

    </div>
</div>
</body>
</html>
<script src="/static/tools/layui/layui.js"></script>
<script src="/static/template/common/js/jquery-1.7.2.min.js"></script>
<script>

    var tempJudge = 0;

    $(function () {
        //手动填充数据方式
        getActivity(1, 3);
    });

    function getActivity(pageIndex, pageSize) {
        $.ajax({
            url: "/series/series?current=" + pageIndex + "&size=" + pageSize + "&activityId=1",
            type: "get",
            success: function (data) {
                var result = $.parseJSON(data);
                if (result.code == 200) {
                    var activities = result.data.records;
                    var tempStr = "";
                    for (var i in activities) {
                        tempStr += "<tr><td>" + activities[i].id + "</td><td>" + activities[i].name + "</td></tr>";
                    }
                    $("#tempTbody").html(tempStr);
                    initTablePage(result);
                    initTableTool();
                }
            }
        })
    }

    function initTablePage(result) {
        if (tempJudge == 0) {
            tempJudge++;
            layui.use('laypage', function () {
                var laypage = layui.laypage;
                laypage.render({
                    elem: 'page',
                    limit: result.data.size,
                    curr: result.data.current,
                    count: result.data.total,
                    jump: function (obj, first) {
                        getActivity(obj.curr, obj.limit);
                    }
                })
            });
        }
    }

    function initTableTool() {
        layui.use('table', function () {
            var table = layui.table;
            table.init('activities');
            //监听工具条
            table.on('tool(activities)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if (layEvent === 'detail') { //查看
                    //do somehing
                } else if (layEvent === 'del') { //删除
                    layer.confirm('真的删除行么', function (index) {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                    });
                } else if (layEvent === 'edit') { //编辑
                    //do something
                }
            });
        });
    }

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