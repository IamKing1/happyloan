package com.group8.dao.login;

import com.group8.entity.Role;
import com.group8.entity.User;

import java.util.List;

/**
 * className:LoginDad
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-23 17:34
 */
public interface UserDao {

   User findUserByName(String userName);

    List<Role> findById(Integer userId);
}
