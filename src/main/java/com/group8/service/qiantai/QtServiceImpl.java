package com.group8.service.qiantai;

import com.group8.dao.qiantai.QtDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:QtServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-13 15:03
 */
@Service
@SuppressWarnings("all")
public class QtServiceImpl implements QtService {

    @Autowired
    private QtDao qtDao;

    @Override
    public List<Map> getList(Map map) {
        return qtDao.getList(map);
    }

    @Override
    public int getPageCount(Map map) {
        return qtDao.getPageCount(map);
    }
}
