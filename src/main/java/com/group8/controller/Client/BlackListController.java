package com.group8.controller.Client;

import com.group8.service.Client.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:BlackListController
 * descriptive:黑名单
 * author:万中华
 * createTime:2018-12-08 09:46
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/blackList")
public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    /**
     * 跳转黑名单列表
     * @return
     */
    @RequestMapping("/toBlack")
    public String toBlackList(){
        return "Client/BlackList";
    }

    /**
     * 黑名单列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getBlackList")
    public Object getBlackList(@RequestBody Map map){

        Map map1=new HashMap();
        map1.put("data",blackListService.getBlackList(map));
        map1.put("total",blackListService.getPageCount(map));

        return map1;
    }
    /**
     * 更改状态
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object Update(@RequestBody Map map){
        System.out.println(map);
        return blackListService.updateBlack(map);
    }
}
