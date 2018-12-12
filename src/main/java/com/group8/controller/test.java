package com.group8.controller;


import com.group8.util.FTPfile;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

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

	@RequestMapping("/user/addImg")
	@ResponseBody
	public String addImg(@RequestBody MultipartFile file, HttpServletRequest request, HttpServletResponse response)throws Exception{
		System.out.println("上传图片是否为空："+file.isEmpty());
		if(file != null){
			String path =null;// 文件路径
			String imgType=null;//图片类型
			String  fileName = file.getOriginalFilename();// 原文件名称
			// 判断图片类型
			imgType=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
			if(imgType!=null){
//				if("GIF".equals(imgType.toUpperCase()) || "PNG".equals(imgType.toUpperCase()) || "JPG".equals(imgType.toUpperCase())){
					// 项目在容器中实际发布运行的根路径
					/* String realPath = request.getSession().getServletContext().getRealPath("/");*/
					String realPath = "E:\\upload\\";
					// 自定义的文件名称
					String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
					// 设置图片存放的路径
					path=realPath+trueFileName;
					System.out.println("图片的存放路径为"+path);
					// 转存文件到指定路径
					file.transferTo(new File(path)); // 转存而不是写出
					System.out.println("文件成功上传到指定目录下");
				/*}else{
					System.out.println("请上传GIF、PNG或者JPG格式的文件");
				}*/
			}else{
				System.out.println("文件类型为空");
			}
			return path;
		}else{
			System.out.println("没有找到相对应的文件");
		}
		System.out.println("文件上传的原名称为:"+file.getOriginalFilename());

		return "";
	}
}
