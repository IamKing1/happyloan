package com.group8.service.LoanAudit;

import java.util.List;
import java.util.Map;

/**
 * className:LoanAuditSecondService
 * descriptive:
 * author:万中华
 * createTime:2018-12-07 13:40
 */
public interface LoanAuditSecondService {
    /**
     * 分页查询二审贷款列表
     * @param map
     * @return
     */
    List<Map> getListLoanSec(Map map);
    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
    /**
     * 审核2
     * @param map
     * @return
     */
    int update(Map map);
}
