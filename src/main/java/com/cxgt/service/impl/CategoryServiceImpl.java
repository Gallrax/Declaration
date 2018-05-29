package com.cxgt.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cxgt.entity.Category;
import com.cxgt.mapper.CategoryMapper;
import com.cxgt.service.CategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Set<Integer> selectChildrenIdByPid(Integer pid, Set<Integer> set) {
        if(set == null) set = new HashSet<Integer>();
        List<Category> categories = categoryMapper.selectList(new EntityWrapper<Category>().eq("pid", pid));
        for (Category category : categories) {
            set.add(category.getId());
            selectChildrenIdByPid(category.getId(), set);
        }
        return set;
    }

    @Override
    public List<Category> selectChildrenByPid(Integer pid) {
        List<Category> categories = categoryMapper.selectList(new EntityWrapper<Category>().eq("pid", pid));
        for (Category category : categories) {
            category.setChildren(selectChildrenByPid(category.getId()));
        }
        return categories;
    }
}
