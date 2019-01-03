package com.group8.controller.customer;

import com.group8.entity.Customer;
import com.group8.service.customer.InformationService;
import com.group8.service.customer.LoanService;
import com.group8.service.customer.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:Loan
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-29 15:42
 */
@Controller
@RequestMapping(value = "customer")
public class Loan {
    @Autowired
    private LoanService loanService;

    @Autowired
    private InformationService informationService;


    @RequestMapping("toLoan")
    @ResponseBody
    public Object applyLoan(@RequestParam Map map, HttpSession session){
//        System.out.println("--------"+map);
//        System.out.println(session);
        Object customerName = session.getAttribute("CustomerName");
        if (customerName != null&&customerName!="") {
            String userName = customerName.toString();
            List<Map> realIdByUserName = informationService.getRealIdByUserName(userName);
            String realId = realIdByUserName.get(0).get("ID").toString();
            map.put("realId",realId);
        }
//        System.out.println(map);
        int i = loanService.applyLoan(map);
        return i;

//        return "";
    }
}
