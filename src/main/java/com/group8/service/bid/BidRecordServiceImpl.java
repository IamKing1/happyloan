package com.group8.service.bid;

import com.group8.dao.bid.BidRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:BidRecordServiceImpl
 * discriptoin:
 * author:WangPJ
 * createTime:2018-12-10 21:16
 */
@Service
public class BidRecordServiceImpl implements BidRecordService{
    @Autowired
    private BidRecordDao bidRecordDao;
    @Override
    public List<Map> getPager(Map map) {
        return bidRecordDao.getPager(map);
    }

    @Override
    public int getPageCountr(Map map) {
        return bidRecordDao.getPageCountr(map);
    }

    @Override
    public int add(Map map) {
        return bidRecordDao.add(map);
    }

    @Override
    public List<Map> getById1(Integer id) {
        return bidRecordDao.getById1(id);
    }

    @Override
    public int update(Map map) {
        return bidRecordDao.update(map);
    }

    @Override
    public List<Map> selectu(Map map) {
        return bidRecordDao.selectu(map);
    }
}
