package com.group8.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;


/**
 * className:testList
 * descriptive:
 * author:荣恒
 * createTime:2018/11/21 9:41
 */


public class test {
    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    public static void main(String [] args) {

        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

        int mobile_code = (int)((Math.random()*9+1)*100000);

        String content = new String("您的验证码是：" + mobile_code + "。请哈哈哈哈哈哈给其他人。");

        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C29727181"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", "5d727da47f2358c384d6c5f0960c935e"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", "*****"),
                new NameValuePair("content", content),
        };
      /*  method.setRequestBody(data);*/


        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();
            System.out.println(SubmitResult);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("发送完成s");
        }



            //System.out.println(SubmitResult);


    }



}
