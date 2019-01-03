package com.group8.controller.qiantai;

import com.group8.service.qiantai.MyInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * className:MyInvestmentController
 * descriptive:我的账号--投资记录
 * author:万中华
 * createTime:2018-12-29 17:07
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/MyInvestment")
public class MyInvestmentController {

    @Autowired
    private MyInvestmentService myInvestmentService; //依赖注入

    /**
     * 获取投资记录信息
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMyInvestment")
    public Object getMyInvestment(@RequestBody Map map, HttpSession session){

        map.put("username", session.getAttribute("CustomerName"));
        Map map1=new HashMap();
        map1.put("data",myInvestmentService.getListInvestment(map));
        map1.put("total",myInvestmentService.getPageCount(map));
        return map1;
    }


}
