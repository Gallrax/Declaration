<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/1
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/tools/layui/css/layui.css" media="all"/>
</head>
<body class="layui-layout-body">
<div class="tableBox">
    <%-- 暂时隐藏搜索 --%>
    <%--搜索：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>--%>
    <shiro:hasAnyRoles name="auditor">
        <button class="layui-btn" data-type="batchAudit">批量审核通过</button>
        <button class="layui-btn" data-type="batchAudit">批量审核不通过</button>
    </shiro:hasAnyRoles>
    <shiro:hasAnyRoles name="specialist">
        <button class="layui-btn" data-type="batchAssess">批量评奖</button>
    </shiro:hasAnyRoles>
</div>
<div>
    <table id="series" class="layui-table" lay-filter="series">
    </table>
</div>
</body>
</html>
<script src="/static/tools/layui/layui.js"></script>
<script src="/static/tools/layui/lay/modules/laytpl.js"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
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
<script>
    var $;
    var table;
    var form;
    var url;
    layui.use('table', function () {
        $ = layui.$;
        table = layui.table;
        form = layui.form;

        table.render({
            elem: "#series",
            url: url,
            page: true,
            cols: [[ //表头
                {type: 'checkbox', fixed: 'left'},
                {field: 'id', title: 'ID'},
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
            console.log(obj);
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            if (layEvent === 'audit') {
                //审核
                layer.prompt({title: '请输入内容'}, function (val, index) {
                    var tempObj = new Object();
                    tempObj.id = data.id;
                    var tempObjs = new Object();
                    tempObjs[0] = tempObj;
                    audit(tempObjs, 1, val);
                    layer.close(index);
                });
            } else if (layEvent == 'assess') {
                //评分
                assess(data);
            } else if (layEvent === 'distribute') {
                //分配
                distribute(data);
            } else if (layEvent == 'detail') {
                //查看
                detail(data);
            }
        });

        $('.tableBox .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        var active = {
            batchAudit: function () {
                var data = table.checkStatus('series').data;
                if (data.length <= 0) {
                    layer.alert("请选择内容");
                    return false;
                }
                layer.prompt({title: '请输入内容'}, function (val, index) {
                    audit(data, 1, val);
                    layer.close(index);
                });
            },
            batchNoAudit: function () {
                var data = table.checkStatus('series').data;
                if (data.length <= 0) {
                    layer.alert("请选择内容");
                    return false;
                }
                layer.prompt({title: '请输入内容'}, function (val, index) {
                    audit(data, -1, val);
                    layer.close(index);
                });
            },
            batchAssess: function () {
                var data = table.checkStatus('series').data;
                if (data.length <= 0) {
                    layer.alert("请选择内容");
                    return false;
                }
                assess(data);
            }
        };
    });
</script>
<script>
    function detail(data) {
        var seriesId = data.id;
        $.ajax({
            url: "/seriesUser/" + seriesId,
            type: "get",
            success: function (data) {
                var result = $.parseJSON(data);
                if (result.code == 200) {
                    layer.msg(result.data.name);
                }
            }
        })
    }
</script>
<shiro:hasAnyRoles name="auditor">
    <script>
        url = "/series/series";
        function audit(objs, status, reason) {
            if (objs.length <= 0) return false;
            var tempParam = "";
            for (var i in objs) {
                tempParam += "seriesIds=" + objs[i].id + "&";
            }
            $.ajax({
                url: "/series/updateStatus?" + tempParam + "status=" + status + "&reason=" + reason,
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
        url = "/series/series?uid=" + ${SESSION_USER.id};
        function assess(data) {
            console.log(data);
            var seriesId = data.id;
            $.ajax({
                url: "/seriesUser/" + seriesId,
                type: "get",
                success: function (data) {
                    var result = $.parseJSON(data);
                    console.log(result);
                    if (result.code == 200) {
                        layer.open({
                            type: 2,
                            area: ['50%', '50%'],
                            title: '评奖',
                            content: '/admin/seriesUser/updateSeriesUser.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                            success: function (layero, index) {
                                var body = layer.getChildFrame('body', index);
                                body.find('#seriesUserId').val(result.data.id);
                                body.find('#seriesId').val(seriesId);
                            }
                        });
                    } else {
                        layer.msg(result.message);
                    }
                }
            })
        }
    </script>
</shiro:hasAnyRoles>
<shiro:hasAnyRoles name="manager">
    <script>
        url = "/series/series";
        function distribute(data) {
            var seriesId = data.id;
            layer.open({
                type: 2,
                area: ['50%', '50%'],
                title: '分配',
                content: '/admin/seriesUser/addSeriesUser.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                success: function (layero, index) {
                    var body = layer.getChildFrame('body', index);
                    $.ajax({
                        url: "/admin/user/users",
                        type: "get",
                        success: function (data) {
                            var result = $.parseJSON(data);
                            if (result.code == 200) {
                                var tempStr = "";
                                for (var i in result.data.records) {
                                    tempStr += "<input type=\"checkbox\" name=\"userIds\" title=\"" + result.data.records[i].name + "\" value=\"" + result.data.records[i].id + "\" lay-skin=\"primary\">";
                                }
                                console.log(tempStr);
                                body.find("#users").prepend(tempStr);
                                body.find("#seriesId").val(seriesId);
                                var childiFrame = window['layui-layer-iframe' + index];
                                childiFrame.reloadForm();
                            }
                        }
                    })
                }
            });
        }
    </script>
</shiro:hasAnyRoles>
