package com.group8.service.customer;

import com.group8.dao.cascade.CascadeDao;
import com.group8.dao.customer.InformationDao;
import com.group8.dao.customer.LoginDao;
import com.group8.entity.Customer;
import com.group8.entity.MoneyRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:InformationServiceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-24 14:44
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationDao informationDao;
    @Autowired
    private CascadeDao cascadeDao;

    @Autowired
    private LoginDao loginDao;


    @Override
    public Customer getTelephoneByUserName(String userName) {
        Customer customer  = informationDao.getTelephoneByUserName(userName);
        return customer;
    }



    @Override
    public List<Map> getRealNameByUserId(Integer userId) {
        List<Map> realNameList = informationDao.getRealNameByUserId(userId);
        return realNameList;
    }
    @Override
    public List<Map> getAuditorStatus(Integer audutorId) {
        List<Map> auditorStatus = informationDao.getAuditorStatus(audutorId);
        return auditorStatus;
    }

    @Override
    public List<Map> getEducation() {
        List<Map> education = informationDao.getEducation();
        return education;
    }

    @Override
    public List<Map> getMarriage() {
        List<Map> marriage = informationDao.getMarriage();
        return marriage;
    }

    @Override
    public List<Map> getAddress() {
        List<Map> address = informationDao.getAddress();
        return address;
    }

    @Override
    public List<Map> getIncome() {
        List<Map> income = informationDao.getIncome();
        return income;
    }

    @Override
    public int SubmissionRealName(Map map, HttpSession session) {

        Object province1 = map.get("province");
        Object city1 = map.get("city");
        Object area1 = map.get("area");
        Object position1 = map.get("position");
        List<Map> provinceById = cascadeDao.getProvinceById(Integer.valueOf(province1.toString()));
        String province2 = provinceById.get(0).get("PROVINCE").toString();

        List<Map> cityById= cascadeDao.getCityById(Integer.valueOf(city1.toString()));
        String city2 = cityById.get(0).get("CITY").toString();

        List<Map> areaById = cascadeDao.getAreaById(Integer.valueOf(area1.toString()));
        String area2 = areaById.get(0).get("AREA").toString();

        String address =province2+","+city2+","+area2+","+position1.toString();

        map.put("address",address);
        Customer customer = loginDao.getByName(session.getAttribute("CustomerName").toString());
        Integer userId = customer.getUserId();
        map.put("userId",userId);
        System.out.println(map);
        int i = informationDao.SubmissionRealName(map);

        return i;
    }


    @Override
   public  List<Map> getRealIdByUserName(String userName){
        List<Map> realIdByUserName = informationDao.getRealIdByUserName(userName);
        return realIdByUserName;
    }


    @Override
    public int updateHeadPortrait(Map map){
        int i = informationDao.updateHeadPortrait(map);

        return  i ;
    }

    @Override
    public Map selectHeadPortrait(String userName) {
        List<Map> maps = informationDao.selectHeadPortrait(userName);
        return maps.get(0);
    }


    @Override
    public int rechargeAmount(Map map) {
        int i = informationDao.rechargeAmount(map);
        if(i>0){

            MoneyRecords moneyRecords = new MoneyRecords();
            moneyRecords.setRecords(Double.valueOf(map.get("money").toString()));
            moneyRecords.setUserId(Integer.valueOf(map.get("userId").toString()));
            moneyRecords.setThing("个人信息充值操作");
            moneyRecords.setType(1);
            System.out.println("------------------");

            System.out.println(moneyRecords.getRecords());
            System.out.println(moneyRecords.getThing());
            System.out.println(moneyRecords.getType());
            System.out.println(moneyRecords.getUserId());
            informationDao.rechargeAmountRecords(moneyRecords);
            System.out.println("------------------");
        }
        return i;
    }



}
