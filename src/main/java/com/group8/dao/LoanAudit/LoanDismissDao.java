package com.group8.dao.LoanAudit;

import java.util.List;
import java.util.Map;

/**
 * className:LoanDismissDao
 * descriptive:贷款驳回列表
 * author:万中华
 * createTime:2018-12-07 18:32
 */
public interface LoanDismissDao {

    /**
     *贷款驳回列表
     * @param map
     * @return
     */
    List<Map> getListLoanDis(Map map);
    /**
     * 驳回数量查询
     * @param map
     * @return
     */
    int getPageCounts(Map map);

    /**
     * 更改是否重新审核
     * @param map
     * @return
     */
    int updateDis(Map map);
}
