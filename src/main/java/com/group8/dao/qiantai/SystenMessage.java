package com.group8.dao.qiantai;

import java.util.List;
import java.util.Map;

/**
 * className:SystenMessage
 * descriptive:
 * author:万中华
 * createTime:2018-12-22 09:49
 */
public interface SystenMessage {

    /**
     * 未读消息列表
     * @return
     */
    List<Map> getMessages(Map map);
    /**
     * 分页总数量
     * @param map
     * @return
     */
 /*   int getPageCount(Map map);*/

    /**
     * 修改状态，未读消息变为已读
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 已读消息列表
     * @return
     */
    List<Map> getMessages2(Map map);
    /**
     * 已读消息分页总数量
     * @param map
     * @return
     */
  /*  int getPageCount2(Map map);*/

    /**
     * 删除已读消息
     * @param id
     * @return
     */
    int delte(int id);
}
