package com.group8.service.bid;

import com.group8.dao.bid.BidStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:BidStatusServiceImpl
 * discriptoin:
 * author:WangPJ
 * createTime:2018-12-13 13:57
 */
@Service
public class BidStatusServiceImpl implements BidStatusService {

    @Autowired
    private BidStatusDao bidStatusDao;
    @Override
    public List<Map> getPage(Map map) {
        return bidStatusDao.getPage(map);
    }

    @Override
    public int getPageCount(Map map) {
        return  bidStatusDao.getPageCount(map);
    }

    @Override
    public List<Map> selects(Map map) {
        return bidStatusDao.selects(map);
    }

    @Override
    public List<Map> selectu(Map map) {
        return bidStatusDao.selectu(map);
    }

    @Override
    public List<Map> getPager(Map map) {
        return bidStatusDao.getPager(map);
    }

    @Override
    public int getPageCountr(Map map) {
        return bidStatusDao.getPageCountr(map);
    }
}
