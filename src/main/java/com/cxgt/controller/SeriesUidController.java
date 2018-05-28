package com.cxgt.controller;


import com.cxgt.service.SeriesUidService;
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
@RequestMapping("/seriesUid")
public class SeriesUidController {

    private static final Logger logger = Logger.getLogger(SeriesUidController.class);
    @Autowired
    private SeriesUidService seriesUidService;
	
}
