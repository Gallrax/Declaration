package com.cxgt.test;

import com.cxgt.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/29
 */
public class CategoryTest {

    ApplicationContext context;
    CategoryService categoryService;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("spring/spring.xml");
        categoryService = context.getBean(CategoryService.class);
    }

    @Test
    public void test01() {
        Set<Integer> childrenIds = categoryService.selectChildrenIdByPid(3, null);
        System.out.println(childrenIds);
    }
}
