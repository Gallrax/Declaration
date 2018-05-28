package com.cxgt.controller;


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
    public List<Category> categorys() {
        List<Category> categories = categoryService.selectList(null);
        return categories;
    }

    @SimpleLog
    @RequestMapping("/tree")
    @ResponseBody
    public Result tree(HttpServletRequest request) {
        Site site = getSite(request);
//        暂时不考虑优化查询并只支持二级分类(后期可考虑查询所有分类，通过递归方式排树)
        List<Category> categories = categoryService.selectList(new EntityWrapper<Category>().eq("siteId", site.getId()).eq("lv", 1));
        for (Category category : categories) {
            List<Category> children = categoryService.selectList(new EntityWrapper<Category>().eq("pid", category.getId()));
            category.setChildren(children);
        }
        return ResultUtil.ok(categories);
    }

}
