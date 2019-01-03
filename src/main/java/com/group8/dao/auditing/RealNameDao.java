package com.group8.dao.auditing;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:firsttrial
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-03 13:55
 */
@Component
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

    /**
     * 向消息表中添加内容
     * @param map
     * @return
     */
    int add(Map map);

}
