package com.group8.service.Client;

import com.group8.dao.Client.BlackListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:BlackListServiceImpl
 * descriptive:黑名单
 * author:万中华
 * createTime:2018-12-08 10:03
 */
@Service
@SuppressWarnings("all")
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    private BlackListDao blackListDao;
    @Override
    public List<Map> getBlackList(Map map) {
        return blackListDao.getBlackList(map);
    }

    @Override
    public int getPageCount(Map map) {
        return blackListDao.getPageCount(map);
    }

    @Override
    public int updateBlack(Map map) {
        return blackListDao.updateBlack(map);
    }
}
