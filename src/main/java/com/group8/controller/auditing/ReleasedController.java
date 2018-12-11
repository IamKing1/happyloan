package com.group8.controller.auditing;

import com.group8.service.auditing.ReleasedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * className:ReleasedController
 * descriptive:查看已发布贷款列表
 * author:万中华
 * createTime:2018-12-10 13:46
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/released")
public class ReleasedController {
    @Autowired
    private ReleasedService releasedService;

    /**
     * 跳转到已发布列表
     * @param map
     * @return
     */
    @RequestMapping("/toReleased")
    public String toReleased(Map map){

        return "auditing/Released";
    }

    /**
     * 已发布列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/getListReleased")
    public Object getListReleased(@RequestBody Map map){
        return releasedService.getListRelease(map);
    }

}
