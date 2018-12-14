package com.group8.service.bid;

import java.util.List;
import java.util.Map;

/**
 * className:BidStatusService
 * discriptoin:
 * author:WangPJ
 * createTime:2018-12-13 13:57
 */
public interface BidStatusService {
    /**
     *分页数量
     * @param map
     * @return
     */
    List<Map> getPage(Map map);

    /**
     *总条数
     * @param map
     * @return
     */
    int getPageCount(Map map);
    /**
     * 搜索检索选项
     * @return
     */
    List<Map> selects(Map map);
    List<Map> selectu(Map map);
    /**
     * 分页
     * @param map
     * @return
     */
    List<Map> getPager(Map map);

    /**
     * 计数
     * @return
     */
    int getPageCountr(Map map);
}
