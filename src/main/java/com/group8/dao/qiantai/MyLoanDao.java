package com.group8.dao.qiantai;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:MyLoanDao
 * descriptive:前台我的贷款
 * author:万中华
 * createTime:2018-12-15 08:33
 */
@Component
public interface MyLoanDao {
    /**
     * 获取总的历史贷款金额
     * @return
     */
   List<Map> getMoney();

    /**
     * 贷款审核列表
     * @param map
     * @return
     */
   List<Map> getListLoan(Map map);

    /**
     * 已发放
     * @param
     * @return
     */
   List<Map> getIssused(Map map);
    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 计算出预期的金额
     * @param tendId
     * @return
     */
    int getYuQiMoney(Integer tendId);
}
