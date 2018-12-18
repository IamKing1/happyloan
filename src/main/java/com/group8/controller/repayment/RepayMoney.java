package com.group8.controller.repayment;

import com.group8.service.repayment.RepayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:RepayMoneyController
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-15 13:37
 */
@Controller
@RequestMapping(value = "repayMoney")
public class RepayMoney {
    @Autowired
    private RepayMoneyService repayMoneyService;

    @ResponseBody
    @RequestMapping(value = "moneyBackPool")
    public Object moneyBackPool(@RequestBody Map map){

        //还款操作  需要三个参数
        System.out.println(map);
        int i = repayMoneyService.deductMoney(map);

        return i;
    }



    /**
     * 执行回款操作，从资金池拿钱，返还给投资人
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "moneyBackToPerson")
    public Object moneyBackToPerson(){
        Map map = new HashMap();
          map.put("tendId",21);
        int i = repayMoneyService.transferMoneyToTouZiRen(map);
        return i;
    }


}
