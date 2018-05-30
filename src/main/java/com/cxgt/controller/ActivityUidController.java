package com.cxgt.controller;


import cn.hutool.core.lang.Assert;
import cn.hutool.extra.servlet.ServletUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.util.ResultUtil;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 前端控制器
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
        check(activity, site);
        //TODO:是否根据状态查询待定
        Page<ActivityUid> activityUidPage = activityUidService.selectPage(page, new EntityWrapper<ActivityUid>().eq("activity_id", activity.getId()));
        return ResultUtil.ok(activityUidPage);
    }

    @SimpleLog
    @RequestMapping("/join")
    @ResponseBody
    public Result join(Integer activityId, HttpServletRequest request) {
        Site site = getSite(request);
        Activity activity = activityService.selectById(activityId);
        check(activity, site);
        Cookie uid = ServletUtil.getCookie(request, "uid");
        Assert.isNull(uid);
        Cookie username = ServletUtil.getCookie(request, "username");
        Cookie nickname = ServletUtil.getCookie(request, "nickname");
        ActivityUid activityUid = new ActivityUid();
        activityUid.setActivityId(activityId);
        activityUid.setNickname(nickname == null ? null : nickname.getValue());
        activityUid.setUsername(username.getValue());
        activityUid.setUid(Integer.parseInt(uid.getValue()));
        Date date = new Date();
        activityUid.setInsertTime(date);
        activityUid.setInsertTimeMs(date.getTime());
        return null;
    }

    private void check(Activity activity, Site site) {
        Assert.isNull(activity);
        Assert.isTrue(activity.getStatus().equals(GlobalConstant.STATUS_UNABLE) || !activity.getSiteId().equals(site.getId()));
    }


}
