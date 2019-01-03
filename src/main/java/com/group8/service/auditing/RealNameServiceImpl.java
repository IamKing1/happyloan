package com.group8.service.auditing;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.group8.dao.auditing.RealNameDao;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:realNameImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-03 16:56
 */
@Service
public class RealNameServiceImpl implements RealNameService {


    @Autowired
    private RealNameDao realNameDao;


    @Override
    public List<Map> getNoRealNameList(Map map) {
        List<Map> noRealNameList = realNameDao.getNoRealNameList(map);
        return noRealNameList;
    }

    @Override
    public int getNoRealNameCount(Map map) {
        int noRealNameCount = realNameDao.getNoRealNameCount(map);
        return noRealNameCount;
    }


    @Override
    public int getRealNameResult(Map map) {
       /* System.out.println("传过来的map值："+map);
        System.out.println("22222222222222-------------------------------------");*/
        int realNameResult = realNameDao.getRealNameResult(map);

        Map resultMap=new HashMap();
        Integer result = Integer.valueOf((map.get("result") + ""));
        if(result==22){
            resultMap.put("content","尊敬的用户，您好，很抱歉您的实名认证未能通过，原因是:"+(map.get("mse")+""));
            resultMap.put("userid",Integer.valueOf(map.get("USERID")+""));
            //调用添加方法
            int add1 = realNameDao.add(resultMap);
        }
        if(result==20){
            resultMap.put("content","尊敬的用户，您好，您的实名认证已通过，感谢您的配合,如有问题，请及时联系我们，谨防上当受骗。");
            resultMap.put("userid",Integer.valueOf(map.get("USERID")+""));
            //调用添加方法
            int add2 = realNameDao.add(resultMap);
        }
        return realNameResult;
    }

}
