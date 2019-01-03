package com.group8.controller.LoanAudit;

import com.group8.service.LoanAudit.LoanAuditSecondService;
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
 * className:LoanAuditSecondController
 * descriptive:二审列表
 * author:万中华
 * createTime:2018-12-07 13:41
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/loanAuditSecond")
public class LoanAuditSecondController {

    @Autowired
    private LoanAuditSecondService loanAuditSecondService;
    /**
     * 跳转列表
     * @param map
     * @return
     */
    @RequestMapping("/toListLoanSec")
    public String toList(@RequestParam Map map){
        return "LoanAudit/LoanAuditSecond";
    }
    /**
     * 贷款信息二审列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getListLoanSec")
    public Object getListLoan(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("data",loanAuditSecondService.getListLoanSec(map));
        map1.put("total",loanAuditSecondService.getPageCount(map));
        return map1;
    }
    /**
     * 审核
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map, HttpSession session){
        Object userName = session.getAttribute("userName");
        map.put("adminId", userName.toString());
        System.out.println(map);
        return loanAuditSecondService.update(map);
    }

}
