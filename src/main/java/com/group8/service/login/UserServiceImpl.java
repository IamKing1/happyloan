package com.group8.service.login;

import com.group8.dao.login.UserDao;
import com.group8.entity.Role;
import com.group8.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * className:LoginServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-23 17:41
 */
@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {



    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByName(String userName) {
        User user = userDao.findUserByName(userName);
        return user;
    }

    @Override
    public List<Role> findById(Integer userId) {
        List<Role> roleList = userDao.findById(userId);
        return roleList;
    }
}
