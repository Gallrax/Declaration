package com.cxgt.test;

import com.cxgt.entity.Activity;
import com.cxgt.service.ActivityService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ActivityTest {

    ApplicationContext context;
    ActivityService activityService;

    @Before
    public void before() {
        context = new ClassPathXmlApplicationContext("spring/spring.xml");
        activityService = context.getBean(ActivityService.class);
    }

    @Test
    public void test01() {
        Activity activity = activityService.selectById(1);
        System.out.println(activity);
    }

}
