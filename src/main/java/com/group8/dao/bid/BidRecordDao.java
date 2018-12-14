package com.group8.dao.bid;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * className:BidRecordDao
 * discriptoin:
 * author:WangPJ
 * createTime:2018-12-10 17:00
 */
@Component
public interface BidRecordDao {
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
