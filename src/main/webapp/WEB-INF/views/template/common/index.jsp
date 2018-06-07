<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link type="text/css" rel="stylesheet" href="/static/template/common/css/global.css"/>
<link type="text/css" rel="stylesheet" href="/static/template/common/css/style.css"/>
<script type="text/javascript" src="/static/template/common/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="http://passport.sdlll.net/header?id=1"></script>


<div class="main_box wrap1080 clearfix">
    <div class="main_left leftF">
        <div class="declare_content">
            <div class="declare_all">全部申报</div>
            <div class="declare_class">

            </div>
        </div>
    </div>
    <div id="right_content"></div>
</div>
</body>
</html>
<script type="text/javascript" src="http://passport.sdlll.net/footer.shtml" charset="utf-8"></script>
<script type="text/javascript" src="/static/template/common/js/com_index.js"></script>
<script language="javascript">

    var type;
    var globalCategoryId;
    var globalActivityId;
    var globalSeriesId;
    var globalPageIndex;

    //加载分类数据
    $(function () {
        type = getUrlParam("type");
        writeCategory();
    });

    function writeCategory() {
        $.ajax({
            type: "GET",
            url: "/category/tree",
            //data: {},
            dataType: "json",
            success: function (data) {
                if (data.code == '200') {
                    $('.main_left .declare_class').empty();   //清空activity_list里面的所有内容
                    $(".main_left .declare_class").html(getOuter(data.data));
                    $.getScript("/static/template/common/js/com_index.js");
                } else {
                    alert('数据加载失败...');
                }
            }
        });
    }

    //拼接HTML(最外层)
    function getOuter(cate) {
        var tempStr = "";
        if (cate != null && cate != '') {
            for (var i = 0; i < cate.length; i++) {
                var result = cate[i];
                var tempIndex = 0;
                if (tempIndex == 0) {
                    tempIndex++;
                    tempStr += "<div id=\"div_" + result.id + "\" class=\"declare_cell declare_cell_active\"><a class=\"title_row\" href=\"#\">" + result.name + "</a>";
                } else {
                    tempStr += "<div id=\"div_" + result.id + "\" class=\"declare_cell\"><a class=\"title_row\" href=\"#\">" + result.name + "</a>";
                }
                tempStr += getCategory(result.children);
                tempStr += "</div>";
            }
        }
        return tempStr;
    }

    //递归获取分类(不包括最外层)
    function getCategory(cate_data) {
        var tempStr = "<ul>";
        if (cate_data != null && cate_data != '') {
            for (var i = 0; i < cate_data.length; i++) {
                var cate = cate_data[i];
                tempStr += getInner(cate);
                if (cate.children != null) {
                    tempStr += getCategory(cate.children);
                }
            }
        }
        tempStr += "</ul>";
        return tempStr;
    }

    //获取最内层
    function getInner(cate) {
        var tempStr = "";
        if (isNotEmpty(cate)) {
            //最后一个参数，要将全局分页置为1
            if (type == 1) {
                tempStr += "<li><a id=\"category_" + cate.id + "\" onclick=\"changeDiv('/activities.html?categoryId=" + cate.id + "', " + cate.id + ",null" + ",null" + ",1" + ")\">" + cate.name + "</a></li>";
            } else if (type == 2) {
                tempStr += "<li><a id=\"category_" + cate.id + "\" onclick=\"changeDiv('/series.html?categoryId=" + cate.id + "', " + cate.id + ",null" + ",null" + ",1" + ")\">" + cate.name + "</a></li>";
            }
        }
        return tempStr;
    }

    //公共方法刷新div
    function changeDiv(url, categoryId, activityId, seriesId, pageIndex) {
        flushGlobalValue(categoryId, activityId, seriesId, pageIndex);
        $("#right_content").empty();
        $.ajax({
            type: "GET",
            url: url,
            dataType: "html",
            success: function (data) {
                $('#right_content').empty();   //清空right_content里面的所有内容
                $("#right_content").html(data);
            }
        });
    }

    function flushGlobalValue(categoryId, activityId, seriesId, pageIndex) {
        if (isNotEmpty(categoryId)) globalCategoryId = categoryId;
        if (isNotEmpty(activityId)) globalActivityId = activityId;
        if (isNotEmpty(seriesId)) globalSeriesId = seriesId;
        if (isNotEmpty(pageIndex)) globalPageIndex = pageIndex;
        console.log(" globalCategoryId : " + globalCategoryId + " globalActivityId : " + globalActivityId + " globalSeriesId : " + globalSeriesId + " globalPageIndex : " + globalPageIndex);
    }

    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }

    function isNotEmpty(o) {
        if (o == null || o == '') return false;
        return true;
    }

</script>
