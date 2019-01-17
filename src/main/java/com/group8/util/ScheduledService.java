package com.group8.util;

import com.group8.dao.repayment.RepayMoneyDao;
import com.group8.service.repayment.RepayMoneyService;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:ScheduledService
 * discriptoin: 定时任务
 * author:丁启斌
 * createTime:2018-12-25 17:51
 */
@Slf4j
@Component
public class ScheduledService {
    @Autowired
    private RepayMoneyService repayMoneyService;
    @Autowired
    private RepayMoneyDao repayMoneyDao;

    /**
     * 定时回款
     */
    @Scheduled(cron = "0 0 12 * * ?")
    public void huikuan() {

        List<Map> expireLoan = repayMoneyDao.getExpireLoan();


        //回款
        if(expireLoan!=null&&expireLoan.size()>0) {
            for (Map map : expireLoan) {
                //需要还钱的id
                Integer tendid = Integer.valueOf(map.get("TENDID").toString());

                Map map1 = new HashMap();
                map1.put("tendId",tendid);
                //投资人回款操作
                int i1 = repayMoneyService.transferMoneyToTouZiRen(map1);
                if(i1<1){
                    System.out.println("系统就要完蛋了");
                }

            }
        }
    }

    /**
     * 查询逾期
     */
    @Scheduled(cron = "0 0 12 * * ?")
    public void yuqi() {

        List<Map> beOverdueList = repayMoneyDao.getBeOverdueList();
        if(beOverdueList!=null&&beOverdueList.size()>0){
            for (Map map : beOverdueList) {
                repayMoneyDao.updateStutsToTwo(map);
            }
        }

    }
    /**
     * 按时还款
     */
    @Scheduled(cron = "0 0 12 * * ?")
    public void huankuan(){
        List<Map> expireLoan = repayMoneyDao.getHuanKuanList();
        //System.out.println(expireLoan);
        //还款
        if(expireLoan!=null&&expireLoan.size()>0) {
            for (Map map : expireLoan) {
                Map map1 = new HashMap();
                //借款标id
                Integer tendId = Integer.valueOf(map.get("TENDID").toString());
                map1.put("TENDID",tendId);
                List<Map> realMoneyByTendIdList = repayMoneyDao.getRealMoneyByTendId(tendId);
                //还款人id
                Integer realId = Integer.valueOf(realMoneyByTendIdList.get(0).get("REALID").toString());
                map1.put("REALID",realId);
                //还款金额
                Integer MO = Integer.valueOf(realMoneyByTendIdList.get(0).get("MO").toString());
                map1.put("MO",MO);

                repayMoneyService.deductMoney(map1);
                System.out.println(map1);
                if(Integer.valueOf(map1.get("mse").toString())>0){
                    System.out.println("还款成功");
                }else{
                    System.out.println("还款失败");
                }
            }
        }


    }

}
