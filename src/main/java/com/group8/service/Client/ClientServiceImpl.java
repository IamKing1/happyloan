package com.group8.service.Client;

import com.group8.dao.Client.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:ClientServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-11-26 21:22
 */
@Service
@SuppressWarnings("all")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;
    /**
     * 查询分页
     * @param map
     * @return
     */
    @Override
    public List<Map> getListClient(Map map) {
        List<Map> list = clientDao.getListClient(map);
        return list;
    }

    /**
     * 分页总数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return clientDao.getPageCount(map);
    }

    /**
     * 更新状态
     * @param map
     * @return
     */
    @Override
    public int update(Map map) {
        return clientDao.update(map);
    }
}
