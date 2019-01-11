package com.group8.controller.testList;

import com.group8.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:GetTestController
 * descriptive:
 * author:荣恒
 * createTime:2018/12/7 14:27
 */

@Controller
public class GetTestController {



	@Autowired
	private TestService testService;

	/**
	 * 获取test列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getTestList")
	public Object getTestList(){

		return testService.getTestList();
	}

	/**
	 * 更新
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateTest")
	public Object updateTest(@RequestBody Map map){
//		System.out.println(map);
		return testService.updateTest(map);
	}




}
