package com.group8.dao.qiantai;

import java.util.List;
import java.util.Map;

/**
 * className:MyInvestment
 * descriptive:我的账号---投资记录
 * author:万中华
 * createTime:2018-12-29 17:04
 */
public interface MyInvestment {

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
