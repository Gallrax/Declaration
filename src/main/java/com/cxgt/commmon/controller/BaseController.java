package com.cxgt.commmon.controller;

import com.cxgt.commmon.constants.SessionParam;
import com.cxgt.entity.Site;
import com.cxgt.entity.User;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    protected Site getSite(HttpServletRequest request) {
        Site site = (Site) request.getSession().getAttribute(SessionParam.SESSION_SITE);
        return site;
    }

    protected User getUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SessionParam.SESSION_USER);
        return user;
    }
}
