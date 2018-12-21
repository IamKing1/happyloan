package com.group8.dao.employee;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * descriptive:
 * author:万中华
 * createTime:2018-11-24 19:16
 */
@Component
public interface EmpDao {

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 分页总数量
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


}
