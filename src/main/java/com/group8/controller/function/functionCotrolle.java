package com.group8.controller.function;

import com.group8.entity.Permission;
import com.group8.entity.Role;
import com.group8.entity.TreePermission;
import com.group8.service.function.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
    public String index(Model model,HttpSession session){

        Object userName = session.getAttribute("userName");
//        System.out.println("当前登录用户为:"+userName);

   /*     List<Map> list = functionService.getList();
        for (Map map : list) {
            map.put("childrenList",functionService.getListByPid(Integer.valueOf(map.get("ID").toString())));
        }

        model.addAttribute("list",list);*/
        return  "admin";
    }
    @RequestMapping(value = "noHasP")
    public String noHasP(){

        return "unauthorized";
    }


    /**
     * 得到角色列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "AllRole")
    public Object getAllRole(@RequestBody Map map){


        Map map1 = new HashMap();
        map1.put("data",functionService.getAllRole(map));
        map1.put("total",functionService.getAllRoleCount(map));

        return map1;
    }


    @RequestMapping(value = "toAssignauthority")
    public String toAssignauthority() {


        return "/function/assignauthority";
    }

    /**
     * 得到所有的权限
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getAllPermission")
    public Object getAllPermission(){
        List<TreePermission> allPermissionList = functionService.getAllPermission();
        return allPermissionList;
    }

    @ResponseBody
    @RequestMapping(value = "savePermission")
    public Object savePermission(@RequestBody Map map){
        functionService.saveNewPermission(map);

        return 1;
    }
}
