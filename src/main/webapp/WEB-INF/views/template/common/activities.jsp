<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="/static/template/common/js/jquery-1.7.2.min.js"></script>
<div class="main_right rightF">
    <div class="activity_list">
        <ul class="clearfix">
            <script>
                $.ajax({
                    type: "GET",
                    url: "/activity/activities?categoryId=" + cate_id,
                    //data: {},
                    async: false,
                    dataType: "json",
                    success: function(data){
                        $('.activity_list .clearfix').empty();   //清空activity_list里面的所有内容
                        if(data.code == 200){
                            var records = data.data.records;
                            var html = "";
                            for(var i = 0; i < records.length; i++){
                                var result = records[i];
                                html += "<li>";
                                html += "<div class=\"divImg\">";
                                html += "<a href=\"#\"><img src=\"temp/01.png\" width=\"184\" height=\"123\" /></a>";
                                html += "<div class=\"rgba_div\"></div>";
                                html += "<div class=\"parent pos_abs\"><span class=\"huifu con_color\"><b class=\"icons\"></b>1890</span><span class=\"zan zan_cur con_color\"><b class=\"icons\"></b>1890</span></div>\n";
                                html += "</div>";
                                html += "<dl>";
                                html += "<dt><a href=\"#\">"+result.name+"</a></dt>";
                                html += "<dd>"+result.insertTime+"</dd>";
                                html += "<dd>"+result.place+"</dd>";
                                html += "<dd>"+result.hoster+"</dd>";
                                html += "<dd style=\"margin-top:6px;\"><a class=\"chakan\" onclick='changeDiv(\"/activityInfo.html\", "+result.id+", 2);'>查看活动</a></dd>";
                                html += "</dl>";
                                html += "</li>";
                            }
                            $(".activity_list .clearfix").html(html);
                        }else{
                            alert('数据加载失败...');
                        }
                    }
                });
            </script>
        </ul>
        <div class="pagination">
            <a class="first" href="">首页</a><a class="pre" href="">上一页</a><a href="">1</a><a href="">2</a><a class="cur" href="">3</a><a href="">4</a><a href="">5</a><a href="#" class="next">下一页</a><a href="">尾页</a>
        </div>
    </div>
</div>
