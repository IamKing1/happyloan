package com.group8.dao.customer;

import java.util.Map;

/**
 * className:Loan
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-29 15:22
 */
public interface LoanDao {
    /**
     * 借款申请
     * @param map
     */
   int applyLoan(Map map);

}
