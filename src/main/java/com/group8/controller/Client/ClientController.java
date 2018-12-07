package com.group8.controller.Client;

import com.group8.service.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * className:ClientController
 * descriptive:
 * author:万中华
 * createTime:2018-11-26 21:27
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired //依赖注入
    private ClientService clientService;
    /**
     * 跳转列表
     * @param map
     * @return
     */
    @RequestMapping("/toClient")
    public String toClientList(Map map){

        return "Client/Clientlist";
    }

    /**
     * 用户列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getClient")
    public Object getClientList(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("data",clientService.getListClient(map));
        map1.put("total",clientService.getPageCount(map));

        return map1;
    }
    /**
     * 删除
     * @param userid
     * @return
     */
    @ResponseBody
    @RequestMapping("/del/{userid}")
    public Object del(@PathVariable int userid){

        return clientService.delete(userid);
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/batchDel/{ids}")
    public Object batchDel(@PathVariable String ids){
        return clientService.batchDelete(ids);
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
        return clientService.update(map);
    }

}
