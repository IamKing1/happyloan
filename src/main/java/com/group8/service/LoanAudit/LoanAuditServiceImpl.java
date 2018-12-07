package com.group8.service.LoanAudit;

import com.group8.dao.LoanAudit.LoanAuditDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:LoanAuditServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-06 14:33
 */
@Service
@SuppressWarnings("all")
public class LoanAuditServiceImpl implements LoanAuditService {

    @Autowired //依赖注入
    private LoanAuditDao loanAuditDao;
    /**
     * 贷款信息查询
     * @param map
     * @return
     */
    @Override
    public List<Map> getListLoan(Map map) {
        return loanAuditDao.getListLoan(map);
    }

    /**
     * 分页数量
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {

        return loanAuditDao.getPageCount(map);
    }

    @Override
    public int update(Map map) {
        return loanAuditDao.update(map);
    }
}
