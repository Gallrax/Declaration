package com.cxgt.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.util.ResultUtil;
import com.cxgt.commmon.vo.Result;
import com.cxgt.entity.Resource;
import com.cxgt.entity.Series;
import com.cxgt.entity.Site;
import com.cxgt.service.ResourceService;
import com.cxgt.service.SeriesService;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    private static final Logger LOG = Logger.getLogger(ResourceController.class);
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private SeriesService seriesService;

    @SimpleLog
    @RequestMapping("/resources")
    @ResponseBody
    public Result resources(Integer seriesId,
                            Page page,
                            HttpServletRequest request) {
        Site site = getSite(request);
        Series series = seriesService.selectById(seriesId);
        Assert.notNull(series);
        Assert.isTrue(series.getSiteId().equals(site.getId()));
        Page<Resource> resourcePage = resourceService.selectPage(page, new EntityWrapper<Resource>().eq("series_id", series.getId()));
        List<Resource> resourceList = new ArrayList<>();
        for (Resource resource : resourcePage.getRecords()) {
            if (StrUtil.isNotEmpty(resource.getFileRoute())) continue;
            String objectid = resource.getObjectid();
            String result = HttpUtil.get("http://cs.ananas.chaoxing.com/status/" + objectid);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.get("status").equals("success")) {
                resource.setFileRoute(jsonObject.get("http").toString());
                resourceList.add(resource);
            }
        }
        if (CollectionUtil.isNotEmpty(resourceList)) resourceService.updateBatchById(resourceList);
        return ResultUtil.ok(resourcePage);
    }

}
