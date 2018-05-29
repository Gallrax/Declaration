package com.cxgt.controller;


import com.cxgt.commmon.controller.BaseController;
import com.cxgt.service.SeriesUserService;
import com.cxgt.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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
    private SeriesUserService seriesUidService;
    @Autowired
    private UserService userService;




	
}
