<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main_right rightF">
    <div class="return_content"><a class="bnt_return" href="#"><b class="icons"></b>返回</a></div>
    <div class="card clearfix">

        <div class="clear"></div>
    </div>
    <div class="act_content">
        <div class="act_title"><h2><b class="icons"></b>活动内容</h2></div>
        <div class="act_text">

        </div>
    </div>
</div>

<script>
    function getCardLeftHtml(result) {
        var temp_html = "";
        temp_html += "<div class=\"card_left leftF\">";
        temp_html += "<img src=\"temp/01.png\" width=\"292\" height=\"194\"/>";
        temp_html += "<h3><a title=\"" + result.name + "\" href=\"#\">" + result.name + "</a></h3>";
        temp_html += "<div class=\"text\">";
        temp_html += "<p>地点：" + result.place + "</p>";
        temp_html += "<p>发起：" + result.hoster + "</p>";
        temp_html += "<p>参与人数：" + result.peopleCount + "</p>";
        temp_html += "</div>";
        temp_html += "<div class=\"parent\"><span class=\"huifu con_color\"><b class=\"icons\"></b>" + result.clickCount + "</span>";
        temp_html += "<span class=\"zan zan_cur con_color\"><b class=\"icons\"></b>" + result.clickCount + "</span></div>";
        ///*temp_html += " file=\"/static/template/common/fenxiang.html\"%>";*/
        temp_html += "</div>";
        return temp_html;
    }

    function getCardRightHtml(result) {
        var temp_html = "";
        temp_html += "<div class=\"card_right rightF\">";
        temp_html += "<dl class=\"time\">";
        temp_html += "<dt>开始报名：</dt>";
        temp_html += "<dd>" + result.beginTime + "</dd>";
        temp_html += "<dt>结束报名：</dt>";
        temp_html += "<dd>" + result.endTime + "</dd>";
        temp_html += "</dl>";
        temp_html += "<div class=\"bntt\">";
        temp_html += "<a class=\"sign\" href='javascript:alert(\"报名成功!\")'>我要报名</a>";
        temp_html += "<span class=\"sign\">已报名</span>";
        temp_html += "<span class=\"dele\">活动已结束</span>";
        temp_html += "<a class=\"sign\" onclick='changeDiv(\"/addSeries.html\")'>上传课程</a>";
        temp_html += "</div>";
        temp_html += "</div>";
        return temp_html;
    }

    function getContentHtml(content) {
        var temp_html = "";
        temp_html += content;
        temp_html += "<div class=\"more_bottom\"><a class=\"more_an icons\" href=\"javascript:\"></a></div>";
        return temp_html;
    }

    $(function () {
        $.ajax({
            type: "GET",
            url: "/activity/" + globalActivityId,
            //data: {},
            async: false,
            dataType: "json",
            success: function (data) {
                $('.card').empty();   //清空activity_list里面的所有内容
                if (data.code == 200) {
                    var result = data.data;
                    var card_html = getCardLeftHtml(result) + getCardRightHtml(result);
                    $(".card").html(card_html);
                    $(".act_text").html(getContentHtml(result.content));//添加content
                } else {
                    alert('数据加载失败...');
                }
            }
        });
    });
</script>