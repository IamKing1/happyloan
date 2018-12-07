package com.group8.util;

/**
 * className:test1
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-03 08:56
 */
public class test1 {


    public String ll(Integer a) {
        return null;
    }

    public Integer ll(Integer a, String b) {
        return null;
    }





    public static String reverse(String originStr) {

        if(originStr == null || originStr.length() <= 1){
            System.out.println(originStr.charAt(0));

            return originStr;
        }else{

            return reverse(originStr.substring(1)) + originStr.charAt(0);
        }



    }


    public static void main(String[] args) {
        System.out.println("撒大声地");
        System.out.println("种方法减肥的减肥");
        System.out.println((int)((Math.random()*9+1)*100000));
    }



    public static  String revce(String str){
        if(str==null||str.length()<=1){
            return str;
        }else{
            return  revce(str.substring(1))+ str.charAt(0);
        }

    }
}
