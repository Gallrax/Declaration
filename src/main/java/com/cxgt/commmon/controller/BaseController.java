package com.cxgt.commmon.controller;

import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.entity.Site;
import com.cxgt.entity.User;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    protected Site getSite(HttpServletRequest request) {
        Site site = (Site) request.getSession().getAttribute(GlobalConstant.SESSION_SITE);
        return site;
    }

    protected User getUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(GlobalConstant.SESSION_USER);
        return user;
    }

    protected Integer getUid() {
        return null;
    }

    protected Integer getFid() {
        return null;
    }

}
