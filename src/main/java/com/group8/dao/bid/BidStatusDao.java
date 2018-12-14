package com.group8.dao.bid;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:BidStatusDao
 * discriptoin:
 * author:WangPJ
 * createTime:2018-12-13 13:50
 */
@Component
public interface BidStatusDao {
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
