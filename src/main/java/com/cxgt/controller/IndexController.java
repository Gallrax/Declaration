package com.cxgt.controller;

import cn.hutool.http.HttpUtil;
import com.cxgt.commmon.annotaion.PassportValidate;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.vo.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/28
 */
@Controller
@RequestMapping("")
public class IndexController extends BaseController {

    private static final Logger LOG = Logger.getLogger(IndexController.class);

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
        return toPage(request, "activity");
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
        return toPage(request, "series");
    }

    @RequestMapping("/addSeries.html")
    public String addSeries(HttpServletRequest request) {
        return toPage(request, "addSeries");
    }

    @SimpleLog
    @PassportValidate
    @RequestMapping("/upload")
    @ResponseBody
    public Result upload(@RequestParam(required = true) MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/static/upload");
        String filename = System.currentTimeMillis() + file.getOriginalFilename();
        final File tempFile = new File(path + "/" + filename);
        file.transferTo(tempFile);
        HashMap<String, Object> fileHashMap = new HashMap<>();
        fileHashMap.put("file", tempFile);
        String result = HttpUtil.post("http://cs.ananas.chaoxing.com/upload", fileHashMap);
        tempFile.delete();
        LOG.info(" result : " + result);
        return null;
    }

}
