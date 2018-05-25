package com.cxgt.service.impl;

import com.cxgt.entity.Category;
import com.cxgt.mapper.CategoryMapper;
import com.cxgt.service.CategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
	
}
