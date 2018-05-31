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

        </ul>
        <div class="pagination">

        </div>
    </div>
</div>

<script>
    $(function () {
        $.ajax({
            type: "GET",
            url: "/activity/activities?categoryId=" + globalCategoryId,
            //data: {},
            async: false,
            dataType: "json",
            success: function (data) {
                $('.activity_list .clearfix').empty();   //清空activity_list里面的所有内容
                if (data.code == 200) {
                    var records = data.data.records;
                    var html = "";
                    for (var i = 0; i < records.length; i++) {
                        var result = records[i];
                        html += "<li>";
                        html += "<div class=\"divImg\">";
                        html += "<a href=\"#\"><img src=\"temp/01.png\" width=\"184\" height=\"123\" /></a>";
                        html += "<div class=\"rgba_div\"></div>";
                        html += "<div class=\"parent pos_abs\"><span class=\"huifu con_color\"><b class=\"icons\"></b>1890</span><span class=\"zan zan_cur con_color\"><b class=\"icons\"></b>1890</span></div>\n";
                        html += "</div>";
                        html += "<dl>";
                        html += "<dt><a href=\"#\">" + result.name + "</a></dt>";
                        html += "<dd>" + result.insertTime + "</dd>";
                        html += "<dd>" + result.place + "</dd>";
                        html += "<dd>" + result.hoster + "</dd>";
                        html += "<dd style=\"margin-top:6px;\"><a class=\"chakan\" onclick=\"changeDiv('/activityInfo.html', null, " + result.id + ", null, null)\">查看活动</a></dd>";
                        html += "</dl>";
                        html += "</li>";
                    }

                    if(data.data.total != 0){
                        writePageHtml(data.data.current, data.data.pages);
                    }
                    $(".activity_list .clearfix").html(html);
                } else {
                    alert('数据加载失败...');
                }
            }
        });
    });

    var tempPageHtml = "";
    function gethtml(pageIndex, name) {
        var tempPageStr = "<a onclick=\"changeDiv('/activities.html', "+globalCategoryId+", null, null, "+pageIndex+")\">"+name+"</a>";
        return tempPageStr;
    }

    function writePageHtml(currentPage, pages) {
        var upPage = currentPage - 1;
        var downPage = currentPage + 1;
        tempPageHtml += gethtml(1, '首页');
        if(upPage <= 0){
            tempPageHtml += gethtml(1, '上一页');
        }
        for (var i = 1;i <= pages; i++){
            if(i == currentPage){
                tempPageHtml += "<a class=\"cur\" onclick=\"changeDiv('/activities.html', "+globalCategoryId+", null, null, "+currentPage+")\">"+currentPage+"</a>";
            }else{
                tempPageHtml += gethtml(i, i);
            }
        }
        if(downPage >= pages){
            tempPageHtml += gethtml(pages, '下一页');

        }
        tempPageHtml += gethtml(pages, '尾页');

        $(".pagination").html(tempPageHtml);
    }
</script>