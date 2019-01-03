package com.group8.service.qiantai;

import com.group8.dao.qiantai.MyInvestment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:MyInvestmentServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-29 17:10
 */
@Service
@SuppressWarnings("all")
public class MyInvestmentServiceImpl implements MyInvestmentService {

    @Autowired
    private MyInvestment myInvestment;

    /**
     * 获取投资记录
     * @param map
     * @return
     */
    @Override
    public List<Map> getListInvestment(Map map) {
        return null;
    }
}
