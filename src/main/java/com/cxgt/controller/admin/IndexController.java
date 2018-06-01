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

    @RequestMapping("/series/series.html")
    public String series() {
        return "template/admin/series/series";
    }

}
