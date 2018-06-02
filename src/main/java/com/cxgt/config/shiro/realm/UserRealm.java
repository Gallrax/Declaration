package com.cxgt.config.shiro.realm;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cxgt.commmon.constants.GlobalConstant;
import com.cxgt.entity.*;
import com.cxgt.service.*;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private PermissionService permissionService;

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
            //设置角色
            List<UserRole> userRoles = userRoleService.selectList(new EntityWrapper<UserRole>().eq("user_id", user.getId()));
            List<Integer> roleIds = new ArrayList<>();
            for (UserRole userRole : userRoles) {
                roleIds.add(userRole.getRoleId());
            }
            Set<String> roles = new HashSet<String>();
            List<Role> rolesList = roleService.selectBatchIds(roleIds);
            for (Role role : rolesList) {
                roles.add(role.getCode());
            }
            //设置权限
            List<RolePermission> rolePermissions = rolePermissionService.selectList(new EntityWrapper<RolePermission>().in("role_id", roleIds));
            List<Integer> permissionIds = new ArrayList<>();
            for (RolePermission rolePermission : rolePermissions) {
                permissionIds.add(rolePermission.getPermissionId());
            }
            Set<String> permissions = new HashSet<String>();
            List<Permission> permissionList = permissionService.selectBatchIds(permissionIds);
            for (Permission permission : permissionList) {
                permissions.add(permission.getCode());
            }
            //将角色和权限注入到shiro中
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
        Assert.notNull(user);
        return new SimpleAuthenticationInfo(user, user.getPassword(), user.getUsername());
    }
}
