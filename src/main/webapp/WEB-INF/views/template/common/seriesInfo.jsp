<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main_right rightF">
    <div class="return_content"><a class="bnt_return" href="#"><b class="icons"></b>返回</a></div>
    <div class="title_deta"><h3 id="seriesName">秋季微课大赛</h3><span><b style="font-size:16px;">&middot;</b> 本系列被观看1239次、被2人平分、平均分4.5</span>
    </div>
    <div class="video_card clearfix">
        <a title="秋季微课大赛" href="#"><img id="seriesLogo" src="temp/01.png"/></a>
        <div class="play_number rightF">一等奖</div>
        <dl>
            <dd><span class="text">主讲：<span id="seriesAuthor">周树人</span></span><span class="text">单位：<span id="seriesCompany">中国人民大学</span></span></dd>
            <dd id="seriesIntro">本系列主要讲述了茶的种类、如何正确的品茶、茶对人体的好处、还介绍了体验绿茶、布置茶席、正山小种的茶香、茶味、茶理和茶的自然。</dd>
            <dd><a class="bnt_play" href="#">立即播放</a></dd>
        </dl>
    </div>
    <div class="act_content">
        <div class="act_title"><h2><b class="icons"></b>视频列表</h2></div>
        <div class="video_set_list">
            <ul>
                <%--<li><a href="#">1、第一集 解密《周树人》的秘密</a></li>
                <li><a href="#">2、第二集 解密《周树人》的秘密</a></li>
                <li><a href="#">3、第三集 解密《周树人》的秘密</a></li>
                <li><a href="#">4、第四集 解密《周树人》的秘密</a></li>
                <li><a href="#">5、第五集 解密《周树人》的秘密</a></li>
                <li><a href="#">6、第六集 解密《周树人》的秘密</a></li>--%>
            </ul>
        </div>
    </div>
    <div class="members">
        <div class="act_title"><h2><b class="icons"></b>主讲名师</h2></div>
        <div class="master_teacher">
            <p id="seriesAuthorIntro">文学院教授，文学博士。中国民主同盟河南大学委员会副主委，中国近代文学学会小说分会副会长，国家级精品课《中国近代文学史》主讲人，国家级教学团队中国现当代文学教学团队骨干成员。</p>
        </div>
    </div>
</div>
<script type="text/javascript" src="/static/template/common/js/jquery-1.7.2.min.js"></script>
<script>
    $(function () {
        var seriesId = getUrlParam("seriesId");
        getSeries(seriesId);
    });

    function getSeries(seriesId) {
        $.ajax({
            url:"/series/"+ seriesId,
            type:"get",
            success:function (data) {
                var result = $.parseJSON(data);
                if (result.code == 200) {
                    var obj = result.data;
                    $("#seriesName").html(obj.name);
                    $("#seriesAuthor").html(obj.author);
                    $("#seriesCompany").html(obj.company);
                    $("#seriesIntro").html(obj.intro);
                    $("#seriesAuthorIntro").html(obj.authorIntro);
                    $("#seriesLogo").attr("src", obj.logo);
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
