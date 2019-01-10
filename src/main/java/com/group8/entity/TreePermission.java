package com.group8.entity;

import java.util.List;

/**
 * className:TreeRole
 * discriptoin:
 * author:丁启斌
 * createTime:2019-01-07 18:25
 */
public class TreePermission {

    private int id;
    private String label;
    private int functioncoding;
    private String functionurl;
    List<TreePermission> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TreePermission> getChildren() {
        return children;
    }

    public void setChildren(List<TreePermission> children) {
        this.children = children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getFunctioncoding() {
        return functioncoding;
    }

    public void setFunctioncoding(int functioncoding) {
        this.functioncoding = functioncoding;
    }

    public String getFunctionurl() {
        return functionurl;
    }

    public void setFunctionurl(String functionurl) {
        this.functionurl = functionurl;
    }




}
