package com.cxgt.controller;


import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.util.ResultUtil;
import com.cxgt.commmon.vo.Result;
import com.cxgt.entity.Series;
import com.cxgt.entity.SeriesUser;
import com.cxgt.entity.User;
import com.cxgt.service.SeriesService;
import com.cxgt.service.SeriesUserService;
import com.cxgt.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
@Controller
@RequestMapping("/seriesUser")
public class SeriesUserController extends BaseController {

    private static final Logger LOG = Logger.getLogger(SeriesUserController.class);
    @Autowired
    private SeriesUserService seriesUserService;
    @Autowired
    private SeriesService seriesService;
    @Autowired
    private UserService userService;

    @SimpleLog
    @RequiresPermissions("sys:series_user:update")
    @RequestMapping("/{id}")
    @ResponseBody
    public Result seriesUser(@PathVariable Integer seriesId, HttpServletRequest request) {
        User user = getUser(request);
        Series series = seriesService.selectById(seriesId);
        checkSeries(seriesId, seriesService, request);
        SeriesUser seriesUser = seriesUserService.selectOne(new EntityWrapper<SeriesUser>().eq("series_id", seriesId).eq("user_id", user.getId()));
        Assert.notNull(seriesUser);
        return ResultUtil.ok(seriesUser);
    }

    @SimpleLog
    @RequiresPermissions("sys:series_user:update")
    @RequestMapping("/update")
    @ResponseBody
    public Result update(SeriesUser seriesUser, HttpServletRequest request) {
        Integer seriesUserId = seriesUser.getId();
        SeriesUser tempSeriesUser = seriesUserService.selectById(seriesUserId);
        Assert.notNull(tempSeriesUser);
        Series series = seriesService.selectById(seriesUser.getSeriesId());
        checkSeries(series.getId(), seriesService, request);
        seriesUserService.updateById(seriesUser);
        return ResultUtil.ok();
    }

    @SimpleLog
    @RequiresPermissions("sys:series_user:insert")
    @RequestMapping("/insert")
    @ResponseBody
    public Result insert(Integer seriesId, Integer[] userIds, HttpServletRequest request) {
        User user = getUser(request);
        assertSeries(seriesId, seriesService, request);
        //暂不确定是否允许再次选择审核人
        List<SeriesUser> seriesUsers = new ArrayList<>();
        for (Integer userId : userIds) {
            assertUser(userId, userService, request);
            SeriesUser seriesUser = new SeriesUser();
            seriesUser.setSeriesId(seriesId);
            seriesUser.setUserId(userId);
            seriesUsers.add(seriesUser);
        }
        seriesUserService.insertBatch(seriesUsers);
        return ResultUtil.ok();
    }

}
