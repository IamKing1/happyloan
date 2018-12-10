package com.group8.controller.Employee;


import com.group8.service.employee.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * className:EmpController
 * descriptive:员工管理
 * author:万中华
 * createTime:2018-11-26 08:33
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empservice;

    /**
     * 跳转查询列表
     * @param map
     * @return
     */
    @RequestMapping("/toList")
    public String toList(@RequestParam Map map){
        return "/Emp/Emplist";
    }
    /**
     * 查询员工列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getList")
    public Object getListEmp(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("data",empservice.getList(map));
        map1.put("total",empservice.getPageCount(map));

        return map1;
    }

    /**
     * 部门
     * @param
     * @return
     */
   @ResponseBody
    @RequestMapping("/getdept")
    public Object getDept(){
        return empservice.getDept();

    }

    /**
     * 职位
     * @return
     */
    @ResponseBody
    @RequestMapping("/getduty")
    public Object getDuty(){
        return empservice.getDuty();
    }

    /**
     * 更新
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){

        return empservice.update(map);
    }

    /**
     * 添加
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Map map){
        return empservice.add(map);
    }
    /**
     * 删除
     * @param empid
     * @return
     */
    @ResponseBody
    @RequestMapping("/del/{empid}")
    public Object del(@PathVariable int empid){

        return empservice.delete(empid);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/batchDel/{ids}")
    public Object batchDel(@PathVariable String ids){
        return empservice.batchDelete(ids);
    }

}
