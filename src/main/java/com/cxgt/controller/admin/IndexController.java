package com.cxgt.controller.admin;

import com.cxgt.commmon.controller.BaseController;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/26
 */
@Controller("/adminIndexController")
@RequestMapping("/admin")
public class IndexController extends BaseController {

    @RequestMapping("/login.html")
    public String login(HttpServletRequest request) {
        return "template/admin/login/login";
    }

    @RequestMapping(value = {"/index.html", "/"})
    public String index(HttpServletRequest request) {
        return "template/admin/index";
    }

    @RequestMapping("/activity/activities.html")
    public String activities() {
        return "template/admin/activity/activities";
    }

    @RequestMapping("/activity/addActivity.html")
    public String addActivity() {
        return "template/admin/activity/addActivity";
    }

    @RequestMapping("/series/series.html")
    public String series() {
        return "template/admin/series/series";
    }

    @RequestMapping("/series/seriesInfo.html")
    public String addSeries() {
        return "template/admin/series/seriesInfo";
    }

    @RequestMapping("/seriesUser/addSeriesUser.html")
    public String addSeriesUser() {
        return "template/admin/seriesUser/addSeriesUser";
    }

    @RequestMapping("/seriesUser/updateSeriesUser.html")
    public String updateSeriesUser() {
        return "template/admin/seriesUser/updateSeriesUser";
    }

}
