package com.cxgt.service.impl;

import com.cxgt.entity.Log;
import com.cxgt.mapper.LogMapper;
import com.cxgt.service.LogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-26
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    private static final Logger LOG = Logger.getLogger(LogServiceImpl.class);

    @Async
    @Override
    public boolean insert(Log log) {
        LOG.info(Thread.currentThread().toString() + " : LogServiceImpl.insert()");
        return super.insert(log);
    }
}
