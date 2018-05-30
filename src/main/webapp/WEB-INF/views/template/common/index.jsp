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
                <script>
                    //拼接HTML(最外层)
                    var html = "";
                    var index = 0;
                    function get_html1(cate) {
                        if(cate != null && cate != ''){
                            for(var i = 0; i < cate.length; i++){
                                var result = cate[i];
                                if(index == 0){
                                    index ++;
                                    html += "<div id=\"div_"+result.id+"\" class=\"declare_cell declare_cell_active\"><a class=\"title_row\" href=\"#\">"+result.name+"</a>";
                                }else{
                                    html += "<div id=\"div_"+result.id+"\" class=\"declare_cell\"><a class=\"title_row\" href=\"#\">"+result.name+"</a>";
                                }
                                html += "<ul>";
                                get_category(result.children);
                                html += "</ul>";
                                html += "</div>";
                            }
                        }
                    }
                    //拼接HTML(子层)
                    function get_html2(cate) {
                        if(cate != null && cate != ''){
                            html += "<li><a onclick='changeDiv(\"/activities.html?categoryId="+cate.id+"\", "+cate.id+")'>"+cate.name+"</a></li>";
                        }
                    }

                    //递归获取分类(不包括最外层)
                    function get_category(cate_data) {
                        if(cate_data != null && cate_data != ''){
                            for(var i = 0; i < cate_data.length; i++){
                                var cate = cate_data[i];
                                get_html2(cate);
                                if(cate.children != null){
                                    get_category(cate.children);
                                }else{
                                    continue;
                                }
                            }
                        }else{
                            return null;
                        }
                    }

                    $.ajax({
                        type: "GET",
                        url: "/category/tree",
                        //data: {},
                        dataType: "json",
                        success: function(data){
                            if(data.code == '200'){
                                $('.main_left .declare_class').empty();   //清空activity_list里面的所有内容
                                get_html1(data.data);
                                $(".main_left .declare_class").html(html);
                                $.getScript("/static/template/common/js/com_index.js");
                            }else{
                                alert('数据加载失败...');
                            }
                        }
                    });
                </script>
            </div>
        </div>
    </div>
    <div id="right_content"></div>
</div>
<script>
    //刷新div
    var golba_id = "";
    function changeDiv(url, id) {
        $("#right_content").empty();
        $.ajax({
            type: "GET",
            url: url,
            //data: {},
            dataType: "html",
            success: function(data){
                golba_id = id;
                $('#right_content').empty();   //清空right_content里面的所有内容
                $("#right_content").html(data);
            }
        });
    }
</script>
<Script language="javascript">
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
</script>

<script type="text/javascript" src="/static/template/common/js/com_index.js"></script>
</body>
</html>
