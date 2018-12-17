package com.group8.shiro;

import com.group8.dao.login.UserDao;
import com.group8.entity.Permission;
import com.group8.entity.Role;
import com.group8.entity.User;
import com.group8.service.login.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * className:UserRealm
 * discriptoin:自定义Realm
 * author:丁启斌
 * createTime:2018-11-14 20:31
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired(required = false)
    private UserService userService;

    @Autowired
    private UserDao userDao;
    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
       // info.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        //查看登录用户的权限
        List<Permission> userPermission = userDao.findPermissionById(user.getId());
        for (Permission permission : userPermission) {
            /*System.out.println(permission.getUrl());*/
            info.addStringPermission(permission.getUrl());
        }
        //查看登录用户所拥有的角色
        List<Role> userList = userService.findById(user.getId());
        for (Role role : userList) {
            info.addRole(role.getRoleName());
        }
        return info;
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //模拟数据库
       /* String name = "root";
        String psd = "580231";*/
        //编写shiro判断逻辑，判断用户名密码

        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findUserByName(token.getUsername());
        if (user==null) {
            //用户名不存在 底层会报异常

            return null;
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPWD(), getName());

        return info;
    }
}
