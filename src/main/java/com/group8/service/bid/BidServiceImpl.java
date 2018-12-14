package com.group8.service.bid;

import com.group8.dao.bid.BidDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:BidServiceImpl
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-23 20:09
 */
@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidDao bidDao;

    @Override
    public List<Map> getPage(Map map) {
        return bidDao.getPage(map);
    }

    @Override
    public int getPageCount(Map map) {
        return bidDao.getPageCount(map);
    }

    @Override
    public List<Map> selects(Map map) {
        return bidDao.selects(map);
    }

    @Override
    public List<Map> selectu(Map map) {
        return bidDao.selectu(map);
    }
    @Override
    public int update(Map map) {
        return bidDao.update(map);
    }


}
