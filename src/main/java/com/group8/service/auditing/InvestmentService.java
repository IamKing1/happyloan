package com.group8.service.auditing;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:InvestmentService
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-12 17:02
 */
public interface InvestmentService {
    /**
     * 投资后余额减少
     * @param session
     * @param money
     * @return
     */
    int remainingSum(HttpSession session,Integer money);

    /**
     * 投资记录
     * @return
     */
    int investmentStorage(HttpSession session,Integer money,Integer tendId);

    /**
     * 查询本标剩余投资数目
     * @param tendId
     * @return
     */
    Integer currentlyVoted(Integer tendId);
    /**
     * 查询本标已投投资数目
     * @param tendId
     * @return
     */
    Integer hasCurrentlyVoted(Integer tendId);

    /**
     * 达到满标更改状态
     * @param tendId
     * @return
     */
    int updateTendStuts(Integer tendId);
    /**
     * 查询已发布表的列表
     * @return
     */
    List<Map> selectTenderingList(Map map);

    /**
     * 查询已发布表的列表数量
     * @return
     */
    Integer selectTenderingListCount(Map map);
    /**
     * 招标完成，更改状态
     * @param tendId
     * @return
     */
    int updateTendStutsToThree(Integer tendId);
    /**
     * 招标完成，给借款人打钱
     * @param map
     * @return
     */
    int beatMoneyToBorrower(Map map);
    /**
     * 流标业务
     * @return
     */
    int failToBeSoldAtAuction(Map map);
    /**
     * 流标，更改状态
     * @param tendId
     * @return
     */
    int updateTendStutsToFour(Integer tendId);



}
