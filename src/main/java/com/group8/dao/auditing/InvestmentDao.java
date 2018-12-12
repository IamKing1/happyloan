package com.group8.dao.auditing;

import java.util.List;
import java.util.Map;

/**
 * className:InvestmentDao
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-12 16:18
 */
public interface InvestmentDao {

    /**
     * 充值减少余额
     * @param map
     * @return
     */
    Integer remainingSum(Map map);

    /**
     * 投资记录
     * @param map
     * @return
     */
    Integer investmentStorage(Map map);

}
