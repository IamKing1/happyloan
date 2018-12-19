package com.group8.dao.auditing;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:ReleasedDao
 * descriptive:已发布
 * author:万中华
 * createTime:2018-12-10 13:38
 */
@Component
public interface ReleasedDao {

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