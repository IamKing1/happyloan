package com.group8.controller.LoanAudit;

import com.group8.service.LoanAudit.LoanDismissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:LoanDismissController
 * descriptive:贷款驳回列表
 * author:万中华
 * createTime:2018-12-07 18:35
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/loanDis")
public class LoanDismissController {

    @Autowired //依赖注入
    private LoanDismissService loanDismissService;

    /**
     * 跳转方法
     * @return
     */
    @RequestMapping("/toLoanDis")
    public String toLoanDis(){
        return "LoanAudit/LoanDismiss";
    }

    /**
     * 驳回列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getListLoanDis")
    public Object getListLoanDis(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("data",loanDismissService.getListLoanDis(map));
        map1.put("total",loanDismissService.getPageCounts(map));
        return map1;
    }

    /**
     * 更改是否返回重审
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateDis")
    public Object updateDis(@RequestBody Map map){
        return loanDismissService.updateDis(map);
    }

}
