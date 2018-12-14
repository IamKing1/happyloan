package com.group8.controller.auditing;

import com.group8.service.auditing.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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
     * @param session
     * @param money
     * @return
     */
    @RequestMapping(value = "remainingSum")
    @ResponseBody
    public Object remainingSum(HttpSession session,Integer money,Integer tendingId){

        int i = investmentService.remainingSum(session, money);
        if(i>0){
            int i1 = investmentService.investmentStorage(session, money, tendingId);
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
     * @param tendingId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "currentlyVoted")
    public Object currentlyVoted(Integer tendingId){


        Integer integer = investmentService.currentlyVoted(tendingId);


        if(integer<100){
            investmentService.updateTendStuts(tendingId);
        }
        return integer;
    }

    /**
     *满标一审
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
     * 跳转
     * @return
     */
    @RequestMapping(value = "toTenderingList")
    public String toTenderingList(){
        return "bid/firstinstance";
    }

    @ResponseBody
    @RequestMapping(value = "updateTendStutsThree")
    public Object updateTendStutsToThree(@RequestBody Map map){

        int i = investmentService.updateTendStutsToThree(Integer.valueOf(map.get("ID").toString()));
        int i1 = investmentService.beatMoneyToBorrower(map);
        return i1;
    }

    @ResponseBody
    @RequestMapping(value = "failToBeSoldAtAuction")
    public Object failToBeSoldAtAuction(@RequestBody Map map){

        Integer integer = investmentService.failToBeSoldAtAuction(map);

        investmentService.updateTendStutsToFour(Integer.valueOf(map.get("ID").toString()));
        return integer;
    }

}
