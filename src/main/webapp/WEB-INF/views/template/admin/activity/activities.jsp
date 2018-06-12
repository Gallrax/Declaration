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
<div class="tableBox">
    <button class="layui-btn" data-type="add">添加</button>
    <%--<button class="layui-btn" data-type="batchUpdateStatus">批量上架</button>
    <button class="layui-btn" data-type="batchUpdateStatus">批量下架</button>--%>
</div>
<div>
    <table id="activities" class="layui-table" lay-filter="activities">
    </table>
</div>
</body>
</html>
<script src="/static/tools/layui/layui.js"></script>
<script type="text/html" id="barDemo">
    {{#  if(d.status == 0){ }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="update" data-type="-1">下架</a>
    {{#  } }}
    {{#  if(d.status == -1){ }}
    <a class="layui-btn layui-btn-xs" lay-event="update" data-type="0">上架</a>
    {{#  } }}
</script>
<script>
    var $;
    var table;
    layui.use('table', function () {
        $ = layui.$;
        table = layui.table;

        table.render({
            elem: "#activities",
            url: "/activity/activities",
            page: true,
            cols: [[ //表头
                {field: 'id', title: 'ID', fixed: 'left'},
                {field: 'name', title: '名称'},
                {field: 'content', title: '内容'},
                {field: 'place', title: '地点'},
                {field: 'hoster', title: '发起者'},
                {field: 'beginTime', title: '开始时间'},
                {field: 'endTime', title: '结束时间'},
                {field: 'tool', title: '操作', toolbar: '#barDemo'}
            ]],
            request: {
                pageName: 'current',
                limitName: 'size'
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

        table.on('tool(activities)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

            if (layEvent === 'update') { //更新状态
                var status = $(this).data('type');
                layer.confirm("确定" + (status == 0 ? "上架吗？" : "下架吗？"), function (val, index) {
                    var tempObj = new Object();
                    tempObj.id = data.id;
                    var tempObjs = new Object();
                    tempObjs[0] = tempObj;
                    updateStatus(tempObjs, status);
                });
            }
        });

        $('.tableBox .layui-btn').on('click', function () {
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
        };

    });

</script>
<script>
    function updateStatus(objs, status) {
        if (objs.length <= 0) return false;
        var tempParam = "";
        for (var i in objs) {
            tempParam += "activityIds=" + objs[i].id + "&";
        }
        $.ajax({
            url: "/activity/updateStatus?" + tempParam + "status=" + status,
            type: "post",
            success: function (data) {
                console.log(data);
                var result = $.parseJSON(data);
                if (result.code == 200) {
                    layer.msg("操作成功");
                    table.reload("activities");
                } else {
                    layer.msg("操作失败");
                }
            }
        })
    }
</script>
