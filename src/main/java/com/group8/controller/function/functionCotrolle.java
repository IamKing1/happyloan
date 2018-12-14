package com.group8.controller.function;

import com.group8.service.function.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * className:backstageCotrolle
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-23 10:48
 */
@Controller
@RequestMapping(value = "function")
public class functionCotrolle {
    @Autowired
    private FunctionService functionService;


    /**
     * 后台菜单列表
     * @param model
     * @return
     */

    @RequestMapping(value = "index")
    public String index(Model model){
        List<Map> list = functionService.getList();
        for (Map map : list) {
            map.put("childrenList",functionService.getListByPid(Integer.valueOf(map.get("ID").toString())));
        }

        model.addAttribute("list",list);
        return  "admin";
    }
    @RequestMapping(value = "noHasP")
    public String noHasP(){

        return "unauthorized";
    }
}
