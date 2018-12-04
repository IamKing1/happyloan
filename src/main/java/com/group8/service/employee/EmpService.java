package com.group8.service.employee;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * descriptive:
 * author:万中华
 * createTime:2018-11-28 08:29
 */
public interface EmpService {

    /**
     * 查询
     * @param map
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 查询总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
    /**
     * 获取部门列表
     * @param
     * @return
     */
    List<Map> getDept();

    /**
     * 获取职位列表
     * @param
     * @return
     */
    List<Map> getDuty( );
    /**
     * 更新
     * @param map
     * @return
     */
    int update(Map map);
    /**
     * 新增
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 删除
     * @param empid
     * @return
     */
    int delete(int empid);
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(String ids);
}
