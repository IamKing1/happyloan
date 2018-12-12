package com.group8.service.auditing;

import com.group8.dao.auditing.InvestmentDao;
import com.group8.dao.customer.InformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:InvestmentServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-12 17:03
 */
@Service
public class InvestmentServiceImpl implements InvestmentService {
    @Autowired
    private InvestmentDao investmentDao;

    @Autowired
    private InformationDao informationDao;
    @Override
    public int remainingSum(HttpSession session,Integer money) {
        Map map = new HashMap();
        Object customerName = session.getAttribute("CustomerName");
        List<Map> realNameList = informationDao.getRealIdByUserName(customerName.toString());
        Integer realId = Integer.valueOf(realNameList.get(0).get("ID").toString());
        map.put("realId",realId);
        map.put("money",money);
       // List<Map> mseList = investmentDao.remainingSum(map);
        investmentDao.remainingSum(map);
        return Integer.valueOf(map.get("mse")+"");
    }

    @Override
    public int investmentStorage(HttpSession session,Integer money,Integer tendId) {
        Map map = new HashMap();


        Object customerName = session.getAttribute("CustomerName");
        List<Map> realNameList = informationDao.getRealIdByUserName(customerName.toString());
        Integer realId = Integer.valueOf(realNameList.get(0).get("ID").toString());
        map.put("realId",realId);
        map.put("money",money);
        map.put("tendId",tendId);
        System.out.println(map);
        int result = investmentDao.investmentStorage(map);
        return result;
    }
}
