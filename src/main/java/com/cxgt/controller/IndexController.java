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
}
