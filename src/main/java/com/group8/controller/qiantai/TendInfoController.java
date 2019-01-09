package com.group8.controller.qiantai;

import com.group8.service.auditing.InvestmentService;
import com.group8.service.qiantai.TendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * className:TendInfoController
 * descriptive:
 * author:荣恒
 * createTime:2018/12/14 17:05
 */

@Controller
@RequestMapping("tendInfo")
public class TendInfoController {
	@Autowired
	private TendInfoService tendInfoService;
	@Autowired
	private InvestmentService investmentService;

	/**
	 * 查询获取借款人信息
	 * @param tendid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getLoanList")
	public Object getLoanList(@RequestBody Map tendid){

		Map map = new HashMap();
		map.put("data",tendInfoService.getLoanList(tendid));
		return map;
	}

	@ResponseBody
	@RequestMapping("getLoanInfo")
	public Object getLoanInfo(@RequestBody Map tendid){
		/*Map map = new HashMap();
		map.put("data",tendInfoService.getLoanInfo(tendid));*/

		return tendInfoService.getLoanInfo(tendid);
	}

	/**
	 * 查询借款人信息
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getGaveList")
	public Object getGaveList(@RequestBody Map map,HttpSession session){
//		System.out.println(map.get("tendid"));


		Map map1 = new HashMap();
		map1.put("total",tendInfoService.getGaveCount(Integer.valueOf(map.get("tendid")+"")));
		map1.put("data",tendInfoService.getGaveList(map));
		Object customerName = session.getAttribute("CustomerName");

		if(customerName!=null){
			map1.put("login",1);
		}else{
			map1.put("login",2);
		}
		return map1;
	}

	/**
	 * 剩余钱数
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("surplusMoney")
	public Object surplusMoney(@RequestBody Map map){
		Integer tendid = Integer.valueOf(map.get("tendid") + "");
		Integer integer = investmentService.currentlyVoted(tendid);
		System.out.println("剩余投资的数目为："+integer);
		//查询总钱数
		Integer moneyByTendId = investmentService.getMoneyByTendId(tendid);
		System.out.println("剩余投资的数目为："+moneyByTendId*0.05);
		if(integer<(moneyByTendId*0.05)){
			investmentService.updateTendStuts(tendid);
		}
		return integer;

	}

	@ResponseBody
	@RequestMapping("updateEmail")
	public Object updateEmail(@RequestParam String email, HttpSession session){
		Map map = new HashMap();
		Object username = session.getAttribute("CustomerName");
		System.out.println("\n"+username);
		System.out.println("\n"+email+"\n");
		map.put("email",email);
		map.put("username",username);
		System.out.println(map);
		Integer i = tendInfoService.updateEmail(map);
		return i;
	}

}
