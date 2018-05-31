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
<link type="text/css" rel="stylesheet" href="/static/template/common/css/global.css" />
<link type="text/css" rel="stylesheet" href="/static/template/common/css/style.css" />
<script type="text/javascript" src="/static/template/common/js/jquery-1.7.2.min.js"></script>

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
<script type="text/javascript" src="/static/template/common/js/com_index.js"></script>
</body>
</html>

<script>
    //加载分类数据
    $(function () {
        $.ajax({
            type: "GET",
            url: "/category/tree",
            //data: {},
            dataType: "json",
            success: function(data){
                if(data.code == '200'){
                    $('.main_left .declare_class').empty();   //清空activity_list里面的所有内容
                    getOuter(data.data);
                    $(".main_left .declare_class").html(tempHtml);
                    $.getScript("/static/template/common/js/com_index.js");
                }else{
                    alert('数据加载失败...');
                }
            }
        });
    });
</script>
<script language="javascript">
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }

    //赋予全局id
    var cate_id = "", activity_id = "";
    var cate_type = 1, activity_type = 2, activity_uid_type = 3//分类1，活动列表2
    function getId(id, type) {
        var url = "";
        if(type == cate_type){
            cate_id = id;
            return;
        }
        if(type == activity_type){
            activity_id = id;
            return;
        }
    }

    //公共方法刷新div
    function changeDiv(url, id, type) {
        $("#right_content").empty();
        getId(id, type);
        $.ajax({
            type: "GET",
            url: url,
            //data: {},
            dataType: "html",
            success: function(data){
                //getId(id, type);
                $('#right_content').empty();   //清空right_content里面的所有内容
                $("#right_content").html(data);
            }
        });
    }

    //拼接HTML(最外层)
    var tempHtml = "";
    var index = 0;
    function getOuter(cate) {
        if(cate != null && cate != ''){
            for(var i = 0; i < cate.length; i++){
                var result = cate[i];
                if(index == 0){
                    index ++;
                    tempHtml += "<div id=\"div_"+result.id+"\" class=\"declare_cell declare_cell_active\"><a class=\"title_row\" href=\"#\">"+result.name+"</a>";
                }else{
                    tempHtml += "<div id=\"div_"+result.id+"\" class=\"declare_cell\"><a class=\"title_row\" href=\"#\">"+result.name+"</a>";
                }
                tempHtml += "<ul>";
                getCategory(result.children);
                tempHtml += "</ul>";
                tempHtml += "</div>";
            }
        }
    }
    //拼接HTML(子层)
    function getInner(cate) {
        if(cate != null && cate != ''){
            tempHtml += "<li><a onclick='changeDiv(\"/activities.html?categoryId="+cate.id+"\", "+cate.id+", 1)'>"+cate.name+"</a></li>";
        }
    }

    //递归获取分类(不包括最外层)
    function getCategory(cate_data) {
        if(cate_data != null && cate_data != ''){
            for(var i = 0; i < cate_data.length; i++){
                var cate = cate_data[i];
                getInner(cate);
                if(cate.children != null){
                    getCategory(cate.children);
                }else{
                    continue;
                }
            }
        }else{
            return null;
        }
    }
</script>
