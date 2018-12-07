package com.group8.service.auditing;

import com.group8.dao.auditing.RealNameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:realNameImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-03 16:56
 */
@Service
public class RealNameServiceImpl implements RealNameService {


    @Autowired
    private RealNameDao realNameDao;


    @Override
    public List<Map> getNoRealNameList(Map map) {
        List<Map> noRealNameList = realNameDao.getNoRealNameList(map);
        return noRealNameList;
    }

    @Override
    public int getNoRealNameCount(Map map) {
        int noRealNameCount = realNameDao.getNoRealNameCount(map);
        return noRealNameCount;
    }


    @Override
    public int getRealNameResult(Map map) {
        int realNameResult = realNameDao.getRealNameResult(map);
        return realNameResult;
    }
}
