package com.cxgt.service.impl;

import com.cxgt.entity.Series;
import com.cxgt.mapper.SeriesMapper;
import com.cxgt.service.SeriesService;
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
public class SeriesServiceImpl extends ServiceImpl<SeriesMapper, Series> implements SeriesService {

    private static final Logger LOG = Logger.getLogger(SeriesServiceImpl.class);
    @Autowired
    private SeriesMapper seriesMapper;

    @Async
    @Override
    public void addClick(Integer seriesId) {
        LOG.info(Thread.currentThread().toString() + " : SeriesServiceImpl.addClick()");
        Series series = seriesMapper.selectById(seriesId);
        Integer clickCount = series.getClickCount();
        series.setClickCount(clickCount == null ? 1 : ++clickCount);
        seriesMapper.updateById(series);
    }
}
