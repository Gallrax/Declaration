package com.cxgt.controller;


import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.vo.Result;
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
@RequestMapping("/resource")
public class ResourceController {

    @SimpleLog
    @RequestMapping("/resources")
    @ResponseBody
    public Result resources() {
        return null;
    }
	
}
