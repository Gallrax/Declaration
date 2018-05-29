package com.cxgt.service;

import com.cxgt.entity.Activity;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
public interface ActivityService extends IService<Activity> {

    void addClick(Integer activityId);
	
}
