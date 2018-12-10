package com.group8.service.Client;

import java.util.List;
import java.util.Map;

/**
 * className:BlackListService
 * descriptive:
 * author:万中华
 * createTime:2018-12-08 09:46
 */
public interface BlackListService {
    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Map> getBlackList(Map map);

    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
    /**
     * 更新状态
     * @param map
     * @return
     */
    int updateBlack(Map map);
}
