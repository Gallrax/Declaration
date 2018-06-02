package com.cxgt.controller;


import cn.hutool.core.lang.Assert;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.util.ResultUtil;
import com.cxgt.commmon.vo.Result;
import com.cxgt.entity.SeriesUser;
import com.cxgt.service.SeriesUserService;
import com.cxgt.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
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
    private UserService userService;

    @SimpleLog
    @RequiresPermissions("sys:series_user:update")
    @RequestMapping("/update")
    @ResponseBody
    public Result update(SeriesUser seriesUser) {
        Integer seriesUserId = seriesUser.getId();
        SeriesUser tempSeriesUser = seriesUserService.selectById(seriesUserId);
        Assert.notNull(tempSeriesUser);
        seriesUserService.updateById(seriesUser);
        return ResultUtil.ok();
    }


	
}
