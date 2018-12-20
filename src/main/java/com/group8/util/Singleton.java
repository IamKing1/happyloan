package com.group8.util;

/**
 * className:test1
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-03 08:56
 */
public class Singleton {
    private Singleton() {
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}

