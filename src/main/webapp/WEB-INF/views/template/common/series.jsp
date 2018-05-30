<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main_right rightF">
    <div class="search_bd">
        <div class="search_content">
            <h3>秋季微课大赛</h3>
            <%--<div class="search_div">
                <input name="" type="text" class="fidtext" placeholder="请输入学号或姓名"/><input name="" type="button"
                                                                                          class="bnt_sear"/>
            </div>--%>
        </div>
    </div>
    <div class="video_pic_list">
        <ul id="series">
            <li>
                <a title="秋季微课大赛" href="#"><img src="temp/01.png"/></a>
                <div class="play_number rightF">129次播放</div>
                <dl>
                    <dt><a title="秋季微课大赛" href="#">秋季微课大赛</a></dt>
                    <dd><span class="text">主讲：周树人</span><span class="text">单位：中国人民大学</span></dd>
                    <dd>本系列主要讲述了茶的种类、如何正确的品茶、茶对人体的好处、还介绍了体验绿茶、布置茶席、正山小种的茶香、茶味、茶理和茶的自然。</dd>
                </dl>
            </li>
        </ul>
        <div id="page" class="pagination">
            <a class="first" href="">首页</a><a class="pre" href="">上一页</a><a href="">1</a><a href="">2</a><a class="cur"
                                                                                                            href="">3</a><a
                href="">4</a><a href="">5</a><a href="#" class="next">下一页</a><a href="">尾页</a>
        </div>
    </div>
</div>

<script type="text/javascript" src="/static/template/common/js/jquery-1.7.2.min.js"></script>
<script>
    $(function () {
        var activityId = getUrlParam("activityId");
        getSeries(activityId);
    });

    function getSeries(activityId) {
        $.ajax({
            url: "/series/series?activityId=" + activityId,
            type: "get",
            success: function (data) {
                var result = $.parseJSON(data);
                if (result.code == 200) {
                    var obj = result.data.records;
                    var tempStr = "";
                    for (var i in obj) {
                        tempStr += "<li>" +
                            "<a title=\"秋季微课大赛\" href=\"#\"><img src=\"temp/01.png\"/></a>" +
                            "<div class=\"play_number rightF\">" + obj[i].clickCount + "次播放</div>" +
                            "<dl>" +
                            "<dt><a title=\"秋季微课大赛\" href=\"#\">" + obj[i].name + "</a></dt>" +
                            "<dd><span class=\"text\">主讲：" + obj[i].author + "</span><span class=\"text\">单位：" + obj[i].company + "</span></dd>" +
                            "<dd>" + obj[i].intro + "</dd>" +
                            "</dl>" +
                            "</li>";
                    }
                    $("#series").html(tempStr);
                }
            }
        })
    }

    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]);
        return null; //返回参数值
    }
</script>
