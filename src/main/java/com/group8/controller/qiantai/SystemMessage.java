package com.group8.controller.qiantai;

import com.group8.service.qiantai.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * className:SystemMessage
 * descriptive:消息
 * author:万中华
 * createTime:2018-12-22 09:33
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/system")
public class SystemMessage {

    @Autowired
    private SystemMessageService systemMessageService;

    /**
     * 未读消息列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMessages")
    public Object getMessages( Map map, HttpSession session){

        map.put("username", session.getAttribute("CustomerName"));
        Map map1=new HashMap();
        map1.put("data",systemMessageService.getMessages(map));
      /*  map1.put("total",systemMessageService.getPageCount(map));*/
        return map1;
    }

    /**
     * 修改状态为2，变为已读
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        System.out.println("map+++++++"+map);
        return systemMessageService.update(map);
    }

    /**
     * 已读消息列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMessages2")
    public Object getMessages2( Map map, HttpSession session){

        map.put("username", session.getAttribute("CustomerName"));
        Map map1=new HashMap();
        map1.put("data",systemMessageService.getMessages2(map));
        return map1;
    }

    /**
     * 删除已读消息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/del/{id}")
    public Object del(@PathVariable int id){

        //System.out.println("-----====++++"+id);
        return systemMessageService.delte(id);
    }
}
