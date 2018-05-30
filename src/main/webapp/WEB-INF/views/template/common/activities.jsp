<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="main_right rightF">
    <div class="activity_list">
        <ul class="clearfix">
            <script>
                $.ajax({
                    type: "GET",
                    url: url,
                    //data: {},
                    dataType: "json",
                    success: function(data){
                        $('.activity_list .clearfix').empty();   //清空activity_list里面的所有内容
                        var html = "";
                        html += "<li>";
                        html += "<div class=\"divImg\">";
                        html += "<a href=\"#\"><img src=\"temp/01.png\" width=\"184\" height=\"123\" /></a>";
                        html += "<div class=\"rgba_div\"></div>";
                        html += "<div class=\"parent pos_abs\"><span class=\"huifu con_color\"><b class=\"icons\"></b>1890</span><span class=\"zan zan_cur con_color\"><b class=\"icons\"></b>1890</span></div>\n";
                        html += "</div>";
                        html += "<dl>";
                        html += "<dt><a href=\"#\">春游活动</a></dt>";
                        html += "<dd>时间：2018-05-16 至 2018-06-12</dd>";
                        html += "<dd>地点：北京市香山公园</dd>";
                        html += "<dd>发起：社区学院</dd>";
                        html += "<dd style=\"margin-top:6px;\"><a class=\"chakan\" href=\"#\">查看活动</a></dd>";
                        html += "</dl>";
                        html += "</li>";
                        $(".activity_list .clearfix").html(html);
                    }
                });
            </script>
        </ul>
        <div class="pagination">
            <a class="first" href="">首页</a><a class="pre" href="">上一页</a><a href="">1</a><a href="">2</a><a class="cur" href="">3</a><a href="">4</a><a href="">5</a><a href="#" class="next">下一页</a><a href="">尾页</a>
        </div>
    </div>
</div>
</body>
</html>
