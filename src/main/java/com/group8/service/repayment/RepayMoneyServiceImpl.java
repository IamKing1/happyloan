package com.group8.service.repayment;

import com.group8.dao.repayment.RepayMoneyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className:RepayMoneyServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-14 16:03
 */
@Service
public class RepayMoneyServiceImpl implements  RepayMoneyService{

    @Autowired
    private RepayMoneyDao repayMoneyDao;

    @Override
    public int deductMoney(Map map) {
        int i = repayMoneyDao.deductMoney(map);
        return 0;
    }
}
