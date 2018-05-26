package com.cxgt.controller;


import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.entity.Category;
import com.cxgt.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    private static final Logger logger = Logger.getLogger(CategoryController.class);
    @Autowired
    CategoryService categoryService;

    @SimpleLog
    @RequestMapping("/categorys")
    @ResponseBody
    public List<Category> categorys() {
        List<Category> categories = categoryService.selectList(null);
        return categories;
    }
	
}
