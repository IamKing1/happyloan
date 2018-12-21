package com.group8.controller.bid;

import com.group8.service.bid.BidStatusService;
import com.group8.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * className:BidStatusController
 * discriptoin:
 * author:WangPJ
 * createTime:2018-12-13 14:00
 */
@Controller
@RequestMapping("/status")
public class BidStatusController {
    @Autowired
    private BidStatusService bidStatusService;

    /**
     * 已发布
     * @param map
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map map, Model model, HttpServletRequest request){
        map.put("pageSize",7);
        int pageNo = map.get("pageNo") ==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") ==null?10:Integer.valueOf(map.get("pageSize")+"");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);

        String stringPage = new PageUtil(pageNo, 5, bidStatusService.getPageCount(map), request).getStringPage();

        List<Map> selects = bidStatusService.selects(map);
        List<Map> selectu = bidStatusService.selectu(map);
        model.addAttribute("selectu",selectu);
        model.addAttribute("selecta",selects);
        model.addAttribute("stringPage",stringPage);
        model.addAttribute("bidList",bidStatusService.getPage(map));


        return "bid/bidstatus";
    }

    /**
     * 总计
     * @param map
     * @param model
     * @param request
     * @return
     */

    @RequestMapping("/lists")
    public String lists(@RequestParam Map map, Model model, HttpServletRequest request){
        map.put("pageSize",6);
        int pageNo = map.get("pageNo") ==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize") ==null?10:Integer.valueOf(map.get("pageSize")+"");
        //计算分页的开始值和结束值
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);

        String stringPage = new PageUtil(pageNo, 5, bidStatusService.getPageCountr(map), request).getStringPage();


        List<Map> selects = bidStatusService.selects(map);
        List<Map> selectu = bidStatusService.selectu(map);
        model.addAttribute("selectu",selectu);
        model.addAttribute("selecta",selects);
        model.addAttribute("stringPage",stringPage);
        model.addAttribute("bidList",bidStatusService.getPager(map));


        return "bid/bidtotal";
    }
}
