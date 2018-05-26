package com.cxgt.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/26
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

    @RequestMapping("/login.html")
    public String login() {
        return "/admin/login/login";
    }

    @RequestMapping(value = {"/index.html", "/"})
    public String index() {
        return "/admin/index";
    }

}
