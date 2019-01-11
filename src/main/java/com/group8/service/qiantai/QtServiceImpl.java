package com.group8.service.qiantai;

import com.group8.dao.qiantai.QtDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:QtServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-13 15:03
 */
@Service
@SuppressWarnings("all")
public class QtServiceImpl implements QtService {

    @Autowired
    private QtDao qtDao;

    @Override
    public List<Map> getList(Map map) {

        List<Map> list = qtDao.getList(map);

        for (Map map1 : list) {
            //借款人姓名
            String realname = map1.get("REALNAME").toString().substring(0, 1);
            //借款人性别
            String  sex;
            if (Integer.valueOf(map1.get("SEX").toString())==1){
                sex="先生";
            }else {
                sex="女生";
            }
            //用途
            String purpose = map1.get("PURPOSE").toString();
            //抵押东西
            String housingquantity = map1.get("HOUSINGQUANTITY").toString();

            map1.put("TITLE",realname+sex+purpose+"用钱,抵押"+housingquantity);
        }
        return list;
    }
    @Override
    public int getPageCount(Map map) {
        return qtDao.getPageCount(map);
    }


    @Override
    public List<Map> getCountMoney() {
        return qtDao.getCountMoney();
    }

    @Override
    public List<Map> getCountClient() {
        return qtDao.getCountClient();
    }
}
