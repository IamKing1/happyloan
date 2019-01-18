package com.group8.service.repayment;

import com.group8.dao.repayment.RepayMoneyDao;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:RepayMoneyServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-14 16:03
 */
@Service
public class RepayMoneyServiceImpl implements RepayMoneyService {

    @Autowired
    private RepayMoneyDao repayMoneyDao;

    @Autowired
    private RepayMoneyService repayMoneyService;

    @Override
    public int deductMoney(Map map) {
    //还款
      repayMoneyDao.deductMoney(map);

        if(Integer.valueOf(map.get("mse").toString())>0){
            //需要还钱的id
            Integer tendid = Integer.valueOf(map.get("TENDID").toString());

            //回款状态
            Integer state = repayMoneyDao.getStateByTendId(tendid);
            if(1==state){
                //创建一个新map
                Map newMap = new HashMap();
                newMap.put("tendId",tendid);
                //投资人回款操作
                int i1 = repayMoneyService.transferMoneyToTouZiRen(newMap);
                if(i1<1){
                    System.out.println("系统就要完蛋了");
                }
            }
        }

        return Integer.valueOf(map.get("mse").toString());
    }

    @Override
    public int transferMoneyToTouZiRen(Map map) {

        //查询本标 借钱的多少 和借钱的期限
        List<Map> repayMoneyCount = repayMoneyDao.getRepayMoneyCount(map);
        if(repayMoneyCount!=null&&repayMoneyCount.size()>0) {
            //借钱的多少
            Integer money = Integer.valueOf(repayMoneyCount.get(0).get("MONEY").toString());
            //借钱的长短
            Integer longtime = Integer.valueOf(repayMoneyCount.get(0).get("ITEM").toString());
            //应该还的总额   利息 + 本金
            int repayMoney = (int) (money + money * longtime*0.01);
            map.put("repayMoney", repayMoney);
            //从资金池拿钱归还
            int repayMoneyPool = repayMoneyDao.deductMoneyToInvestment(repayMoney);
            if (repayMoneyPool < 0) {
                return -1;
            }
            //查询 每个投资的金钱占比
            List<Map> proportionList = repayMoneyDao.calculationProportion(map);

            if (proportionList != null && proportionList.size() > 0) {
                for (Map map1 : proportionList) {

                    Map newMap = new HashMap();

                    newMap.put("realId", map1.get("REALID"));
                    //取出应得的比率 乘以 还款总数
                    //  等于应得的回款
                    double toPersonMoney = (Double.valueOf(map1.get("PROPORTION").toString()) / 100) * repayMoney;
                    DecimalFormat df = new DecimalFormat("#.00");
                    String format = df.format(toPersonMoney);


                    newMap.put("toPersonMoney", format);
                    //System.out.println(toPersonMoney);
                    //分别给投资人账户转入应得的金钱  金钱+利息
                    int i = repayMoneyDao.moneyBack(newMap);

                }
            } else {
                return -1;
            }
            //更改汇款的状态  2  为已经回款
           repayMoneyDao.updateLoanState(map);
            return 1;
        }
        return -1;
    }
}
