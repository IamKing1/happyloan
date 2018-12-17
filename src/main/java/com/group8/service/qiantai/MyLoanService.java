package com.group8.service.qiantai;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:MyLoanService
 * descriptive:历史贷款总金额
 * author:万中华
 * createTime:2018-12-15 09:53
 */
public interface MyLoanService {
    /**
     * 获取总的历史贷款金额
     * @return
     */
    List<Map> getMoney();

    /**
     * 贷款列表
     * @param map
     * @return
     */
    List<Map> getListLoan(Map map);
    /**
     * 已发放
     * @param
     * @return
     */
    List<Map> getIssused(HttpSession session);
    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
}
