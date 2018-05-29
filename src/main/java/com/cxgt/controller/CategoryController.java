package com.cxgt.controller;


import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.util.ResultUtil;
import com.cxgt.commmon.vo.Result;
import com.cxgt.entity.Category;
import com.cxgt.entity.Site;
import com.cxgt.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/category")
public class CategoryController extends BaseController {

    private static final Logger LOG = Logger.getLogger(CategoryController.class);
    @Autowired
    CategoryService categoryService;

    @SimpleLog
    @RequestMapping("/categorys")
    @ResponseBody
    public Result<Category> categorys(HttpServletRequest request) {
        return null;
    }

    @SimpleLog
    @RequestMapping("/tree")
    @ResponseBody
    public Result tree(HttpServletRequest request) {
        Site site = getSite(request);
        Category category = categoryService.selectOne(new EntityWrapper<Category>().eq("site_id", site.getId()).eq("lv", 0));
        List<Category> categories = categoryService.selectChildrenByPid(category.getId());
        category.setChildren(categories);
        return ResultUtil.ok(categories);
    }

    @SimpleLog
    @RequestMapping("/{id}")
    @ResponseBody
    public Result category(@PathVariable Integer id, HttpServletRequest request) {
        Site site = getSite(request);
        Category category = categoryService.selectById(id);
        Assert.isFalse(category.getSiteId().equals(site.getId()));
        return ResultUtil.ok(category);
    }

}
