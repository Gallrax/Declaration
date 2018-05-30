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
                <div class="declare_cell declare_cell_active"><a class="title_row" href="#">2018年</a>
                    <ul>
                        <li><a href="#">春季微课大赛</a></li>
                        <li><a href="#">秋季微课大赛</a></li>
                        <li><a href="#">冬季微课大赛</a></li>
                        <li><a href="#">夏季微课大赛</a></li>
                    </ul>
                </div>
                <div class="declare_cell"><a class="title_row" href="#">2017年</a>
                    <ul>
                        <li><a href="#">春季微课大赛</a></li>
                        <li><a href="#">秋季微课大赛</a></li>
                        <li><a href="#">冬季微课大赛</a></li>
                        <li><a href="#">夏季微课大赛</a></li>
                    </ul>
                </div>
                <div class="declare_cell"><a class="title_row" href="#">2016年</a>
                    <ul>
                        <li><a href="#">春季微课大赛</a></li>
                        <li><a href="#">秋季微课大赛</a></li>
                        <li><a href="#">冬季微课大赛</a></li>
                        <li><a href="#">夏季微课大赛</a></li>
                    </ul>
                </div>
                <div class="declare_cell"><a class="title_row" href="#">2015年</a>
                    <ul>
                        <li><a href="#">春季微课大赛</a></li>
                        <li><a href="#">秋季微课大赛</a></li>
                        <li><a href="#">冬季微课大赛</a></li>
                        <li><a href="#">夏季微课大赛</a></li>
                    </ul>
                </div>
                <div class="declare_cell"><a class="title_row" href="#">2014年</a>
                    <ul>
                        <li><a href="#">春季微课大赛</a></li>
                        <li><a href="#">秋季微课大赛</a></li>
                        <li><a href="#">冬季微课大赛</a></li>
                        <li><a href="#">夏季微课大赛</a></li>
                    </ul>
                </div>
                <div class="declare_cell"><a class="title_row" href="#">2013年</a>
                    <ul>
                        <li><a href="#">春季微课大赛</a></li>
                        <li><a href="#">秋季微课大赛</a></li>
                        <li><a href="#">冬季微课大赛</a></li>
                        <li><a href="#">夏季微课大赛</a></li>
                    </ul>
                </div>
                <div class="declare_cell"><a class="title_row" href="#">2012年</a>
                    <ul>
                        <li><a href="#">春季微课大赛</a></li>
                        <li><a href="#">秋季微课大赛</a></li>
                        <li><a href="#">冬季微课大赛</a></li>
                        <li><a href="#">夏季微课大赛</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="main_right rightF">
        <div id="right_content"></div>
    <%--<div class="activity_list">
            <ul class="clearfix">
                <li>
                    <div class="divImg">
                        <a href="#"><img src="temp/01.png" width="184" height="123" /></a>
                        <div class="rgba_div"></div>
                        <div class="parent pos_abs"><span class="huifu con_color"><b class="icons"></b>1890</span><span class="zan zan_cur con_color"><b class="icons"></b>1890</span></div>
                    </div>
                    <dl>
                        <dt><a href="#">春游活动</a></dt>
                        <dd>时间：2018-05-16 至 2018-06-12</dd>
                        <dd>地点：北京市香山公园</dd>
                        <dd>发起：社区学院</dd>
                        <dd style="margin-top:6px;"><a class="chakan" href="#">查看活动</a></dd>
                    </dl>
                </li>
                <li>
                    <div class="divImg">
                        <a href="#"><img src="temp/01.png" width="184" height="123" /></a>
                        <div class="rgba_div"></div>
                        <div class="parent pos_abs"><span class="huifu con_color"><b class="icons"></b>1890</span><span class="zan con_color"><b class="icons"></b>1890</span></div>
                    </div>
                    <dl>
                        <dt><a href="#">春游活动</a></dt>
                        <dd>时间：2018-05-16 至 2018-06-12</dd>
                        <dd>地点：北京市香山公园</dd>
                        <dd>发起：社区学院</dd>
                        <dd style="margin-top:6px;"><a class="chakan" href="#">查看活动</a></dd>
                    </dl>
                </li>
                <li>
                    <div class="divImg">
                        <a href="#"><img src="temp/01.png" width="184" height="123" /></a>
                        <div class="rgba_div"></div>
                        <div class="parent pos_abs"><span class="huifu con_color"><b class="icons"></b>1890</span><span class="zan con_color"><b class="icons"></b>1890</span></div>
                    </div>
                    <dl>
                        <dt><a href="#">春游活动</a></dt>
                        <dd>时间：2018-05-16 至 2018-06-12</dd>
                        <dd>地点：北京市香山公园</dd>
                        <dd>发起：社区学院</dd>
                        <dd style="margin-top:6px;"><a class="chakan" href="#">查看活动</a></dd>
                    </dl>
                </li>
                <li>
                    <div class="divImg">
                        <a href="#"><img src="temp/01.png" width="184" height="123" /></a>
                        <div class="rgba_div"></div>
                        <div class="parent pos_abs"><span class="huifu con_color"><b class="icons"></b>1890</span><span class="zan con_color"><b class="icons"></b>1890</span></div>
                    </div>
                    <dl>
                        <dt><a href="#">春游活动</a></dt>
                        <dd>时间：2018-05-16 至 2018-06-12</dd>
                        <dd>地点：北京市香山公园</dd>
                        <dd>发起：社区学院</dd>
                        <dd style="margin-top:6px;"><a class="chakan" href="#">查看活动</a></dd>
                    </dl>
                </li>
                <li>
                    <div class="divImg">
                        <a href="#"><img src="temp/01.png" width="184" height="123" /></a>
                        <div class="rgba_div"></div>
                        <div class="parent pos_abs"><span class="huifu con_color"><b class="icons"></b>1890</span><span class="zan con_color"><b class="icons"></b>1890</span></div>
                    </div>
                    <dl>
                        <dt><a href="#">春游活动</a></dt>
                        <dd>时间：2018-05-16 至 2018-06-12</dd>
                        <dd>地点：北京市香山公园</dd>
                        <dd>发起：社区学院</dd>
                        <dd style="margin-top:6px;"><a class="chakan" href="#">查看活动</a></dd>
                    </dl>
                </li>
                <li>
                    <div class="divImg">
                        <a href="#"><img src="temp/01.png" width="184" height="123" /></a>
                        <div class="rgba_div"></div>
                        <div class="parent pos_abs"><span class="huifu con_color"><b class="icons"></b>1890</span><span class="zan con_color"><b class="icons"></b>1890</span></div>
                    </div>
                    <dl>
                        <dt><a href="#">春游活动</a></dt>
                        <dd>时间：2018-05-16 至 2018-06-12</dd>
                        <dd>地点：北京市香山公园</dd>
                        <dd>发起：社区学院</dd>
                        <dd style="margin-top:6px;"><a class="chakan" href="#">查看活动</a></dd>
                    </dl>
                </li>
                <li>
                    <div class="divImg">
                        <a href="#"><img src="temp/01.png" width="184" height="123" /></a>
                        <div class="rgba_div"></div>
                        <div class="parent pos_abs"><span class="huifu con_color"><b class="icons"></b>1890</span><span class="zan con_color"><b class="icons"></b>1890</span></div>
                    </div>
                    <dl>
                        <dt><a href="#">春游活动</a></dt>
                        <dd>时间：2018-05-16 至 2018-06-12</dd>
                        <dd>地点：北京市香山公园</dd>
                        <dd>发起：社区学院</dd>
                        <dd style="margin-top:6px;"><a class="chakan" href="#">查看活动</a></dd>
                    </dl>
                </li>
                <li>
                    <div class="divImg">
                        <a href="#"><img src="temp/01.png" width="184" height="123" /></a>
                        <div class="rgba_div"></div>
                        <div class="parent pos_abs"><span class="huifu con_color"><b class="icons"></b>1890</span><span class="zan con_color"><b class="icons"></b>1890</span></div>
                    </div>
                    <dl>
                        <dt><a href="#">春游活动</a></dt>
                        <dd>时间：2018-05-16 至 2018-06-12</dd>
                        <dd>地点：北京市香山公园</dd>
                        <dd>发起：社区学院</dd>
                        <dd style="margin-top:6px;"><a class="chakan" href="#">查看活动</a></dd>
                    </dl>
                </li>
                <li>
                    <div class="divImg">
                        <a href="#"><img src="temp/01.png" width="184" height="123" /></a>
                        <div class="rgba_div"></div>
                        <div class="parent pos_abs"><span class="huifu con_color"><b class="icons"></b>1890</span><span class="zan con_color"><b class="icons"></b>1890</span></div>
                    </div>
                    <dl>
                        <dt><a href="#">春游活动</a></dt>
                        <dd>时间：2018-05-16 至 2018-06-12</dd>
                        <dd>地点：北京市香山公园</dd>
                        <dd>发起：社区学院</dd>
                        <dd style="margin-top:6px;"><a class="chakan" href="#">查看活动</a></dd>
                    </dl>
                </li>
            </ul>
            <div class="pagination">
                <a class="first" href="">首页</a><a class="pre" href="">上一页</a><a href="">1</a><a href="">2</a><a class="cur" href="">3</a><a href="">4</a><a href="">5</a><a href="#" class="next">下一页</a><a href="">尾页</a>
            </div>
        </div>--%>
    </div>
</div>
<script>
    function get_data(url) {
        $.ajax({
            type: "GET",
            url: url,
            //data: {},
            dataType: "html",
            success: function(data){
                $('#right_content').empty();   //清空right_content里面的所有内容
                $("#right_content").html(data);
            }
        });

        /*$.ajax({ url: url, success: function(data){
            $("#right_content").html(data);
        }});*/
    }

    //左侧分类
    $(".main_left ul a").click(function(){
        var url = $(this).attr("href");
        get_data("/activities.html");
    });

</script>

<script type="text/javascript" src="/static/template/common/js/com_index.js"></script>
</body>
</html>
