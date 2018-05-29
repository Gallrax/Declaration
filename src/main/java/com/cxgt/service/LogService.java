package com.cxgt.service;

import com.cxgt.entity.Log;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-26
 */
public interface LogService extends IService<Log> {

    boolean insert(Log log);
	
}
