package com.group8.controller.qiantai;

import java.util.List;
import java.util.Map;

/**
 * className:SystemMessage
 * descriptive:消息
 * author:万中华
 * createTime:2018-12-22 09:33
 */
public interface SystemMessage {

    /**
     * 未读消息列表
     * @return
     */
    List<Map> getMessages(Map map);
}
