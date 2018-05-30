<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main_right rightF">
    <div class="return_content"><a class="bnt_return" href="#"><b class="icons"></b>返回</a></div>

    <div class="members">
        <div class="act_title"><h2><b class="icons"></b>活动成员</h2></div>
        <ul id="activityUsers" class="clearfix">
            <li>
                <a href="#"><img src="temp/photos.jpg"></a>
                <p><a href="#">人名</a></p>
            </li>
        </ul>
    </div>
</div>

<script type="text/javascript" src="/static/template/common/js/jquery-1.7.2.min.js"></script>
<script>
    $(function () {
        var activityId = getUrlParam("activityId");
        activityUids(activityId);
    });

    function activityUids(activityId) {
        $.ajax({
            url:"/activityUid/users?activityId="+ activityId,
            type:"get",
            success:function (data) {
                var result = $.parseJSON(data);
                if (result.code == 200) {
                    var obj = result.data.records;
                    var tempStr = "";
                    for (var i in obj) {
                        tempStr += "<li>" +
                            "<a href=\"#\"><img src=\"temp/photos.jpg\"></a>" +
                            "<p><a href=\"#\">"+ obj[i].username +"</a></p>" +
                            "</li>";
                    }
                    $("#activityUsers").html(tempStr);
                }
            }
        })
    }

    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }
</script>
