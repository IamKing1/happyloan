package com.group8.service.auditing;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:InvestmentService
 * discriptoin:
 * author:丁启斌
 * createTime:2018-12-12 17:02
 */
public interface InvestmentService {
    /**
     * 投资后余额减少
     * @param session
     * @param money
     * @return
     */
    int remainingSum(HttpSession session,Integer money);

    /**
     * 投资记录
     * @return
     */
    int investmentStorage(HttpSession session,Integer money,Integer tendId);


}
