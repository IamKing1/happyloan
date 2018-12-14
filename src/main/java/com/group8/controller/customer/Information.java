package com.group8.controller.customer;


import com.group8.entity.Customer;
import com.group8.service.customer.InformationService;
import com.group8.service.customer.LoginService;
import com.group8.util.FTPfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:information
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-24 14:44
 */
@Controller
@RequestMapping(value = "customer")
public class Information {
    @Autowired
    private InformationService informationService;


    @Value("${upload.path}")
    private String filePath; // D:/images/


    @Autowired
    private  ResourceLoader resourceLoader;

    /**
     * 查询手机号邮箱
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getTelephoneByUserName")
    public Object getTelephoneByUserName(HttpSession session){
        Map map = new HashMap();
        Object customerName = session.getAttribute("CustomerName");
        if (customerName != null&&customerName!=""){
            Customer customer = informationService.getTelephoneByUserName(customerName.toString());
            System.out.println(customer.getEmail());
            if (customer != null) {
                map.put("customer", customer);
            } else {
                map.put("customer", "-1");
            }
        }else{
            map.put("customer", "-1");
        }
        return map;
    }

    /**
     * 查询认证状态
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "realName")
    public Object getRealName(HttpSession session){
        Map map = new HashMap();
        Object customerName = session.getAttribute("CustomerName");
        if (customerName!=null){
            Customer customer = informationService.getTelephoneByUserName(customerName.toString());
            List<Map> realNameList = informationService.getRealNameByUserId(customer.getUserId());
            if(realNameList!=null&&realNameList.size()>0){
                Integer auditorid = Integer.valueOf(realNameList.get(0).get("AUDITORID").toString());
                List<Map> realNameByUserId = informationService.getAuditorStatus(auditorid);
                Object item = realNameByUserId.get(0).get("ITEM");
                 map.put("meg",item);
            }else{
                map.put("meg","-1");
            }
        }
        return  map;
    }


    /**
     * 教育水平
     * @return
     */
    @RequestMapping(value = "getEducation")
    @ResponseBody
    public List<Map> getEducation() {
        List<Map> education = informationService.getEducation();
        return education;
    }

    /**
     * 婚姻状态
     * @return
     */
    @RequestMapping(value = "getMarriage")
    @ResponseBody
    public List<Map> getMarriage() {
        List<Map> marriage = informationService.getMarriage();
        return marriage;
    }

    /**
     * 现住址
     * @return
     */
    @RequestMapping(value = "getAddress")
    @ResponseBody
    public List<Map> getAddress() {
        List<Map> address = informationService.getAddress();
        return address;
    }

    /**
     * 收入
     * @return
     */
    @RequestMapping(value = "getIncome")
    @ResponseBody
    public List<Map> getIncome() {
        List<Map> income = informationService.getIncome();
        return income;
    }


    /**
     * 实名验证提交
     * @param map
     * @param session
     * @return
     */
    @RequestMapping(value = "SubmissionRealName")
    public String SubmissionRealName(@RequestParam Map  map, HttpSession session, @RequestParam MultipartFile positive, @RequestParam MultipartFile opposite){






        if(positive!=null&&!positive.isEmpty()){
            String s = FTPfile.upLoad(positive);
            map.put("positive",s);
           /* map.put("positive",positive.getOriginalFilename());*/
        }
        if(opposite!=null&&!opposite.isEmpty()){
            String s = FTPfile.upLoad(opposite);
            map.put("opposite",s);
            /*map.put("positive",positive.getOriginalFilename());*/
        }
        int i = informationService.SubmissionRealName(map, session);
          return "redirect:/个人中心-实名认证.html";
    }


   /* *//**
     * 添加头像
     * @param
     * @return
     *//*

    @RequestMapping("/addPortrait")
    public Object add(HttpSession session,@RequestParam MultipartFile pic){
        Map map = new HashMap();
        if(pic!=null&&!pic.isEmpty()){
            String s = FileUtil.uploadFile(filePath, pic);
            map.put("filePath",s);
            map.put("fileName",pic.getOriginalFilename());
        }

        Object customerName = session.getAttribute("CustomerName");
        if (customerName!=null) {
            map.put("userName",customerName.toString());

        }
        System.out.println(map);
        int i = informationService.updateHeadPortrait(map);
        return "redirect:/person.html";
    }
*/
    /**
     * 添加头像到ftp服务器
     * @param
     * @return
     */

    @RequestMapping("/addPortraitToFTP")
    public Object add2(HttpSession session,@RequestParam MultipartFile pic){

        System.out.println("----------"+pic);
        Map map = new HashMap();
        if(pic!=null&&!pic.isEmpty()){
            String s = FTPfile.upLoad(pic);

            System.out.println(s);
            map.put("filePath",s);
            map.put("fileName",pic.getOriginalFilename());
        }

        Object customerName = session.getAttribute("CustomerName");
        if (customerName!=null) {
            map.put("userName",customerName.toString());

        }
        int i = informationService.updateHeadPortrait(map);
        return "redirect:/person.html";
    }

  /*  *//**
     * 图片显示方法
     * @param session
     * @return
     *//*
    @RequestMapping("/show")
    public ResponseEntity show(HttpSession session){

        Object customerName = session.getAttribute("CustomerName");
        if (customerName!=null) {

            //根据登录用户查询他的头像名称
            Map map = informationService.selectHeadPortrait(customerName.toString());

            String fileName = map.get("HEADPORTRAIT").toString();
            try {

                // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
                String newfile = "file:"+filePath+fileName;
                System.out.println(newfile);
                Resource resource = resourceLoader.getResource(newfile);

                return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath + fileName));
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }else{
            return ResponseEntity.notFound().build();
        }

        }*/

    /**
     * ftp图片显示方法
     * @param session
     * @return
     */
    @RequestMapping("/showFtp")
    public ResponseEntity showFtp(HttpSession session){


        Object customerName = session.getAttribute("CustomerName");
        if (customerName!=null) {

            //根据登录用户查询他的头像名称
            Map map = informationService.selectHeadPortrait(customerName.toString());

            String fileName = map.get("HEADPORTRAIT").toString();
            try {


                // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
                Resource resource = resourceLoader.getResource("ftp://p2p:123456@172.16.22.62/" + fileName);
                return ResponseEntity.ok(resourceLoader.getResource("ftp://p2p:123456@172.16.22.62/" + fileName));
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @Autowired
    private LoginService loginService;



    @ResponseBody
    @RequestMapping(value = "rechargeAmount")
    public Object rechargeAmount(HttpSession session,Integer money){
        Map map = new HashMap();
        System.out.println(money);
        int userId = loginService.getIdByName(session.getAttribute("CustomerName").toString());
        System.out.println(userId);
        map.put("money",money);
        map.put("userId",userId);
        int i = informationService.rechargeAmount(map);
        Map map1 = new HashMap();
        map1.put("mse",i);
        return map1;
    }
}
