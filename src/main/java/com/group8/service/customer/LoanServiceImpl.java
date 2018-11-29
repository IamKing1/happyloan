package com.group8.service.customer;

import com.group8.dao.customer.LoanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className:LoanServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-29 15:38
 */
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanDao loanDao;

    @Override
    public int applyLoan(Map map) {
        int i = loanDao.applyLoan(map);
        return i;
    }
}
