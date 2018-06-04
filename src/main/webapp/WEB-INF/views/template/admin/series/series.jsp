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
    layui.use('table', function () {
        var table = layui.table;

        table.render({
            elem: "#series",
            url: "/series/series?status=0",
            page: true,
            cols: [[ //表头
                {field: 'id', title: 'ID', fixed: 'left'},
                {field: 'name', title: '名称'},
                {field: 'phone', title: '联系方式'},
                {field: 'company', title: '单位'},
                {field: 'author', title: '作者'},
                {field: 'insertTime', title: '创建时间'},
                {field: 'tool', title: '操作', toolbar:'#barDemo'}
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

        table.on('tool(series)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'detail'){ //查看
                console.log(data.status);
                //do somehing
                /**
                 如果是iframe层
                 */
                toAward(data);
            } else if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                });
            } else if(layEvent === 'edit'){ //编辑
                //do something
                console.log(data);
                //同步更新缓存对应的值
                obj.update({
                    username: '123'
                    ,title: 'xxx'
                });
            }else if(layEvent === 'check'){ //审核通过
                //do something
                console.log(data);
                layer.confirm('确定要通过审核么', function(index){
                    check(data.id, obj);
                    //obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                });
                //同步更新缓存对应的值
                obj.update({
                    username: '123'
                    ,title: 'xxx'
                });
            }
        });
    });
</script>
<script type="text/html" id="barDemo">
    <!-- 这里同样支持 laytpl 语法，如： -->

    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

    {{#  if(d.status == 0){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  } }}

</script>
<script>
    //主动加载jquery模块
    function check(seriesId, obj) {
        layui.use(['jquery', 'layer'], function(){
            var $ = layui.$ //重点处
                ,layer = layui.layer;

            //后面就跟你平时使用jQuery一样
            $.getJSON("/series/updateStatus?seriesId=" + seriesId + "&status=" + 1, function (data) {
                if(data.code == 200){
                    layer.msg("审核成功");
                    obj.del();
                }else{
                    layer.msg("审核失败");
                }
            });
        });
    }
</script>
<script>
    function toAward(data) {
        var id = data.id;
        layer.open({
            type: 2,
            area: ['50%', '50%'],
            title: '评奖',
            content: '/admin/seriesUser/updateSeriesUser.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            success: function(layero, index){
                var body = layer.getChildFrame('body', index);
//                var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
//                console.log(body.html()) //得到iframe页的body内容
                body.find('#series').val(id);
            }
        });
    }
</script>
