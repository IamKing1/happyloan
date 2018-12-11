package com.group8.service.auditing;

import com.group8.dao.auditing.ReleasedDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:ReleasedServiceImpl
 * descriptive:查看已发布贷款
 * author:万中华
 * createTime:2018-12-10 13:43
 */
@Service
@SuppressWarnings("all")
public class ReleasedServiceImpl implements ReleasedService {

    @Autowired
    private ReleasedDao releasedDao;
    @Override
    public List<Map> getListRelease(Map map) {
        return releasedDao.getListRelease(map);
    }
}
