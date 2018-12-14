package com.group8.controller.qiantai;

import com.group8.service.qiantai.TendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@ResponseBody
	@RequestMapping("getLoanList")
	public Object getLoanList(@RequestParam Integer tendid){
		System.out.println(tendid);
		return tendInfoService.getLoanList(tendid);
	}



}
