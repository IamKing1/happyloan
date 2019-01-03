package com.group8.service.qiantai;

import com.group8.dao.qiantai.MyInvestment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:MyInvestmentServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-29 17:10
 */
@Service
@SuppressWarnings("all")
public class MyInvestmentServiceImpl implements MyInvestmentService {

    @Autowired
    private MyInvestment myInvestment;

    /**
     * 获取投资记录
     *
     * @param map
     * @return
     */
    @Override
    public List<Map> getListInvestment(Map map) {
        List<Map> listInvestment = myInvestment.getListInvestment(map);
        //拼接项目标题
        for (Map map1 : listInvestment) {
            //截取借款人姓氏
            String realname = map1.get("REALNAME").toString().substring(0, 1);
            //借款人性别
            String sex;
            if (Integer.valueOf(map1.get("SEX").toString()) == 1) {
                sex = "先生";
            } else {
                sex = "女士";
            }
            //用途
            String purpose = map1.get("PURPOSE").toString();
            //抵押物
            String housingquantity = map1.get("HOUSINGQUANTITY").toString();
            //最后拼接
            map1.put("TITLE", realname + sex + purpose + "用钱,抵押" + housingquantity);
        }
        return listInvestment;
    }

    /**
     * 分页数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return myInvestment.getPageCount(map);
    }

}
