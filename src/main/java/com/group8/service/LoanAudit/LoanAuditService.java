package com.group8.service.LoanAudit;

import java.util.List;
import java.util.Map;

/**
 * className:LoanAuditService
 * descriptive:
 * author:万中华
 * createTime:2018-12-06 13:58
 */
public interface LoanAuditService {

    /**
     * 分页查询待审核贷款信息
     * @param map
     * @return
     */
    List<Map> getListLoan(Map map);

    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
    /**
     * 审核
     * @param map
     * @return
     */
    int update(Map map);
}
