package com.group8.controller.qiantai;

import com.group8.entity.Customer;
import com.group8.service.customer.InformationService;
import com.group8.service.qiantai.MyLoanService;
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
 * className:MyLoanController
 * descriptive:
 * author:万中华
 * createTime:2018-12-15 09:56
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/MyLoan")
public class MyLoanController {

    @Autowired
    private MyLoanService myLoanService;
    @Autowired
    private InformationService informationService;
    /**
     * 贷款详细列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getListLoan")
    public Object getListLoan(@RequestBody Map map, HttpSession session){
        Object customerName = session.getAttribute("CustomerName");

        List<Map> realIdByUserName = informationService.getRealIdByUserName(customerName.toString());
      map.put("realId",realIdByUserName.get(0).get("ID"));

        Map map1=new HashMap();
        map1.put("data",myLoanService.getListLoan(map));
        map1.put("total",myLoanService.getPageCount(map));

        return map1;
    }


    @ResponseBody
    @RequestMapping("/getIssused")
    public Object getIssused(HttpSession session){
        System.out.println(myLoanService.getIssused(session));

        List<Map> issused = myLoanService.getIssused(session);
        return issused;
    }
}
