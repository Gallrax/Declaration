package com.cxgt.controller.admin;


import com.cxgt.commmon.annotaion.SimpleLog;
import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.entity.Site;
import com.cxgt.entity.User;
import com.cxgt.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Gallrax
 * @since 2018-05-25
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
        username = "tom";
        password = "tom";
        Site site = new Site();
        site.setId(1);
        session.setAttribute(GlobalConstant.SESSION_SITE, site);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        SecurityUtils.getSubject().login(usernamePasswordToken);
        return "login";
    }

    @RequestMapping("/users")
    @RequiresUser
    @ResponseBody
    @SimpleLog
    public List<User> users() {
        List<User> users = userService.selectList(null);
        return users;
    }

    @SimpleLog
    @RequestMapping("/users1")
    @RequiresRoles("admin1")
    @ResponseBody
    public List<User> users1() {
        List<User> users = userService.selectList(null);
        return users;
    }

    @SimpleLog
    @RequestMapping("/users2")
    @RequiresPermissions("system:user:select1")
    @ResponseBody
    public List<User> users2() {
        List<User> users = userService.selectList(null);
        return users;
    }

}
