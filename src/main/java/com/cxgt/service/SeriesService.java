package com.cxgt.service;

import com.cxgt.entity.Series;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
public interface SeriesService extends IService<Series> {

    void addClick(Integer seriesId);
	
}
