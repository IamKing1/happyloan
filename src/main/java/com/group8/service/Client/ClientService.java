package com.group8.service.Client;

import java.util.List;
import java.util.Map;

/**
 * className:ClientService
 * descriptive:
 * author:万中华
 * createTime:2018-11-26 21:19
 */
public interface ClientService {

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Map> getListClient(Map map);

    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 删除
     * @param userid
     * @return
     */
    int delete(int userid);
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(String ids);
    /**
     * 更新状态
     * @param map
     * @return
     */
    int update(Map map);
}
