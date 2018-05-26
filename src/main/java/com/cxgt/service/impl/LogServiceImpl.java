package com.cxgt.service.impl;

import com.cxgt.entity.Log;
import com.cxgt.mapper.LogMapper;
import com.cxgt.service.LogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
	
}
