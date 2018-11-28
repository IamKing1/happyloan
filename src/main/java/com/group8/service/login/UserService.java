package com.group8.service.login;

import com.group8.entity.Role;
import com.group8.entity.User;

import java.util.List;

/**
 * className:LoginService
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-23 17:35
 */

public interface UserService {
    User findUserByName(String userName);
    List<Role> findById(Integer userId);
}
