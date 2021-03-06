package com.group8.dao.bid;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:BidDao
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-23 20:05
 */
@Component
public interface BidDao {
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
    /**
     * 添加
     * @param map
     * @return
     */
    int add(Map map);
    /**
     * 修改
     * @param map
     * @return
     */
    int updateb(Map map);
    /**
     * 修改
     * @param map
     * @return
     */
    int updaterr(Map map);

    /**
     * 获取所有满标的标
     * @return
     */
    List<Map> getAllTend(Map map);

    /**
     * 获取总页数
     * @return
     */
    int countAllTend();

	/**
	 * 平台流水
	 * @return
	 */
	int tendAllMoney();
}
