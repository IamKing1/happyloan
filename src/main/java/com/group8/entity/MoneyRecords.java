package com.group8.entity;

/**
 * className:MoneyRecords
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-06 18:53
 */
public class MoneyRecords {

        private Integer userId;
        private Double records;
        private Integer type;
        private String time;
        private String thing;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getRecords() {
        return records;
    }

    public void setRecords(Double records) {
        this.records = records;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }
}
