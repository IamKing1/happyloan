package com.group8.controller.bid;

import com.group8.service.bid.BidService;

import com.group8.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.util.AuthResources_it;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * className:BidController
 * discriptoin:
 * author:WangPJ
 * createTime:2018-11-23 20:12
 */
@Controller
@RequestMapping("/bidcon")
public class BidController {
    @Autowired
    private BidService bidService;

    /**
     * 列表分页
     * @param map
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(@RequestParam Map map, Model model, HttpServletRequest request){
        map.put("pageSize",7);
        int pageNo = map.get("pageNo") == null?1 : Integer.valueOf(map.get("pageNo") + "");

        String stringPage = new PageUtil(pageNo, 5, bidService.getPageCount(map), request).getStringPage();


        List<Map> selects = bidService.selects(map);
        List<Map> selectu = bidService.selectu(map);
        model.addAttribute("selectu",selectu);
        model.addAttribute("selecta",selects);
        model.addAttribute("stringPage",stringPage);
        model.addAttribute("bidList",bidService.getPage(map));


        return "bid/bid";
    }

    /**
     * 添加
     * @param map
     * @return
     */
    @RequestMapping("/add")
    public String add(@RequestParam Map map,Model model){
        int i = bidService.add(map);
       if (i>0){
           model.addAttribute("error","添加成功");
        }else {
           model.addAttribute("error","添加失败");
       }

        return "redirect:/bidcon/list";
    }

    /**
     * 获取修改内容
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getid")
    public List<Map> getById(@RequestParam int id){
        List<Map> byId = bidService.getById(id);

        return byId;
    }

    /**
     * 执行修改方法
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(@RequestBody  Map map){
        int i = bidService.update(map);
        return i;
    }
    /**
     * 执行删除方法
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(@RequestParam  Integer BID_ID){
        int del = bidService.delete(BID_ID);
        return del;
    }

}
