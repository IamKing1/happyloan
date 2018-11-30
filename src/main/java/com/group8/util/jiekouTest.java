package com.group8.util;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 * className:jiekouTest
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-29 23:38
 */
public class jiekouTest {
    private static String Url = "https://sms.dun.163yun.com/v2/sendsms";

    public static void main(String[] args) {
//https://way.jd.com/CL253/cl253_json?phone=13917969023&msg=【253云通讯】您的验证码是123456&appkey=81b7c0db9cefcece27604c6bc3289aab


        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        //client.getParams().setContentCharset("GBK");
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");

        int code=(int)(Math.random()*(9999-1000+1))+100000;//产生6位随机数

        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "b602af58eec78ad63ca07cfe287ea6b7"),
                new NameValuePair("password", "7299e5448d45d816c9e90d9a583dcf55 "),
                new NameValuePair("phone", "15893281386"),
                new NameValuePair("msg", "【253云通讯】您的验证码是7528"),
                new NameValuePair("appkey", "43b729d8eabe4b9d9f582f931ee64905 "),
        };

        method.setRequestBody(data);


        try {
            client.executeMethod(method);
            System.out.println(method.getResponseBodyAsString());
        } catch (IOException e) {
            e.printStackTrace();
        }





        System.out.println("短信提交成功");
    }

}
