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
import org.springframework.web.bind.annotation.RequestBody;
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
//            System.out.println(customer.getEmail());
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
	    Object audutorId = session.getAttribute("audutorId");
	    /*System.out.println("\n"+customerName+"\n");
	    System.out.println("\n"+audutorId+"\n");*/
        if (customerName!=null){
            Customer customer = informationService.getTelephoneByUserName(customerName.toString());
            List<Map> realNameList = informationService.getRealNameByUserId(customer.getUserId());
//            System.out.println("\n"+realNameList+"\n");
            if(realNameList!=null&&realNameList.size()>0){
                Integer auditorid = Integer.valueOf(realNameList.get(0).get("AUDITORID").toString());
//                System.out.println(auditorid);
                List<Map> realNameByUserId = informationService.getAuditorStatus(auditorid);
                Object item = realNameByUserId.get(0).get("ITEM");
                 map.put("meg",item);
            }else{
                map.put("meg","-1");
            }
        }
//        System.out.println(map);
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
//    @ResponseBody
    @RequestMapping(value = "SubmissionRealName")
    public Object SubmissionRealName(@RequestParam Map  map, HttpSession session, @RequestParam MultipartFile positive, @RequestParam MultipartFile opposite){


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

        return "redirect:/realName.html";
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

//        System.out.println("----------"+pic);
        Map map = new HashMap();
        if(pic!=null&&!pic.isEmpty()){
            String s = FTPfile.upLoad(pic);

//            System.out.println(s);
            map.put("filePath",s);
            map.put("fileName",pic.getOriginalFilename());
        }

        Object customerName = session.getAttribute("CustomerName");
        if (customerName!=null) {
            map.put("userName",customerName.toString());

        }
        int i = informationService.updateHeadPortrait(map);
        System.out.println(i);
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


    /**
     * 充值操作
     * @param session
     * @param money
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "rechargeAmount")
    public Object rechargeAmount(HttpSession session,Integer money){

        Map map = new HashMap();
        int userId = loginService.getIdByName(session.getAttribute("CustomerName").toString());
//        System.out.println(userId);
        map.put("money",money);
        map.put("userId",userId);
        int i = informationService.rechargeAmount(map);

        Map map1 = new HashMap();
        map1.put("mse",i);

        return map1;
    }

	/**
	 * 查询实名认证页面的状态
	 * @param session
	 * @return
	 */
	@RequestMapping("isRealName")
	@ResponseBody
	public Object isRealName(HttpSession session) {
		String  customerName = (String)session.getAttribute("CustomerName");
//		System.out.println("\n"+customerName+"\n");
//		System.out.println("\n"+informationService.isRealName(customerName)+"\n");

		return informationService.isRealName(customerName);
	}

	@ResponseBody
	@RequestMapping("realNameAllInfo")
	public Object realNameAllInfo(HttpSession session){
		String  customerName = (String)session.getAttribute("CustomerName");
		List<Map> maps = informationService.realNameAllInfo(customerName);
//		System.out.println(maps);
		return maps;
	}

    @ResponseBody
    @RequestMapping("updateNickName")
    public Object updateNickName(HttpSession session,String nickName){
        String  customerName = (String)session.getAttribute("CustomerName");
        int userId = loginService.getIdByName(customerName);
        int i = informationService.updateNickName(userId, nickName);

        return i ;
    }
    @RequestMapping(value = "calculationMoney")
    @ResponseBody
    public Object calculationMoney(HttpSession session){
        String  customerName = (String)session.getAttribute("CustomerName");
        int userId = loginService.getIdByName(customerName);
        //待收本息
        Map map = informationService.calculationMoney(userId);
        return map;
    }
	/**
	 * 实名认证失败,删除原信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("removeRealName")
	public Object removeRealName(HttpSession session){
		Integer i = informationService.removeRealName(session.getAttribute("CustomerName").toString());
		return i;
	}
	/**
	 * 添加验证邮箱
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getIdNumEmail")
	public Object getIdNumEmail(HttpSession session){
		List<Map> getIdNumEmail = informationService.getIdNumEmail(session.getAttribute("CustomerName").toString());
//		System.out.println("\n"+session.getAttribute("CustomerName"));
//		System.out.println(getIdNumEmail);
		return getIdNumEmail;
	}

	/**
	 * 获取投资进度
	 * @param tendid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getProgress")
	public Object getProgress(@RequestBody Map tendid) {

		return informationService.getProgress(tendid);
	}

	/**
	 * 实名认证判断身份证唯一
	 * @param idNumber
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getIdNumberList")
	public Object getIdNumberList(@RequestParam String idNumber){
		List<Map> idNumberList = informationService.getIdNumberList();
//		System.out.println(idNumber);

		for(int i=0;i<idNumberList.size();i++){
//			System.out.println(idNumberList);
			if(idNumberList.get(i).get("IDNUMBER").equals(idNumber)){
				return "1";
			}
		}
		return "0";
	}



    /**
     * 判断是不是本人的标
     * @param tendid
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "judgeMark")
	public Object judgeMark(@RequestBody Map tendid,HttpSession session){
        List<Map> list = informationService.judgeMark(Integer.valueOf(tendid.get("tendid").toString()));
        String customerName = session.getAttribute("CustomerName").toString();

        if(list.get(0).get("USERNAME").equals(customerName)){
            return -1;
        }
        return 1;
    }

}
