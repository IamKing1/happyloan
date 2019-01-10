package com.group8.controller.auditing;

import com.group8.service.auditing.InvestmentService;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * className:Investment
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-12 17:07
 */
@Controller
@RequestMapping(value = "investment")
public class Investment {

    @Autowired
    private InvestmentService investmentService;

    /**
     * 投资
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "remainingSum")
    @ResponseBody
    public Object remainingSum(HttpSession session,@RequestBody Map map){

        int i = investmentService.remainingSum(session, Integer.valueOf(map.get("money").toString()));

        if(i>0){
            int i1 = investmentService.investmentStorage(session, Integer.valueOf(map.get("money").toString()), Integer.valueOf(map.get("tendId").toString()));
            if(i1>0){
                return 1;
            }else{
                return -1;
            }
        }
        return -1;
    }

    /**
     * 查询本标剩余投资数目
     * @param tendid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "currentlyVoted")
    public Object currentlyVoted(@RequestBody Integer tendid){


        Integer integer = investmentService.currentlyVoted(tendid);

        //查询总钱数
        Integer moneyByTendId = investmentService.getMoneyByTendId(tendid);

       // System.out.println("---------------------"+moneyByTendId);
        if(integer<moneyByTendId*0.05){
            System.out.println("生效了~！！！！！！！！！！！！！！！！！！！！！");
            investmentService.updateTendStuts(tendid);
            return 1;
        }
        return -1;
    }

    /**
     *满标管理
     * @param map
     * @return
     */
    @RequestMapping(value = "selectTenderingList")
    @ResponseBody
    public Object selectTenderingList(@RequestBody Map map){

        Map map1 = new HashMap();
        map1.put("data", investmentService.selectTenderingList(map));

        map1.put("total", investmentService.selectTenderingListCount(map));
        return map1;
    }

    /**
     * 跳转满标管理
     * @return
     */
    @RequestMapping(value = "toTenderingList")
    public String toTenderingList(){
        return "bid/fullmark";
    }


    /**
     * 满标打钱   记录借钱信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateTendStutsThree")
    public Object updateTendStutsToThree(@RequestBody Map map){
        //更改状态
        int i = investmentService.updateTendStutsToThree(Integer.valueOf(map.get("ID").toString()));
       //打钱
        int i1 = investmentService.beatMoneyToBorrower(map);
        //记录表
        int i2 = investmentService.saveBorrowingInformation(map);


        return i1;
    }

    @ResponseBody
    @RequestMapping(value = "failToBeSoldAtAuction")
    public Object failToBeSoldAtAuction(@RequestBody Map map){

        Integer integer = investmentService.failToBeSoldAtAuction(map);
        investmentService.updateTendStutsToFour(Integer.valueOf(map.get("ID").toString()));

        return integer;
    }
    /**
     * 跳转流标管理
     * @return
     */
    @RequestMapping(value = "toFailmark")
    public String toFailmark(){

        return "bid/failmark";
    }

    /**
     *流标管理
     * @param map
     * @return
     */
    @RequestMapping(value = "selectFailmarkList")
    @ResponseBody
    public Object selectFailmarkList(@RequestBody Map map){
        System.out.println(map);
        Map map1 = new HashMap();
        map1.put("data", investmentService.selectFailMarkList(map));

        map1.put("total", investmentService.selectFailMarkListCount(map));
        return map1;
    }



}
