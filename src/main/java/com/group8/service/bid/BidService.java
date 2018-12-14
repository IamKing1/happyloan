package com.group8.service.bid;

import java.util.List;
import java.util.Map;

/**
 * className:BidService
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-23 20:08
 */
public interface BidService {
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
     * 修改
     * @param map
     * @return
     */
    int update(Map map);

}
