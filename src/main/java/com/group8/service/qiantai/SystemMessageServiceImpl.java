package com.group8.service.qiantai;

import com.group8.dao.qiantai.SystenMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:SystemMessageServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-22 10:13
 */
@Service
@SuppressWarnings("all")
public class SystemMessageServiceImpl implements SystemMessageService {

    @Autowired
    private SystenMessage systenMessage;

    @Override
    public List<Map> getMessages(Map map) {
        return systenMessage.getMessages(map);
    }

   /* @Override
    public int getPageCount(Map map) {
        return systenMessage.getPageCount(map);
    }*/

    @Override
    public int update(Map map) {
        return systenMessage.update(map);
    }

    @Override
    public List<Map> getMessages2(Map map) {
        return systenMessage.getMessages2(map);
    }

   /* @Override
    public int getPageCount2(Map map) {
        return systenMessage.getPageCount2(map);
    }*/

    @Override
    public int delte(int id) {
        return systenMessage.delte(id);
    }
}
