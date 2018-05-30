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
        <ul class="clearfix">
            <script>
                $.ajax({
                    type: "GET",
                    url: "/activityUid/join?activityId=" + golba_id,
                    //data: {},
                    async: false,
                    dataType: "json",
                    success: function(data){
                        $('.card').empty();   //清空activity_list里面的所有内容
                        if(data.code == 200){
                            var result = data.data;
                            var html = "";
                            for(var i = 0; i < result.length; i++){
                                html += "<li>";
                                html += "<a href=\"#\"><img src=\"temp/photos.jpg\" /></a>";
                                html += "<p><a href=\"#\">人名</a></p>";
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
    </div>
</div>
