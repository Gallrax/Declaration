package com.cxgt.controller;


import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.vo.Result;
import com.cxgt.service.ActivityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
@Controller
@RequestMapping("/activity")
public class ActivityController extends BaseController {

    private static final Logger LOG = Logger.getLogger(ActivityController.class);
    @Autowired
    private ActivityService activityService;

    @SimpleLog
    @RequestMapping("/activities")
    @ResponseBody
    public Result activities(Integer categoryId,
                            String search,
                            HttpServletRequest request) {

        return null;
    }

    @SimpleLog
    @RequestMapping("/{id}")
    @ResponseBody
    public Result activity(@PathVariable Integer id) {

        return null;
    }

}
