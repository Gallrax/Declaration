package com.cxgt.commmon.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.entity.*;
import com.cxgt.service.ActivityService;
import com.cxgt.service.CategoryService;
import com.cxgt.service.SeriesService;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    protected Site getSite(HttpServletRequest request) {
        Site site = (Site) request.getSession().getAttribute(GlobalConstant.SESSION_SITE);
        return site;
    }

    protected User getUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(GlobalConstant.SESSION_USER);
        return user;
    }

    protected Integer getUid() {
        return null;
    }

    protected Integer getFid() {
        return null;
    }

    protected String toPage(HttpServletRequest request, String value) {
        return "template/" + getSite(request).getTemplate() + "/" + value;
    }

    protected boolean checkCategory(Integer categoryId, CategoryService categoryService, HttpServletRequest request) {
        try {
            assertCategory(categoryId, categoryService, request);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected void assertCategory(Integer categoryId, CategoryService categoryService, HttpServletRequest request) {
        Category category = categoryService.selectById(categoryId);
        Assert.notNull(category);
        Assert.isTrue(category.getSiteId().equals(getSite(request).getId()));
    }

    protected boolean checkActivity(Integer activityId, ActivityService activityService, HttpServletRequest request) {
        try {
            assertActivity(activityId, activityService, request);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected void assertActivity(Integer activityId, ActivityService activityService, HttpServletRequest request) {
        Activity activity = activityService.selectById(activityId);
        Assert.notNull(activity);
        Assert.isTrue(activity.getSiteId().equals(getSite(request).getId()));
    }

    protected boolean checkSeries(Integer seriesId, SeriesService seriesService, HttpServletRequest request) {
        try {
            assertSeries(seriesId, seriesService, request);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected void assertSeries(Integer seriesId, SeriesService seriesService, HttpServletRequest request) {
        Series series = seriesService.selectById(seriesId);
        Assert.notNull(series);
        Assert.isTrue(series.getSiteId().equals(getSite(request).getId()));
    }

}
