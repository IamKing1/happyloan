package com.group8.dao.login;

import com.group8.entity.Permission;
import com.group8.entity.Role;
import com.group8.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * className:LoginDad
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-23 17:34
 */
@Component
public interface UserDao {

   User findUserByName(String userName);
    /**
     * 根据用户id
     *查询是什么角色
     * @param userId
     * @return
     */
    List<Role> findById(Integer userId);

    /**
     * 根据用户id
     *查询有什么权限
     * @param userId
     * @return
     */
    List<Permission> findPermissionById(Integer userId);
}
