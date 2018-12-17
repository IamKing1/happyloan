package com.group8.service.qiantai;

import com.group8.dao.qiantai.MyLoanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:MyLoanServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-15 09:54
 */
@Service
@SuppressWarnings("all")
public class MyLoanServiceImpl implements
        MyLoanService {

    @Autowired
    private MyLoanDao myLoanDao;
    @Override
    public List<Map> getMoney() {
        return myLoanDao.getMoney();
    }

    @Override
    public List<Map> getListLoan(Map map) {
        return myLoanDao.getListLoan(map);
    }

    @Override
    public List<Map> getIssused( ) {
        return myLoanDao.getIssused();
    }

    @Override
    public int getPageCount(Map map) {
        return myLoanDao.getPageCount(map);
    }
}
