package com.group8.controller.auditing;

import com.group8.service.auditing.RealNameService;
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

        System.out.println(map);
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
        System.out.println(fileName+"...........................");
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            Resource resource = resourceLoader.getResource("ftp://iamking:123456@172.16.22.81/" + fileName);
            return ResponseEntity.ok(resourceLoader.getResource("ftp://iamking:123456@172.16.22.81/" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }


    }

    /*@RequestMapping("/showIdNumber")
    public ResponseEntity showFtp(@RequestBody String fileName) {
        System.out.println(fileName+"...........................");
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            Resource resource = resourceLoader.getResource("ftp://iamking:123456@172.16.22.81/" + fileName);
            return ResponseEntity.ok(resourceLoader.getResource("ftp://iamking:123456@172.16.22.81/" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }


    }*/
}