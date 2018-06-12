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
    public Result seriesUser(@PathVariable("id") Integer seriesId, HttpServletRequest request) {
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
    public Result update(Integer[] seriesIds, String name, String reason, HttpServletRequest request) {
        User user = getUser(request);
        //后期可优化此部分至遍历处
        for (Integer seriesId : seriesIds) {
            checkSeries(seriesId, seriesService, request);
        }
        //方式1:不单个检查，直接查询，只检查结果数量是否一致
        List<SeriesUser> seriesUsers = seriesUserService.selectList(new EntityWrapper<SeriesUser>().eq("user_id", user.getId()).in("series_id", seriesIds));
        Assert.isTrue(seriesIds.length == seriesUsers.size());
        for (SeriesUser seriesUser : seriesUsers) {
            seriesUser.setName(name);
            seriesUser.setReason(reason);
        }
        seriesUserService.updateBatchById(seriesUsers);
        //方式2:单个检查，安全系数最高
        /*for (Integer seriesId : seriesIds) {
            Integer seriesUserId = seriesId;
            SeriesUser tempSeriesUser = seriesUserService.selectById(seriesUserId);
            Assert.notNull(tempSeriesUser);
            checkUser(tempSeriesUser.getUserId(), userService, request);
            Series series = seriesService.selectById(seriesId);
            checkSeries(series.getId(), seriesService, request);
            tempSeriesUser.setName(name);
            seriesUserService.updateById(tempSeriesUser);
        }*/
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
