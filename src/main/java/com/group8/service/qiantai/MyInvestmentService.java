package com.group8.service.qiantai;

import java.util.List;
import java.util.Map;

/**
 * className:MyInvestmentService
 * descriptive:
 * author:万中华
 * createTime:2018-12-29 17:07
 */
public interface MyInvestmentService {
    /**
     * 获取投资记录
     * @param map
     * @return
     */
    List<Map> getListInvestment(Map map);
    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
}
