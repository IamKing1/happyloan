package com.group8.controller.qiantai;

import com.group8.service.qiantai.QtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * className:QtController
 * descriptive:
 * author:万中华
 * createTime:2018-12-13 15:04
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/qiant")
public class QtController {

    @Autowired
    private QtService qtService;

    @ResponseBody
    @RequestMapping("/getList")
    public Object getListEmp(@RequestBody Map map){
        Map map1=new HashMap();

        map1.put("data",qtService.getList(map));
        map1.put("total",qtService.getPageCount(map));

        return map1;
    }
}
