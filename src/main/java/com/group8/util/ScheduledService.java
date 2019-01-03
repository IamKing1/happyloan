package com.group8.util;

import com.group8.dao.repayment.RepayMoneyDao;
import com.group8.service.repayment.RepayMoneyService;
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

    @Scheduled(cron = "0 0 12 * * ?")
    public void huikuan() {

        List<Map> expireLoan = repayMoneyDao.getExpireLoan();
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

    @Scheduled(cron = "0 0 12 * * ?")
    public void yuqi() {

        List<Map> beOverdueList = repayMoneyDao.getBeOverdueList();
        if(beOverdueList!=null&&beOverdueList.size()>0){
            for (Map map : beOverdueList) {
                repayMoneyDao.updateStutsToTwo(map);
            }
        }

    }

}
