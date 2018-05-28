package com.cxgt.controller;


import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.vo.Result;
import com.cxgt.service.SeriesService;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
@Controller
@RequestMapping("/series")
public class SeriesController extends BaseController {

    private static final Logger LOG = Logger.getLogger(SeriesController.class);
    @Autowired
    private SeriesService seriesService;

    @SimpleLog
    @RequestMapping("/series")
    @ResponseBody
    public Result series(Integer activityId,
                         Integer categoryId,
                         HttpServletRequest request) {

        return null;
    }

}
