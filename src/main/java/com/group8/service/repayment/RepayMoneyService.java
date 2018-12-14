package com.group8.service.repayment;

import java.util.Map;

/**
 * className:RepayMoneyService
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-14 16:01
 */
public interface RepayMoneyService {


    /**
     * 借款人主动还款，余额里扣除金钱，转移到资金池
     * @param map
     * @return
     */
    int deductMoney(Map map);

}
