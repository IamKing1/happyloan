package com.group8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * className:allJump
 * discription:后台页面跳转
 * author:丁启斌
 * createTime:2018-11-21 20:24
 */
@Controller
@RequestMapping(value = "jump")
public class AllJumpController {

    @RequestMapping(value = ("toProductList"))
        public String toProductList(){
        return "productList";
        }

    @RequestMapping(value = ("toUserList"))
    public String toUserList(){

        return "userList";
    }

    /**
     * 跳转后台主页面
     * @return
     */
    @RequestMapping("toAdmin")
    public String toAdmin(){
        return "admin";
    }

    /**
     * 跳转后台主右侧测试页面
     * @return
     */
    @RequestMapping("toEg1")
    public String toEg1(){
        return "eg1";
    }

    /**
     * 跳转后台主右侧测试2页面
     * @return
     */
    @RequestMapping("toEg2")
    public String toEg2(){
        return "eg2";
    }

    @RequestMapping("alltend")
	public String jumpToAlltend(){
    	return "/bid/alltend";
    }
}
