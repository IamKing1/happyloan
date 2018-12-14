package com.group8.controller.auditing;

import com.group8.service.auditing.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:release
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-06 20:19
 */
@Controller
@RequestMapping(value = "release")
public class ReleaseController {
    @Autowired
    private ReleaseService releaseService;

    @RequestMapping(value = "toRelease")
    public String toRelease() {

        return "auditing/release";
    }

    @ResponseBody
    @RequestMapping(value = "releaseList")
    public Object getReleaseList(@RequestBody Map map) {


        Map map1 = new HashMap();
        List<Map> releaseMessageList = releaseService.getReleaseMessage(map);
        map1.put("data", releaseMessageList);

        int releaseMessageCount = releaseService.getReleaseMessageCount(map);
        map1.put("total", releaseMessageCount);

        return map1;
    }

    @ResponseBody
    @RequestMapping(value = "confirmationInformation")
    public Object confirmationInformation(@RequestBody Map map) {

        int i = releaseService.confirmationInformation(map);

        return i;
    }


    @ResponseBody
    @RequestMapping(value = "getConfirmationInformationList")
    public Object getConfirmationInformationList(){
        Map map = new HashMap();
        List<Map> confirmationInformationList = releaseService.getConfirmationInformationList();
        map.put("list",confirmationInformationList);
        return map;
    }


    /**
     * 查看借款人详情  页面跳转
     * @param tendId
     * @param redirect
     * @return
     */
    @RequestMapping(value = "/personMse/{tendId}",method= RequestMethod.GET)
    public String personMse(@PathVariable Integer tendId,RedirectAttributes redirect){
        redirect.addAttribute("num",tendId);
        return "redirect:/infor.html";
    }

    /**
     * 招标信息
     * @param map
     * @return
     */
    @RequestMapping(value = "selectAllMseege")
    @ResponseBody
    public Object selectAllMseege(@RequestParam Map map){
       Integer tendingId = Integer.valueOf(map.get("tendingId").toString());

        List<Map> maps = releaseService.selectAllMseege(tendingId);
        return maps.get(0);
    }
}
