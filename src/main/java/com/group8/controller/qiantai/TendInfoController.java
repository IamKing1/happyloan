package com.group8.controller.qiantai;

import com.group8.service.auditing.InvestmentService;
import com.group8.service.qiantai.TendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		System.out.println("\n");
		System.out.println(tendInfoService.getLoanInfo(tendid));
		return tendInfoService.getLoanInfo(tendid);
	}

	/**
	 * 查询借款人信息
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getGaveList")
	public Object getGaveList(@RequestBody Map map){
//		System.out.println(map.get("tendid"));
		Map map1 = new HashMap();
		map1.put("total",tendInfoService.getGaveCount(Integer.valueOf(map.get("tendid")+"")));
		map1.put("data",tendInfoService.getGaveList(map));
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
		System.out.println(Integer.valueOf(map.get("tendid")+""));
		return investmentService.currentlyVoted(21);
	}


}
