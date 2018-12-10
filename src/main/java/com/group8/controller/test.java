package com.group8.controller;


import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:testList
 * descriptive:
 * author:荣恒
 * createTime:2018/11/20 17:00
 */

@Controller
public class test {

	@RequestMapping(value = "test1")
	public String test1(){
		System.out.println("途径此处a");
//		System.out.println("构建完成");
	//	System.out.println("构建完成1");
		System.out.println("途径此处");
		System.out.println("构建完成");
		System.out.println("构建完成1111");
		System.out.println("构建完成1111");
		return "user";
	}
	/**
	 * 图片显示方法
	 * @param fileName
	 * @return
	 */
	/*@RequestMapping("/showFtp")
	public ResponseEntity showFtp(String fileName){
		try {
			// 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
			Resource resource = resourceLoader.getResource("ftp://p2p:aaa@172.16.22.62/"+fileName);
			return ResponseEntity.ok(resourceLoader.getResource("ftp://p2p:aaa@172.16.22.62/"+fileName));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}*/
}
