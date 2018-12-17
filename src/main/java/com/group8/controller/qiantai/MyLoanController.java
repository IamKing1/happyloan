package com.group8.controller.qiantai;

import com.group8.service.qiantai.MyLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


    /**
     * 贷款详细列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getListLoan")
    public Object getListLoan(@RequestBody Map map){

        Map map1=new HashMap();
        map1.put("data",myLoanService.getListLoan(map));
        map1.put("total",myLoanService.getPageCount(map));
        return map1;
    }


    @ResponseBody
    @RequestMapping("/getIssused")
    public Object getIssused(){
        System.out.println("\n"+myLoanService.getIssused());
        return myLoanService.getIssused();
    }
}
