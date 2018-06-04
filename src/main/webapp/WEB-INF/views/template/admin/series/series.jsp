<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
<script src="/static/tools/layui/lay/modules/laytpl.js"></script>
<script>
    var $;
    var table;
    var form;
    layui.use('table', function () {
        $ = layui.$;
        table = layui.table;
        form = layui.form;

        table.render({
            elem: "#series",
            url: "/series/series",
            page: true,
            cols: [[ //表头
                {field: 'id', title: 'ID', fixed: 'left'},
                {field: 'name', title: '名称'},
                {field: 'phone', title: '联系方式'},
                {field: 'company', title: '单位'},
                {field: 'author', title: '作者'},
                {field: 'insertTime', title: '创建时间'},
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

        table.on('tool(series)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if (layEvent === 'audit') { //查看
                layer.confirm('确定要通过审核么', function (index) {
                    console.log(data.id);
                    audit(data.id);
                });
            } else if (layEvent == 'assess') {
                assess(data);
            } else if (layEvent === 'distribute') {
                //审核通过
                distribute(data);
            }
        });
    });
</script>
<script type="text/html" id="barDemo">
    <!-- 这里同样支持 laytpl 语法，如： -->

    <%--<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>--%>

    <shiro:hasAnyRoles name="auditor">
        {{# if(d.status == 0){ }}
        <a class="layui-btn layui-btn-xs" lay-event="audit">审核通过</a>
        {{# } }}
    </shiro:hasAnyRoles>
    <shiro:hasAnyRoles name="specialist">
        <a class="layui-btn layui-btn-xs" lay-event="assess">评分</a>
    </shiro:hasAnyRoles>
    <shiro:hasAnyRoles name="manager">
        <a class="layui-btn layui-btn-xs" lay-event="distribute">分配</a>
    </shiro:hasAnyRoles>

</script>
<shiro:hasAnyRoles name="auditor">
    <script>
        function audit(seriesId) {
            $.ajax({
                url: "/series/updateStatus?seriesId=" + seriesId + "&status=1",
                type: "post",
                success: function (data) {
                    console.log(data);
                    var result = $.parseJSON(data);
                    if (result.code == 200) {
                        layer.msg("审核成功");
                        table.reload("series");
                    } else {
                        layer.msg("审核失败");
                    }
                }
            })
        }
    </script>
</shiro:hasAnyRoles>
<shiro:hasAnyRoles name="specialist">
    <script>
        function assess(data) {
            var id = data.id;
            $.ajax({
                url: "/seriesUser/" + id,
                type: "get",
                success: function (data) {
                    var result = $.parseJSON(data);
                    if (result.code == 200) {
                        layer.open({
                            type: 2,
                            area: ['50%', '50%'],
                            title: '评奖',
                            content: '/admin/seriesUser/updateSeriesUser.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                            success: function (layero, index) {
                                var body = layer.getChildFrame('body', index);
                                body.find('#seriesUserId').val(id);
                            }
                        });
                    } else {
                        layer.msg("出现异常");
                    }
                }
            })
        }
    </script>
</shiro:hasAnyRoles>
<shiro:hasAnyRoles name="manager">
    <script>
        function distribute(data) {
            var id = data.id;
            layer.open({
                type: 2,
                area: ['50%', '50%'],
                title: '分配',
                content: '/admin/seriesUser/addSeriesUser.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    console.log(body.contents());
                    $.ajax({
                        url: "/admin/user/users",
                        type: "get",
                        success: function (data) {
                            var result = $.parseJSON(data);
                            if (result.code == 200) {
                                var tempStr = "";
                                for (var i in result.data.records) {
                                    tempStr += "<input type=\"checkbox\" name=\"userIds\" title=\"" + result.data.records[i].name + "\" value=\"" + result.data.records[i].id + "\">";
                                }
                                console.log(tempStr);
                                body.find(".layui-input-block").html(tempStr);
                                form.render();
                                //无效
                                console.log(body.find(".layui-input-block").html());
                                form.render();
                            }
                        }
                    })
                }
            });
        }
    </script>
</shiro:hasAnyRoles>
