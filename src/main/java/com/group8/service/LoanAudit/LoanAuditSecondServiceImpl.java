package com.group8.service.LoanAudit;

import com.group8.dao.LoanAudit.LoanAuditSecondDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:LoanAuditSecondServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-07 14:06
 */
@Service
@SuppressWarnings("all")
public class LoanAuditSecondServiceImpl implements LoanAuditSecondService {


    @Autowired
    private LoanAuditSecondDao loanAuditSecondDao;

    /**
     * 二审分页列表
     * @param map
     * @return
     */
    @Override
    public List<Map> getListLoanSec(Map map) {
        return loanAuditSecondDao.getListLoanSec(map);
    }

    /**
     * 分页数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return loanAuditSecondDao.getPageCount(map);
    }

    @Override
    public int update(Map map) {
        return loanAuditSecondDao.update(map);
    }
}
