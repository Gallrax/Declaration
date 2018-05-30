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
        <ul>
            <li>
                <div class="form_title"><span>*</span>作者：</div>
                <input name="" type="text" class="fidtext"/>
                <div class="prompt_div">
                    <div class="prompt_text"><b class="icons"></b>名字后面请用；隔开</div>
                </div>
            </li>
            <li>
                <div class="form_title"><span>*</span>联系方式：</div>
                <input name="" type="text" class="fidtext"/>
                <div class="prompt_div">
                    <div class="prompt_text"><b class="icons"></b>*号为必填信息</div>
                </div>
            </li>
            <li>
                <div class="form_title"><span>*</span>作品标题：</div>
                <input name="" type="text" class="fidtext"/>
                <div class="prompt_div">
                    <div class="prompt_text"><b class="icons"></b>*号为必填信息</div>
                </div>
            </li>
            <li>
                <div class="form_title">作品封面：</div>
                <input name="" type="text" class="fidtext"/>
                <div class="prompt_div"></div>
            </li>
            <li>
                <div class="form_title">主讲人介绍：</div>
                <textarea class="fidtextarea"></textarea>
                <div class="prompt_div"></div>
            </li>
            <li>
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
            </li>
            <li>
                <div class="form_title"><span>*</span>文件格式：</div>
                <select name="" class="form_select">
                    <option>图片</option>
                    <option>视频</option>
                </select>
                <div class="prompt_div">
                    <div class="prompt_text"><b class="icons"></b>*号为必填信息</div>
                </div>
            </li>
            <li>
                <div class="form_title"><span>*</span>选择作品：</div>
                <input name="" type="text" class="fidtext"/>
                <div class="file-style"><input type="file" onChange="add_files(this.files)" id="file" name="file">请选择文件
                </div>
                <div class="prompt_div">
                    <div class="prompt_text"><b class="icons"></b>*号为必填信息</div>
                </div>
            </li>
            <li>
                <div class="form_title">已上传作品：</div>
                <input name="" type="text" class="fidtext"/>
                <div class="prompt_div"></div>
            </li>
            <li>
                <div class="form_title">附件：</div>
                <input name="" type="text" class="fidtext"/>
                <div class="file-style"><input type="file" onChange="add_files(this.files)" id="file" name="file">请选择文件
                </div>
                <div class="prompt_div"></div>
            </li>
            <li>
                <div class="form_title">作品简介：</div>
                <textarea class="fidtextarea"></textarea>
                <div class="prompt_div"></div>
            </li>
            <li>
                <div class="form_title"></div>
                <input name="" type="button" value="提交" class="bnt_input"/>
                <a class="bnt_return" href="#">返回</a>
            </li>
        </ul>
    </div>
</div>
