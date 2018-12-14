package com.group8.dao.repayment;

import java.util.List;
import java.util.Map;

/**
 * className:RepayMoneyDao
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-14 15:57
 */
public interface RepayMoneyDao {

    /**
     * 借款人主动还款，余额里扣除金钱，转移到资金池
      * @param map
     * @return
     */
    Integer deductMoney(Map map);

    /**
     * 还款日从资金池拿钱，还给投资人
     * @param map
     * @return
     */
    int deductMoneyToInvestment(Map map);


    /**
     * 计算每个表各个投资人的比列
     * @param map
     * @return
     */
    List<Map> calculationProportion(Map map);






}
