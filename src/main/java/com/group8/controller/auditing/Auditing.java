package com.group8.controller.auditing;

import com.group8.service.auditing.RealNameService;
import com.group8.util.ConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:Auditing
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-03 17:07
 */
@Controller
@RequestMapping("auditing")
public class Auditing {


    @Autowired
    private RealNameService realNameService;

    static Map configPara = ConfigUtil.getConfigMap();
    static String ip=configPara.get("ip")+"";
    static int port=Integer.valueOf(configPara.get("port")+"");
    static String username=configPara.get("username")+"";
    static String password=configPara.get("password")+"";
    static String pathname=configPara.get("pathname")+"";
    static String path1=configPara.get("path")+"";


    @RequestMapping(value = "toRealName")
    public String toRealName() {
        return "auditing/realName";
    }

    /**
     * 得到为认证的用户列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("realNameList")
    public Object getReaNameList(@RequestBody Map map) {


        Map map1 = new HashMap();
        map1.put("data", realNameService.getNoRealNameList(map));

        map1.put("total", realNameService.getNoRealNameCount(map));
        return map1;
    }

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * ftp图片显示方法
     *
     * @param fileName
     * @return
     */
    @RequestMapping("/showIdNumber")
    public ResponseEntity showFtp(String fileName) {

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            Resource resource = resourceLoader.getResource("ftp://"+username+":"+password+"@"+ip+"/" + fileName);
            return ResponseEntity.ok(resourceLoader.getResource("ftp://"+username+":"+password+"@"+ip+"/" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @ResponseBody
    @RequestMapping(value = "realNameResult")
    public Object findingsOfAudit(@RequestBody Map map){
        int realNameResult = realNameService.getRealNameResult(map);


        return realNameResult;
    }

}