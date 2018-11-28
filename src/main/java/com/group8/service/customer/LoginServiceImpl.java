package com.group8.service.customer;


import com.group8.dao.customer.LoginDao;
import com.group8.entity.Customer;
import com.group8.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * className:LoginServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-22 09:58
 */
@Service
public class LoginServiceImpl implements  LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public int register(Customer customer) {

        int register = loginDao.register(customer);
        return register;
    }



    @Override
    public Customer SignIn(Customer customer) {

        Customer customer1 = loginDao.SignIn(customer);
        return customer1;
    }

    @Override
    public Customer getByName(String userName) {
        Customer customer = loginDao.getByName(userName);
        return customer;
    }
    @Override
    public List<Role> getById(Integer userId) {
        List<Role> roleList = loginDao.getById(userId);
        return roleList;
    }
}
