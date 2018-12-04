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


    public static void main(String[] args) {
        String s2 = new StringBuilder("ja").append("va").toString();
        String s3 = new StringBuilder("11").append("22").toString();
        System.out.println(s2.intern());

        System.out.println(s2.intern() == s2);
        System.out.println(s3.intern() == s3);

    }
}
