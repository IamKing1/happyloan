package com.group8.service.auditing;

import java.util.List;
import java.util.Map;

/**
 * className:Release
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-06 20:41
 */
public interface ReleaseService {

    /**
     * 招标信息
     * @param map
     * @return
     */
 List<Map> getReleaseMessage(Map map);
    /**
     * 最大数量  分页数据
     * @param map
     * @return
     */
    int getReleaseMessageCount(Map map);
    /**
     * 确认招标信息
     * @param map
     * @return
     */
    int confirmationInformation(Map map);

}
