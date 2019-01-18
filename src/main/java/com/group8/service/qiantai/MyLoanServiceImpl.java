package com.group8.service.qiantai;

import com.group8.dao.qiantai.MyLoanDao;
import com.group8.service.customer.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:MyLoanServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-15 09:54
 */
@Service
@SuppressWarnings("all")
public class MyLoanServiceImpl implements MyLoanService {

    @Autowired
    private MyLoanDao myLoanDao;

    @Autowired
    private InformationService informationService;

    @Override
    public List<Map> getMoney() {
        return myLoanDao.getMoney();
    }

    @Override
    public List<Map> getListLoan(Map map) {
        List<Map> listLoan = myLoanDao.getListLoan(map);

        return listLoan;
    }

    @Override
    public List<Map> getIssused(HttpSession session) {
        Object customerName = session.getAttribute("CustomerName");
        Map map = new HashMap();
        List<Map> realIdByUserName = informationService.getRealIdByUserName(customerName.toString());
        if(realIdByUserName!=null&&realIdByUserName.size()>0){
            map.put("realId",realIdByUserName.get(0).get("ID"));
        }
        List<Map> issused = myLoanDao.getIssused(map);
        if(issused!=null&&issused.size()>0) {
            for (Map map1 : issused) {
                //查询出预期的项目
             if(Integer.valueOf(map1.get("STUTS").toString()).equals(2)){
                    //计算出逾期这段时间应还的金额
                 int yuqi = myLoanDao.getYuQiMoney(Integer.valueOf(map1.get("TENDID").toString()));
                map1.put("MO", Integer.valueOf(map1.get("MO").toString())+yuqi);
             }
                //还款日期
                String duedate = map1.get("DUEDATE").toString();
                Date dt = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String format = simpleDateFormat.format(dt);

                System.out.println(map1);
                //判断现在的状态
                if(format.equals(duedate)){
                    map1.put("isno","1");
                }else if("2".equals(map1.get("STUTS").toString())){
                    map1.put("isno","1");
                }else if("3".equals(map1.get("STUTS").toString())){
                    map1.put("isno","2");
                }else {
                    map1.put("isno","3");
                }
            }
        }
        return issused;
    }

    @Override
    public int getPageCount(Map map) {
        return myLoanDao.getPageCount(map);
    }
}
