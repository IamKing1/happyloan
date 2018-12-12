package com.group8.service.auditing;

import java.util.List;
import java.util.Map;

/**
 * className:ReleasedService
 * descriptive:已发布
 * author:万中华
 * createTime:2018-12-10 13:43
 */
public interface ReleasedService {
    /**
     * 已发布贷款列表
     * @return
     */
    List<Map> getListRelease(Map map);
    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
}
