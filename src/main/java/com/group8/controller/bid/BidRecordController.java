package com.group8.controller.bid;

import com.group8.service.bid.BidRecordService;
import com.group8.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
/**
 * className:BidRecordController
 * discriptoin:
 * author:WangPJ
 * createTime:2018-12-10 21:28
 */
@Controller
@RequestMapping("/record")
public class BidRecordController {
    @Autowired
    private BidRecordService bidRecordService;

    @RequestMapping("/list")
    public String list(@RequestParam Map map, Model model, HttpServletRequest request){
        map.put("pageSize",7);
        int pageNo = map.get("pageNo") ==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") ==null?10:Integer.valueOf(map.get("pageSize")+"");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);

        String stringPage = new PageUtil(pageNo, 5, bidRecordService.getPageCountr(map), request).getStringPage();

        model.addAttribute("stringPage",stringPage);
        List<Map> selectu = bidRecordService.selectu(map);
        model.addAttribute("selectu",selectu);
        model.addAttribute("bidList",bidRecordService.getPager(map));


        return "bid/bidrecord";
    }

    /**
     * 添加
     * @param map
     * @return
     */
    /**
     * 执行修改方法
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Map map){
        int i = bidRecordService.add(map);
        return i;
    }

    /**
     * 获取修改内容
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getid")
    public List<Map> getById(@RequestParam Integer id){
        List<Map> byId = bidRecordService.getById1(id);
        return byId;
    }
    /**
     * 执行修改方法
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object updates(@RequestBody  Map map){
        int i = bidRecordService.update(map);
        return i;
    }
}
