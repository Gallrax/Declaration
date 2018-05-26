package com.cxgt.commmon.constants;

/**
 * @Author: Gallrax
 * @Description: 不采用Enum原因是:使用Enum当做参数需要每次toString()
 * @Date: 2018/5/25
 */
public class GlobalConstant {

    /**
     * session 常量
     */
    public static final String SESSION_SITE = "SESSION_SITE";
    public static final String SESSION_USER = "SESSION_USER";

    /**
     * 状态常量
     */
    public static final Integer STATUS_DEFAULT = 0;//默认状态
    public static final Integer STATUS_UNABLE = -1;//不可展示不可使用状态
    public static final Integer STATUS_ABLE = 1;//可展示可使用状态(初始与默认状态无异)
    public static final Integer STATUS_ABLE_UNDO = 2;//可展示不可使用状态

}
