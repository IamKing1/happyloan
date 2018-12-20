package com.group8.dao.qiantai;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:QtDao
 * descriptive:
 * author:万中华
 * createTime:2018-12-13 14:59
 */
@Component
public interface QtDao {

    List<Map> getList(Map map);
    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
}
