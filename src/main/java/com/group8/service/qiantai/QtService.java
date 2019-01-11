package com.group8.service.qiantai;

import java.util.List;
import java.util.Map;

/**
 * className:QtService
 * descriptive:
 * author:万中华
 * createTime:2018-12-13 15:03
 */
public interface QtService {
    List<Map> getList(Map map);

    /**
     * 分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
    /**
     * 累计投资金额
     * @return
     */
    List<Map> getCountMoney();

    /**
     * 注册人数
     * @return
     */
    List<Map> getCountClient();

    /**
     * 更改手机号

     * @return
     */
    Integer changePhone(Map map);
}
