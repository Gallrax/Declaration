package com.cxgt.config.shiro.realm;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.entity.Site;
import com.cxgt.entity.User;
import com.cxgt.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Gallrax
 * @Description:
 * @Date: 2018/5/26
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * @author: Gallrax
     * @Description: 权限验证
     * @date: 2018/5/26 12:54
     * @param:
     * @return:
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        if (ObjectUtil.isNotNull(user)) {
            Set<String> roles = new HashSet<String>() {{
                add("admin");
            }};
            Set<String> permissions = new HashSet<String>() {{
                add("system:user:select");
            }};
            simpleAuthorizationInfo.setRoles(roles);
            simpleAuthorizationInfo.setStringPermissions(permissions);
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        Site site = (Site) session.getAttribute(GlobalConstant.SESSION_SITE);
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        User user = userService.selectOne(new EntityWrapper<User>().eq("username", usernamePasswordToken.getUsername()).eq("site_id", site.getId()));
        return new SimpleAuthenticationInfo(user, user.getPassword(), user.getUsername());
    }
}
