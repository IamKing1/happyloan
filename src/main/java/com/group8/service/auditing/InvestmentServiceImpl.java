package com.group8.service.auditing;

import com.group8.dao.auditing.InvestmentDao;
import com.group8.dao.auditing.RealNameDao;
import com.group8.dao.customer.InformationDao;
import com.group8.service.customer.LoginService;
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


    @Autowired
    private InvestmentService InvestmentService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RealNameDao realNameDao;


    @Override
    public int remainingSum(HttpSession session,Integer money) {
        Map map = new HashMap();
        Object customerName = session.getAttribute("CustomerName");
//        System.out.println("---------"+customerName+"--------");
        List<Map> realNameList = informationDao.getRealIdByUserName(customerName.toString());
        Integer realId = Integer.valueOf(realNameList.get(0).get("ID").toString());
        map.put("realId",realId);
        map.put("money",money);
       // List<Map> mseList = investmentDao.remainingSum(map);

        Integer mse = investmentDao.remainingSum(map);


      //  System.out.println("--------------"+map.get("mse"));


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
        int result = investmentDao.investmentStorage(map);

        return result;
    }


    @Override
    public Integer currentlyVoted(Integer tendId) {
            Integer currentlyMoney=0;
        List<Map> moneyList = investmentDao.currentlyVoted(tendId);
        if(moneyList!=null&&moneyList.size()>0){
            for(int i=0;i<moneyList.size();i++){
                currentlyMoney+=Integer.valueOf(moneyList.get(i).get("MONEY").toString());
            }
        }
        Integer totalMoney = investmentDao.totalMoney(tendId);
        return totalMoney-currentlyMoney;
    }

    @Override
    public int updateTendStuts(Integer tendId) {

        int i = investmentDao.updateTendStuts(tendId);
        return i;
    }

    @Override
    public Integer hasCurrentlyVoted(Integer tendId) {
        Integer currentlyMoney=0;
        List<Map> moneyList = investmentDao.currentlyVoted(tendId);
        if(moneyList!=null&&moneyList.size()>0){
            for(int i=0;i<moneyList.size();i++){
                currentlyMoney+=Integer.valueOf(moneyList.get(i).get("MONEY").toString());
            }
        }
        return currentlyMoney;
    }

    @Override
    public List<Map> selectTenderingList(Map map) {
        List<Map> tenderingList = investmentDao.selectTenderingList(map);
        for (Map map1 : tenderingList) {
           Integer tendId = Integer.valueOf(map1.get("ID").toString());
            Integer currentlyMoney=0;
            List<Map> moneyList = investmentDao.currentlyVoted(tendId);
            if(moneyList!=null&&moneyList.size()>0){
                for(int i=0;i<moneyList.size();i++){
                    currentlyMoney+=Integer.valueOf(moneyList.get(i).get("MONEY").toString());
                }
            }
            map1.put("hasMoney",currentlyMoney);
        }
        return tenderingList;
    }

    @Override
    public Integer selectTenderingListCount(Map map) {

        return investmentDao.selectTenderingListCount(map);
    }


    @Override
    public int updateTendStutsToThree(Integer tendId,HttpSession session ) {
        int i = investmentDao.updateTendStutsToThree(tendId);
        Map map=new HashMap();
        if(i>0){
            map.put("content","尊敬的用户，您的贷款已发放，请注意查收,注意贷款期限，及时还款，祝您生活愉快");
            Integer userId = investmentDao.getUserId(tendId);
            map.put("userid",userId);
            //调用添加方法
            int add1 = realNameDao.add(map);
        }

        return i;
    }

    @Override
    public int beatMoneyToBorrower(Map map) {
//        System.out.println(map);
        Map map1 = new HashMap();

        //借款的多少
        Integer money = InvestmentService.hasCurrentlyVoted(Integer.valueOf(map.get("ID").toString()));
        map1.put("money",money);
        map1.put("realId",Integer.valueOf(map.get("REALID").toString()));
        int i = investmentDao.beatMoneyToBorrower(map1);
        return i;
    }

    @Override
    public int failToBeSoldAtAuction(Map map) {
        List<Map> moneyList = investmentDao.everyOneMoney(map);

        if(moneyList!=null&&moneyList.size()>0) {
            for (Map map1 : moneyList) {
                investmentDao.failToBeSoldAtAuction(map1);
            }
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public int updateTendStutsToFour(Integer tendId) {
        int i = investmentDao.updateTendStutsToFour(tendId);
        return i;
    }


    @Override
    public List<Map> selectFailMarkList(Map map) {
        List<Map> tenderingList = investmentDao.selectFailMarkList(map);
        for (Map map1 : tenderingList) {
            Integer tendId = Integer.valueOf(map1.get("ID").toString());
            Integer currentlyMoney=0;
            List<Map> moneyList = investmentDao.currentlyVoted(tendId);
            if(moneyList!=null&&moneyList.size()>0){
                for(int i=0;i<moneyList.size();i++){
                    currentlyMoney+=Integer.valueOf(moneyList.get(i).get("MONEY").toString());
                }
            }
            map1.put("hasMoney",currentlyMoney);
        }
        return tenderingList;

    }

    @Override
    public Integer selectFailMarkListCount(Map map) {

        return investmentDao.selectFailMarkListCount(map);
    }

    @Override
    public int saveBorrowingInformation(Map map) {
        Integer longTime = investmentDao.getLongTimeByTendId(map);
        map.put("time",longTime);
        int i = investmentDao.saveBorrowingInformation(map);
        return i;
    }

    @Override
    public Integer getMoneyByTendId(Integer tendId) {
        Integer money= investmentDao.getMoneyByTendId(tendId);

        return money;
    }
}
