package com.group8.dao.LoanAudit;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:LoanAuditDao
 * descriptive:贷款一审
 * author:万中华
 * createTime:2018-12-06 13:57
 */
@Component
public interface LoanAuditDao {

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
     * 审核1
     * @param map
     * @return
     */
    int update(Map map);
}
