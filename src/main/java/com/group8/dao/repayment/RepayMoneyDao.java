package com.group8.dao.repayment;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:RepayMoneyDao
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-14 15:57
 */
@Component
public interface RepayMoneyDao {

    /**
     * 借款人主动还款，余额里扣除金钱，转移到资金池
      * @param map
     * @return
     */
    Integer deductMoney(Map map);

    /**
     * 还款日从资金池拿钱，还给投资人
     * @param repayMoney
     * @return
     */
    int deductMoneyToInvestment(double repayMoney);


    /**
     * 计算每个表各个投资人的比列
     * @param map
     * @return
     */
    List<Map> calculationProportion(Map map);

    /**
     * 计算借款人应还的金额总数
     * @return
     */
    List<Map> getRepayMoneyCount(Map map);


    /**
     * 投资人回款
     * @return
     */
    int moneyBack(Map map);

    /**\
     * 得到到期的贷款   按期给投资人打钱
     * @return
     */
    List<Map>   getExpireLoan();

    /**
     * 回款 已还款更改状态
     * @param map
     * @return
     */
    int updateLoanState(Map map);

    /**
     * 查询出预期的借款信息
     * @param
     * @return
     */
    List<Map> getBeOverdueList();

    /**
     * 查询出预期的交易 更改他的状态
     * @param map
     * @return
     */
    int updateStutsToTwo(Map map);

    /**
     * 根据tendid查询信息
     * @param tendId
     * @return
     */
    List<Map> getRealMoneyByTendId(Integer tendId);

    /**
     * 得到还款列表
     * @return
     */
    List<Map> getHuanKuanList();

    /**
     * 查询状态
     * @param tendId
     * @return
     */
    Integer getStateByTendId(Integer tendId);

}
