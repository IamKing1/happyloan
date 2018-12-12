package com.group8.service.auditing;

import com.group8.dao.auditing.ReleaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:ReleaseSerivceImpl
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-06 20:42
 */
@Service
@SuppressWarnings("all")
public class ReleaseSerivceImpl implements  ReleaseService {

    @Autowired
    private ReleaseDao release;

    @Override
    public List<Map> getReleaseMessage(Map map) {
        List<Map> releaseMessage = release.getReleaseMessage(map);
        if(releaseMessage!=null&&releaseMessage.size()>0){
            return releaseMessage;
        }

        return null;
    }

    @Override
    public int getReleaseMessageCount(Map map) {
        int releaseMessageCount = release.getReleaseMessageCount(map);
        return releaseMessageCount;
    }

    @Override
    public int confirmationInformation(Map map) {
        int i = release.confirmationInformation(map);
        if(i>0){
            map.put("release",2);
           release.updateConfirmationInformationStuts(map);
        }
        return i;
    }

    @Override
    public List<Map> getConfirmationInformationList() {
        List<Map> confirmationInformationList = release.getConfirmationInformationList();
        return confirmationInformationList;
    }
}
