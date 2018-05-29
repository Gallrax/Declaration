package com.cxgt.controller;


import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.vo.Result;
import com.cxgt.entity.Activity;
import com.cxgt.entity.ActivityUid;
import com.cxgt.entity.Site;
import com.cxgt.service.ActivityService;
import com.cxgt.service.ActivityUidService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2018-05-29
 */
@Controller
@RequestMapping("/activityUid")
public class ActivityUidController extends BaseController {

    private static final Logger LOG = Logger.getLogger(ActivityUidController.class);
    @Autowired
    private ActivityUidService activityUidService;
    @Autowired
    private ActivityService activityService;

    @SimpleLog
    @RequestMapping("/users")
    @ResponseBody
    public Result users(Integer activityId,
                        Page page,
                        HttpServletRequest request) {
        Site site = getSite(request);
        Activity activity = activityService.selectById(activityId);
        Assert.isNull(activity);
        Assert.isTrue(activity.getStatus().equals(GlobalConstant.STATUS_UNABLE) || !activity.getSiteId().equals(site.getId()));
        activityUidService.selectPage(page, new EntityWrapper<ActivityUid>().eq("activity_id", activity));
        return null;
    }


}
