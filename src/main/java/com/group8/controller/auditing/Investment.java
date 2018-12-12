package com.group8.controller.auditing;

import com.group8.service.auditing.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

}
