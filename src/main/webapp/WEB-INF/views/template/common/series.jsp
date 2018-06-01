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
            <h3 id="tempTitle"></h3>
            <%--<div class="search_div">
                <input name="" type="text" class="fidtext" placeholder="请输入学号或姓名"/><input name="" type="button"
                                                                                          class="bnt_sear"/>
            </div>--%>
        </div>
    </div>
    <div class="video_pic_list">
        <ul id="series">
            <li>
                <a title="秋季微课大赛" href="#"><img src="/static/template/common/temp/01.png"/></a>
                <div class="play_number rightF">129次播放</div>
                <dl>
                    <dt><a title="秋季微课大赛" href="#">秋季微课大赛</a></dt>
                    <dd><span class="text">主讲：周树人</span><span class="text">单位：中国人民大学</span></dd>
                    <dd>本系列主要讲述了茶的种类、如何正确的品茶、茶对人体的好处、还介绍了体验绿茶、布置茶席、正山小种的茶香、茶味、茶理和茶的自然。</dd>
                </dl>
            </li>
        </ul>
        <div id="tempPage" class="pagination">
            <%--<a class="first" href="">首页</a><a class="pre" href="">上一页</a><a href="">1</a><a href="">2</a><a class="cur"
                                                                                                            href="">3</a><a
                href="">4</a><a href="">5</a><a href="#" class="next">下一页</a><a href="">尾页</a>--%>
        </div>
    </div>
</div>

<script type="text/javascript" src="/static/template/common/js/jquery-1.7.2.min.js"></script>
<script>
    $(function () {
        $("#tempTitle").html($("#category_" + globalCategoryId).html());
        getSeries(globalCategoryId, globalPageIndex == null ? 1 : globalPageIndex);
    });

    function getSeries(categoryId, current) {
        $.ajax({
            url: "/series/series?size=4&current=" + current + "&categoryId=" + categoryId,
            type: "get",
            success: function (data) {
                var result = $.parseJSON(data);
                if (result.code == 200) {
                    writePage(result.data);
                    var obj = result.data.records;
                    var tempStr = "";
                    for (var i in obj) {
                        tempStr += "<li>" +
                            "<a title=\"秋季微课大赛\" href=\"#\" onclick=\"changeDiv('/seriesInfo.html', null, null, " + obj[i].id + ", null)\"><img src=\"/static/template/common/temp/01.png\"/></a>" +
                            "<div class=\"play_number rightF\">" + obj[i].clickCount + "次播放</div>" +
                            "<dl>" +
                            "<dt><a title=\"秋季微课大赛\" href=\"#\" onclick=\"changeDiv('/seriesInfo.html', null, null, " + obj[i].id + ", null)\">" + obj[i].name + "</a></dt>" +
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

    function writePage(page) {
        globalPageIndex = page.current;
        var current = page.current;
        var pages = page.pages;
        var tempStr = "";
        tempStr += getPageHtml(1, "首页");
        var tempPre = current > 1 && pages > 1 ? current - 1 : 1;
        tempStr += getPageHtml(tempPre, "上一页");
        for (var i = 1; i <= pages; i++) {
            if (i == current) {
                tempStr += "<a class=\"cur\" href=\"#\" onclick=\"changeDiv('/series.html', null, null, null, " + i + ")\">" + i + "</a>";
            } else {
                tempStr += getPageHtml(i, i);
            }
        }
        var tempNext = current > 1 && pages > 1 ? current + 1 : 1;
        tempStr += getPageHtml(tempNext, "下一页");
        tempStr += getPageHtml(pages, "尾页");
        $("#tempPage").html(tempStr);
    }

    function getPageHtml(pageIndex, name) {
        //除了当前页具有样式，其他都无样式
        var tempStr = "<a href=\"#\" onclick=\"changeDiv('/series.html', null, null, null, " + pageIndex + ")\">" + name + "</a>";
        return tempStr;
    }
</script>
