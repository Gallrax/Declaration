package com.cxgt.test;

import com.cxgt.entity.Activity;
import com.cxgt.service.ActivityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
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

    @Test
    public void test02() throws IOException {
        System.out.println(Thread.currentThread().toString());
        activityService.addClick(1);
        activityService.addClick(1);
        activityService.addClick(1);
        activityService.addClick(1);
        activityService.addClick(1);
        activityService.addClick(1);
        activityService.addClick(1);
        System.in.read();
    }

    @Test
    public void testEnum() {
        System.out.println(Session_Param.ONE.toString());
        System.out.println(Session_Param.TWO.toString());
    }

    enum Session_Param {
        ONE,
        TWO
    }

}
