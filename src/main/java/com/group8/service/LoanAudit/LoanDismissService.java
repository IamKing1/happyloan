package com.group8.service.LoanAudit;

import java.util.List;
import java.util.Map;

/**
 * className:LoanDismissService
 * descriptive:贷款驳回
 * author:万中华
 * createTime:2018-12-07 18:34
 */
public interface LoanDismissService {
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
