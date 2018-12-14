package com.group8.service.bid;

import java.util.List;
import java.util.Map;

/**
 * className:BidRecordService
 * discriptoin:
 * author:WangPJ
 * createTime:2018-12-10 21:15
 */
public interface BidRecordService {
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
    /**
     * 添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     *
     * @param id
     * @return
     */
    List<Map> getById1(Integer id);
    /**
     * 修改
     * @param map
     * @return
     */
    int update(Map map);
    /**
     *
     * @param map
     * @return
     */
    List<Map> selectu(Map map);
}
