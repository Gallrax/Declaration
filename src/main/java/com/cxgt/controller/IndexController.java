package com.cxgt.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.cxgt.commmon.annotaion.PassportValidate;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.util.ResultUtil;
import com.cxgt.commmon.vo.Result;
import com.cxgt.entity.Resource;
import com.cxgt.service.ResourceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/28
 */
@Controller
@RequestMapping("")
public class IndexController extends BaseController {

    private static final Logger LOG = Logger.getLogger(IndexController.class);
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = {"/", "/index", "/index.html"})
    public String index(HttpServletRequest request) {
        return toPage(request, "index");
    }

    @RequestMapping("/activities.html")
    public String activities(HttpServletRequest request) {
        return toPage(request, "activities");
    }

    @RequestMapping("/activityInfo.html")
    public String activityInfo(HttpServletRequest request) {
        return toPage(request, "activityInfo");
    }

    @RequestMapping("/activityUsers.html")
    public String activityUsers(HttpServletRequest request) {
        return toPage(request, "activityUsers");
    }


    @RequestMapping("/series.html")
    public String series(HttpServletRequest request) {
        return toPage(request, "series");
    }

    @RequestMapping("/seriesInfo.html")
    public String seriesInfo(HttpServletRequest request) {
        return toPage(request, "seriesInfo");
    }

    @RequestMapping("/addSeries.html")
    public String addSeries(HttpServletRequest request) {
        return toPage(request, "addSeries");
    }

    @RequestMapping("/resourceInfo.html")
    public String resourceInfo(HttpServletRequest request) {
        return toPage(request, "resourceInfo");
    }

    @SimpleLog
    @PassportValidate
    @RequestMapping("/upload")
    @ResponseBody
    public Result upload(@RequestParam(required = true) MultipartFile[] files, HttpServletRequest request) throws IOException {
        List<File> tempFiles = new ArrayList<File>();
        for (MultipartFile file : files) {
            String path = request.getServletContext().getRealPath("/static/upload");
            String filename = System.currentTimeMillis() + file.getOriginalFilename();
            File tempFile = new File(path + "/" + filename);
            file.transferTo(tempFile);
            tempFiles.add(tempFile);
        }
        //生成资源List
        List<Resource> resources = new ArrayList<>();
        //设置排序
        int i = 0;
        for (File tempFile : tempFiles) {
            HashMap<String, Object> fileHashMap = new HashMap<>();
            fileHashMap.put("file", tempFile);
            String result = HttpUtil.post("http://cs.ananas.chaoxing.com/upload", fileHashMap);
            LOG.info(" result : " + result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            String objectid = (String) jsonObject.get("objectid");
            if (StrUtil.isNotEmpty(objectid)) {
                //增加Resource,返回无状态Resource,提交Series时再进行绑定
                //System.currentTimeMillis() 得到的是13位数字，因此砍掉
                Resource resource = new Resource();
                resource.setName(tempFile.getName().substring(13));
                resource.setObjectid(objectid);
                resource.setFileSize(tempFile.length());
                Date date = new Date();
                resource.setInsertTime(date);
                resource.setInsertTimeMs(date.getTime());
                resource.setSiteId(getSite(request).getId());
                resource.setSort(++i);
                resources.add(resource);
            }
        }
        //自动注入id
        resourceService.insertBatch(resources);
        return ResultUtil.ok(resources);
    }

}
