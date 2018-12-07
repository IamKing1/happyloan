package com.group8.dao.auditing;

import java.util.List;
import java.util.Map;

/**
 * className:firsttrial
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-03 13:55
 */
public interface RealNameDao {


    /**
     * 得到待审核的用户列表
     * @return
     */
    List<Map> getNoRealNameList(Map map);


    /**
     * 得到待审核的用户列表最大页数
     * @return
     */
    int getNoRealNameCount(Map map);

    /**
     * 认证完毕  得到结果
     * @param map
     * @return
     */
    int getRealNameResult(Map map);

}
