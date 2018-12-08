package com.group8.service.LoanAudit;

import com.group8.dao.LoanAudit.LoanDismissDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:LoanDismissServiceImpl
 * descriptive:
 * author:万中华
 * createTime:2018-12-07 19:02
 */
@Service
@SuppressWarnings("all")
public class LoanDismissServiceImpl implements LoanDismissService {

    @Autowired
    private LoanDismissDao loanDismissDao;

    /**
     * 贷款驳回列表
     * @param map
     * @return
     */
    @Override
    public List<Map> getListLoanDis(Map map) {
        return loanDismissDao.getListLoanDis(map);
    }

    /**
     * 驳回数量查询
     * @param map
     * @return
     */
    @Override
    public int getPageCounts(Map map) {
        return loanDismissDao.getPageCounts(map);
    }

    /**
     * 更改是否重新审核
     * @param map
     * @return
     */
    @Override
    public int updateDis(Map map) {
        return loanDismissDao.updateDis(map);
    }
}
