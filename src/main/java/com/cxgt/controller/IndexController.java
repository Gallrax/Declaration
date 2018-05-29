package com.cxgt.controller;

import com.cxgt.commmon.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/28
 */
@Controller
@RequestMapping("")
public class IndexController extends BaseController {

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

}
