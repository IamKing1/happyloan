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

        //借款人还款操作
        int i = repayMoneyService.deductMoney(map);
    if(i<0){
        return -1;
    }
        return  1;
    }




}
