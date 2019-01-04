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

        //通过session获取用户名
        map.put("username", session.getAttribute("CustomerName"));
        Map map1=new HashMap();
        map1.put("data",myInvestmentService.getListInvestment(map));
        map1.put("total",myInvestmentService.getPageCount(map));
        return map1;
    }

    /**
     * 累计投资和收益
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDetails")
    public Object getDeatils( Map map,HttpSession session){
        map.put("username",session.getAttribute("CustomerName"));
        Map map2=new HashMap();
        map2.put("data",myInvestmentService.getDetails(map));
        //System.out.println("--------++++"+map2);
        return map2;
    }

    /**
     * 用户进行删除操作
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object Update(@RequestBody Map map){
        System.out.println("========"+myInvestmentService.update(map));
        return myInvestmentService.update(map);

    }

}
