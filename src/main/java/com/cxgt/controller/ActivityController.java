package com.cxgt.controller;


import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.util.ResultUtil;
import com.cxgt.commmon.vo.Result;
import com.cxgt.entity.Activity;
import com.cxgt.entity.Category;
import com.cxgt.entity.Site;
import com.cxgt.entity.User;
import com.cxgt.service.ActivityService;
import com.cxgt.service.CategoryService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 前端控制器
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
    @Autowired
    private CategoryService categoryService;

    @SimpleLog
    @RequestMapping("/activities")
    @ResponseBody
    public Result activities(Integer categoryId,
                             String search,
                             Integer status,
                             String beginTime,
                             String endTime,
                             Page<Activity> page,
                             HttpServletRequest request) {
        Site site = getSite(request);
        Wrapper<Activity> wrapper = new EntityWrapper<Activity>().eq("site_id", site.getId());
        User user = getUser(request);
        if (ObjectUtil.isNotNull(status) && ObjectUtil.isNotNull(user)) {
            wrapper.eq("status", status);
        } else {
            wrapper.ne("status", GlobalConstant.STATUS_UNABLE);
        }

        if (ObjectUtil.isNotNull(categoryId)) {
            Category category = categoryService.selectById(categoryId);
            boolean equals = category.getSiteId().equals(site.getId());
            Assert.isTrue(category.getSiteId().equals(site.getId()));//不匹配抛异常
            Set<Integer> childrenIds = categoryService.selectChildrenIdByPid(categoryId, null);
            childrenIds.add(categoryId);
            wrapper.in("category_id", childrenIds);
        }
        //TODO: search search beginTime endTime 需求待定(后台开发再考虑)
        Page<Activity> activityPage = activityService.selectPage(page, wrapper);
        return ResultUtil.ok(activityPage);
    }

    @SimpleLog
    @RequestMapping("/{id}")
    @ResponseBody
    public Result activity(@PathVariable Integer id, HttpServletRequest request) {
        Site site = getSite(request);
        Activity activity = activityService.selectById(id);
        Assert.notNull(activity);
        Assert.isTrue(activity.getSiteId().equals(site.getId()));
        activityService.addClick(activity.getId());
        return ResultUtil.ok(activity);
    }

    @SimpleLog
    @RequiresPermissions("sys:activity:insert")
    @RequestMapping("/saveActivity")
    @ResponseBody
    public Result saveActivity(Activity activity, HttpServletRequest request) {
        Site site = getSite(request);
        User user = getUser(request);
//        Assert.notNull(activity.getCategoryId());
        activity.setUserId(user.getId());
        activity.setSiteId(site.getId());
        Date date = new Date();
        activity.setInsertTime(date);
        activity.setInsertTimeMs(date.getTime());
        activityService.insert(activity);
        return ResultUtil.ok();
    }

}
