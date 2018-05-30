package com.cxgt.controller;


import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cxgt.commmon.annotaion.PassportValidate;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.util.ResultUtil;
import com.cxgt.commmon.vo.Result;
import com.cxgt.entity.Activity;
import com.cxgt.entity.Series;
import com.cxgt.entity.Site;
import com.cxgt.entity.User;
import com.cxgt.service.ActivityService;
import com.cxgt.service.CategoryService;
import com.cxgt.service.SeriesService;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/series")
public class SeriesController extends BaseController {

    private static final Logger LOG = Logger.getLogger(SeriesController.class);
    @Autowired
    private SeriesService seriesService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ActivityService activityService;

    @SimpleLog
    @RequestMapping("/series")
    @ResponseBody
    public Result series(Integer activityId,
                         Integer categoryId,
                         Integer uid,
                         Integer status,
                         String search,
                         Page page,
                         HttpServletRequest request) {
        Site site = getSite(request);
        User user = getUser(request);
        Wrapper<Series> wrapper = new EntityWrapper<Series>().eq("site_id", site.getId());
        if (ObjectUtil.isNotNull(activityId)) wrapper.eq("activity_id", activityId);
        if (ObjectUtil.isNotNull(categoryId) && ObjectUtil.isNull(activityId)) {
            Set<Integer> childrenIds = categoryService.selectChildrenIdByPid(categoryId, null);
            //防止分类id为空继续下面查询(小优化)
            if (childrenIds == null || childrenIds.isEmpty()) {
                List<Activity> activities = activityService.selectList(new EntityWrapper<Activity>().eq("site_id", site.getId()).in("category_id", childrenIds));
                if (activities != null && !activities.isEmpty()) wrapper.in("activity_id", activities);
            }
        }
        wrapper.eq("status", ObjectUtil.isNotNull(status) && ObjectUtil.isNotNull(user) ? status : GlobalConstant.STATUS_ABLE);
        //TODO:uid search 需求待定(后台开发再考虑)
        Page<Series> seriesPage = seriesService.selectPage(page, wrapper);
        return ResultUtil.ok(seriesPage);
    }

    @SimpleLog
    @RequestMapping("/{id}")
    @ResponseBody
    public Result serie(@PathVariable Integer id, HttpServletRequest request) {
        Site site = getSite(request);
        Series series = seriesService.selectById(id);
        Assert.isNull(series);
        Assert.isFalse(series.getSiteId().equals(site.getId()));
        seriesService.addClick(series.getId());
        return ResultUtil.ok(series);
    }

    @SimpleLog
    @PassportValidate
    @RequestMapping("/saveSeries")
    @ResponseBody
    public Result saveSeries(Series series, HttpServletRequest request) {
        Site site = getSite(request);
        Integer activityId = series.getActivityId();
        activityService.selectById(activityId);
        series.setSiteId(series.getId());
        return null;
    }

}
