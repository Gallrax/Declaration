<%--
  Created by IntelliJ IDEA.
  User: gao
  Date: 2018/5/29
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main_right rightF">
    <div class="return_content"><a class="bnt_return" href="#"><b class="icons"></b>返回</a></div>

    <div class="course_upload">
        <div class="upload_title">课程上传</div>
        <form id="seriesForm" enctype="multipart/form-data">
            <ul>
                <li>
                    <div class="form_title"><span>*</span>作者：</div>
                    <input id="seriesAuthor" name="author" type="text" class="fidtext"/>
                    <div class="prompt_div">
                        <div class="prompt_text"><b class="icons"></b>名字后面请用；隔开</div>
                    </div>
                </li>
                <li>
                    <div class="form_title"><span>*</span>联系方式：</div>
                    <input id="seriesPhone" name="phone" type="text" class="fidtext"/>
                    <div class="prompt_div">
                        <div class="prompt_text"><b class="icons"></b>*号为必填信息</div>
                    </div>
                </li>
                <li>
                    <div class="form_title"><span>*</span>作品标题：</div>
                    <input id="seriesName" name="name" type="text" class="fidtext"/>
                    <div class="prompt_div">
                        <div class="prompt_text"><b class="icons"></b>*号为必填信息</div>
                    </div>
                </li>
                <li>
                    <div class="form_title">作品封面：</div>
                    <input name="logo" type="text" class="fidtext"/>
                    <div class="prompt_div"></div>
                </li>
                <li>
                    <div class="form_title">主讲人介绍：</div>
                    <textarea name="authorIntro" class="fidtextarea"></textarea>
                    <div class="prompt_div"></div>
                </li>
                <%--<li>
                    <div class="form_title">分类：</div>
                    <select name="" class="form_select" style="width:80px;">
                        <option>2018</option>
                        <option>2017</option>
                        <option>2016</option>
                        <option>2015</option>
                    </select>
                    <select name="" class="form_select" style="width:180px;margin-left:20px;">
                        <option>春季微课大赛</option>
                        <option>秋季微课大赛</option>
                        <option>冬季微课大赛</option>
                        <option>夏季微课大赛</option>
                    </select>
                    <div class="prompt_div"></div>
                </li>--%>
                <li>
                    <div class="form_title"><span>*</span>文件格式：</div>
                    <select name="fileType" class="form_select">
                        <option>图片</option>
                        <%--<option>视频</option>--%>
                    </select>
                    <div class="prompt_div">
                        <div class="prompt_text"><b class="icons"></b>*号为必填信息</div>
                    </div>
                </li>
                <li>
                    <div class="form_title"><span>*</span>选择作品：</div>
                    <input id="resourceName" name="resourceName" type="text" class="fidtext" readonly="readonly"/>
                    <div class="file-style"><input type="file" onChange="uploadFile()" id="file" name="file"
                                                   accept=".png" multiple>请选择文件
                    </div>
                    <div class="prompt_div">
                        <div class="prompt_text"><b class="icons"></b>*号为必填信息</div>
                    </div>
                </li>
                <%--<li>
                    <div class="form_title">已上传作品：</div>
                    <input type="text" class="fidtext"/>
                    <div class="prompt_div"></div>
                </li>--%>
                <%--<li>
                    <div class="form_title">附件：</div>
                    <input name="" type="text" class="fidtext"/>
                    <div class="file-style"><input type="file" onChange="uploadFile(this.files)" id="file" name="file">请选择文件
                    </div>
                    <div class="prompt_div"></div>
                </li>--%>
                <li>
                    <div class="form_title">作品简介：</div>
                    <textarea name="intro" class="fidtextarea"></textarea>
                    <div class="prompt_div"></div>
                </li>
                <li>
                    <div class="form_title"></div>
                    <input id="activityId" type="hidden" name="activityId"/>
                    <input type="hidden" name="objectid" id="objectid">
                    <input type="button" value="提交" class="bnt_input" onclick="subSeriesForm()"/>
                    <a class="bnt_return" href="#">返回</a>
                </li>
            </ul>
        </form>
    </div>
</div>

<script type="text/javascript" src="/static/template/common/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/static/template/common/js/com_index.js"></script>
<script>
    function subSeriesForm() {
        $("#activityId").val(globalActivityId);
        var sereisAuthor = $("#seriesAuthor").val();
        var seriesName = $("#seriesName").val();
        var sereisPhone = $("#seriesPhone").val();
        var resourceName = $("#resourceName").val();
        if (sereisAuthor == null || sereisAuthor == '') {
            alert("请输入作者！");
            return false;
        }
        if (sereisPhone == null || sereisPhone == '') {
            alert("请输入联系方式！");
            return false;
        }
        if (seriesName == null || seriesName == '') {
            alert("请输入作品标题！");
            return false;
        }
        if (resourceName == null || resourceName == '') {
            alert("请上传文件！");
            return false;
        }
        //异步提交表单
        $.ajax({
            url: "/series/saveSeries",
            data: $("#seriesForm").serialize(),
            type: "post",
            success: function (data) {
                console.log(data);
            }
        });
    }

    function uploadFile() {
        var formData = new FormData();
        var files = $("#file").get(0).files;
        console.log(files);
        for (var i in files) {
            $("#tempResourceName").val(files[i].name);
            formData.append("files", files[i]);
        }
        $.ajax({
            url: "/upload",
            type: "post",
            contentType: false,
            processData: false,
            data: formData,
            success: function (data) {
                var result = $.parseJSON(data);
                console.log(result);
                if (result.code == 200) {
                    var obj = $.parseJSON(result.data);
                    var tempStr = "";
                    for(var i in obj){
                        tempStr += obj[i].name +",";
                    }
                    $("#resourceName").val(tempStr);
                }
            }
        })
    }
</script>
