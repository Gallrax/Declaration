package com.cxgt.controller.admin;


import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.controller.BaseController;
import com.cxgt.commmon.vo.Result;
import com.cxgt.service.LogService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-26
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(LogController.class);
    @Autowired
    private LogService logService;

    @SimpleLog
    @RequiresUser
    @RequestMapping("/logs")
    @ResponseBody
    public Result logs() {

        return null;
    }
	
}
