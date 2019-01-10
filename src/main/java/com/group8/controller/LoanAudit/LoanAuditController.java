package com.group8.controller.LoanAudit;

import com.group8.entity.User;
import com.group8.service.LoanAudit.LoanAuditService;
import com.group8.service.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * className:LoanAuditController
 * descriptive:
 * author:万中华
 * createTime:2018-12-06 13:58
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/Loan")
public class LoanAuditController {

    @Autowired
    private LoanAuditService loanAuditService;
    @Autowired
    private UserService userService;
    /**
     * 跳转列表
     * @param map
     * @return
     */
    @RequestMapping("/toListLoan")
    public String toList(@RequestParam Map map){
        return "LoanAudit/LoanAudit";
    }
    /**
     * 贷款信息列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getListLoan")
    public Object getListLoan(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("data",loanAuditService.getListLoan(map));
        map1.put("total",loanAuditService.getPageCount(map));
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
       // System.out.println(map);
        return loanAuditService.update(map);
    }

}
