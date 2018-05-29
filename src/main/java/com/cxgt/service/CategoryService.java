package com.cxgt.service;

import com.cxgt.entity.Category;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
public interface CategoryService extends IService<Category> {


    Set<Integer> selectChildrenIdByPid(Integer pid, Set<Integer> set);

    List<Category> selectChildrenByPid(Integer pid);

}
