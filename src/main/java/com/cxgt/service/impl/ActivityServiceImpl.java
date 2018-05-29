package com.cxgt.service.impl;

import com.cxgt.entity.Activity;
import com.cxgt.mapper.ActivityMapper;
import com.cxgt.service.ActivityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    private static final Logger LOG = Logger.getLogger(ActivityServiceImpl.class);
    @Autowired
    private ActivityMapper activityMapper;

    @Async
    @Override
    public void addClick(Integer activityId) {
        LOG.info(Thread.currentThread().toString() + " : ActivityServiceImpl.addClick()");
        Activity activity = activityMapper.selectById(activityId);
        Integer clickCount = activity.getClickCount();
        activity.setClickCount(clickCount == null ? 1 : ++clickCount);
        activityMapper.updateById(activity);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
