<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="/static/template/common/css/global.css" type="text/css" rel="stylesheet"/>
<link href="/static/template/common/css/video_deta.css" type="text/css" rel="stylesheet"/>
<body>
<div class="videoBox" style="right:395px;">
    <div class="playTop">
        <div class="py_cg"></div>
        <a class="py_pre" href="javascript:;">已经是第一集</a>
        <a class="py_next" href="javascript:;">已经是最后一集</a>
        <p class="py_thide"></p>
        <div class="videoPlay"></div>
        <div class="py_leftbtn"></div>
    </div>
</div>
<div class="dire" id="tabs01">
    <div class="intro">
        <h4><a href="#">儒家的教化观念（二）</a></h4>
        <div class="score"><span class="star s3"></span><span class="num">（2354份评价)</span></div>
        <p>主讲人：李大由</p>
        <p>学校：北京师范大学</p>
    </div>
    <div class="ctory tabel_title">
        <a class="cur" href="#"><b class="cy_1"></b>目录<span></span></a>
    </div>
    <div class="tabel_content">
        <div class="ctory_text Mohpy" style="display:block;">
            <ul>

            </ul>
        </div>
    </div>
</div>
</body>
</html>

<script type="text/javascript" src="/static/template/common/js/jquery-1.7.2.min.js"></script>

<script>
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }

    function playVideo(records) {
        var playHtml = "<video controls=\"controls\" autoplay=\"autoplay\" width=\"100%;\">\n" +
            "  <source src=\"" + records.logo + "\" type=\"video/ogg\" />\n" +
            "  <source src=\"" + records.fileRoute + "\" type=\"video/mp4\" />\n" +
            "Your browser does not support the video tag.\n" +
            "</video>";
        $(".videoPlay").html(playHtml);
    }

    //刷新上一集下一集
    function refresh(result, index) {
        for (var i = 0; i < result.length; i++) {
            var cur_resource = result[index];
            $(".playTop .py_thide").html("<span>第" + (index + 1) + "集</span>" + cur_resource.name);
            if (index >= 1) {
                var pre_resource = result[index - 1];
                $(".playTop .py_pre").attr("href", "/resourceInfo.html?resourceId=" + pre_resource.id + "&seriesId=" + seriesId);
                $(".playTop .py_pre").html(pre_resource.name);
            }
            if (index < result.length - 1) {
                var down_resource = result[index + 1];
                $(".playTop .py_next").attr("href", "/resourceInfo.html?resourceId=" + down_resource.id + "&seriesId=" + seriesId);
                $(".playTop .py_next").html(down_resource.name);
            }
        }
    }

    //列表HTML
    var resourceHtml = "";

    function writeResourceListHtml(records) {
        resourceHtml += "<li><a href=\"/resourceInfo.html?resourceId=" + records.id + "&seriesId=" + seriesId + "\"><b></b>" + records.name + "</a></li>";
    }

    //右上角HTML
    function writeIntroHtml(records) {
        var introHtml = "<h4><a href=\"javascript:;\">" + records.name + "</a></h4>";
        getSeries(introHtml);
    }

    function getSeries(introHtml) {
        $.ajax({
            type: "GET",
            url: "/series/" + seriesId,
            //data: {},
            async: false,
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    introHtml += "<p>主讲人：" + data.data.author + "</p><p>学校：" + data.data.company + "</p>";
                    $(".intro").html(introHtml);
                } else {
                    alert('数据加载失败...');
                }
            }
        });
    }

    /*function getVideo(records) {
        $.ajax({
            type: "GET",
            url: "/resource/resources"+resourceId+"&seriesId=" + seriesId,
            //data: {},
            async: false,
            dataType: "json",
            success: function (data) {
                $(".videoPlay").html(playVideo(data.data.logo, data.data.fileRoute));
            }
        });
    }*/

    var seriesId = getUrlParam("seriesId");
    var resourceId = getUrlParam("resourceId");
    //加载右侧列表
    $(function () {
        $.ajax({
            type: "GET",
            url: "/resource/resources?seriesId=" + seriesId,
            //data: {},
            async: false,
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    var result = data.data.records;
                    for (var i = 0; i < result.length; i++) {
                        var records = result[i];
                        if (resourceId == records.id) {
                            playVideo(records);
                            resourceHtml += "<li class=\"cur\"><a href=\"/resourceInfo.html?resourceId=" + records.id + "&seriesId=" + seriesId + "\"><b></b>" + records.name + "</a></li>";
                            writeIntroHtml(records);
                            refresh(result, i);
                        } else {
                            if (resourceId == null && i == 0) playVideo(records);
                            writeResourceListHtml(records);
                        }
                    }

                    $(".ctory_text ul").html(resourceHtml);
                } else {
                    alert('数据加载失败...');
                }
            }
        });
    });
</script>

<script type="text/javascript">

    //笔记、评论 video播放
    $('document').ready(function () {

        $(function () {
            function tabs(tabTit, on, tabCon) {
                $(tabTit).children().click(function () {
                    $(this).addClass(on).siblings().removeClass(on);
                    var index = $(tabTit).children().index(this);
                    $(tabCon).children().eq(index).show().siblings().hide();
                });
            };
            tabs(".tabel_title", "cur", ".tabel_content");
        });

    });

    //video播放右边开关
    $('.py_leftbtn').toggle(function () {
        $(this).addClass('py_rightbtn');
        $('.videoBox').animate({'right': 0});
        $('.dire').animate({'right': -395});
    }, function () {
        $(this).removeClass('py_rightbtn');
        $('.videoBox').animate({'right': 395});
        $('.dire').animate({'right': 0});
    });

</script>