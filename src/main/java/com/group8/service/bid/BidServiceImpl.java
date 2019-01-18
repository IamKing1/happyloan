package com.group8.service.bid;

import com.group8.dao.bid.BidDao;
import com.group8.service.auditing.InvestmentService;
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

    @Autowired
    private InvestmentService investmentService;
    @Override
    public List<Map> getPage(Map map) {



        List<Map> page = bidDao.getPage(map);
        for (Map map1 : page) {
            Integer hasMoney = investmentService.hasCurrentlyVoted(Integer.valueOf(map1.get("BID_ID").toString()));
            map1.put("hasMoney",hasMoney);
        }
        return page;
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

    @Override
    public int add(Map map) {
        return bidDao.add(map);
    }

    @Override
    public int updateb(Map map) {
        return bidDao.updateb(map);
    }

    @Override
    public int updaterr(Map map) {
        return bidDao.updaterr(map);
    }

	@Override
	public List<Map> getAllTend(Map map) {
		return bidDao.getAllTend(map);
	}

	@Override
	public int countAllTend() {
		return bidDao.countAllTend();
	}

	@Override
	public int tendAllMoney() {
		return bidDao.tendAllMoney();
	}


}
