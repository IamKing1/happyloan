package com.group8.service.bid;

import com.group8.dao.bid.BidStatusDao;
import com.group8.service.auditing.InvestmentService;
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
    @Autowired
    private InvestmentService investmentService;
    @Override
    public List<Map> getPage(Map map) {
        List<Map> page = bidStatusDao.getPage(map);
        for (Map map1 : page) {
            Integer hasMoney = investmentService.hasCurrentlyVoted(Integer.valueOf(map1.get("BID_ID").toString()));
            map1.put("hasMoney",hasMoney);
        }
        return page;
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
        List<Map> page = bidStatusDao.getPager(map);
        for (Map map1 : page) {
            Integer hasMoney = investmentService.hasCurrentlyVoted(Integer.valueOf(map1.get("BID_ID").toString()));
            map1.put("hasMoney",hasMoney);
        }
        return page;
    }

    @Override
    public int getPageCountr(Map map) {
        return bidStatusDao.getPageCountr(map);
    }
}
