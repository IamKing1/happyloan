package com.group8.dao.customer;

import com.group8.entity.Customer;
import com.group8.entity.MoneyRecords;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:InformationDao
 * discriptoin:
 * author:丁启斌
 * createTime:2018-11-24 14:44
 */
@Component
public interface InformationDao {

    /**
     * 查询用户手机号是否绑定
     * @param userName
     * @return
     */
    Customer getTelephoneByUserName(String userName);


    /**
     * 根据用户id查询实名认证
     * @param userId
     * @return
     */
    List<Map> getRealNameByUserId(Integer userId);

    /**
     * 查询审核状态
     * @param audutorId
     * @return
     */
    List<Map> getAuditorStatus(Integer audutorId);

    /**
     * 从数据库获取学历
     * @return
     */
    List<Map> getEducation();

    /**
     * 从数据库获取婚姻状态
     * @return
     */
    List<Map> getMarriage();
    /**
     * 从数据库获取现住址
     * @return
     */
    List<Map> getAddress();
    /**
     * 从数据库获取收入级别
     * @return
     */
    List<Map> getIncome();
    /**
     * 提交认证信息
     * @param map
     * @return
     */
    int SubmissionRealName(Map map);

    /**
     * 根据用户名查询真实姓名
     * @param userName
     * @return
     */
    List<Map> getRealIdByUserName(String userName);


    /**
     * 根据用户名修改头像
     * @param map
     * @return
     */
    int updateHeadPortrait(Map map);

    /**
     * 根据用户名查询头像
     * @param userName
     * @return
     */
    List<Map> selectHeadPortrait(String userName);

    /**
     * 充值
     * @param map
     * @return
     */
    int rechargeAmount(Map map);

    /**
     * 充值记录
      * @param records
     * @return
     */
    int rechargeAmountRecords(MoneyRecords records);

    /**
     * 查询实名认证状态,用于显示实名认证页面
     * @param customerName
     * @return
     */
    List<Map>  isRealName(String customerName);

    /**
     * 显示用户实名认证提交的信息
     * @param customerName
     * @return
     */
    List<Map> realNameAllInfo(String customerName);

    /**
     * 实名认证失败,删除信息
     * @param username
     * @return
     */
    Integer removeRealName(String username);

	/**
	 * 获取身份证和邮箱,判断认证信息完整程度
	 * @param username
	 * @return
	 */
	List<Map> getIdNumEmail(String username);

    /**
     * 重新进行实名认证  删除已经提交过的
     * @param userId
     * @return
     */
    int deleteRealNameIsNo(Integer userId);

    /**
     * 修改昵称
     * @param map
     * @return
     */
    int updateNickName(Map map);

    /**
     * 得到余额
     * @param userId
     * @return
     */
    Integer getBalanceByUserId(Integer userId);

    /**
     * 待收本息
     * @param userId
     * @return
     */
    Integer getPrincipalAndInterestToBeCollected(Integer userId);

    /**
     * 累计收益
     * @param userId
     * @return
     */
    Integer getAccumulatedIncome(Integer userId);

    /**
     * 投资中金额，投资的项目还在招标中
     * @param userId
     * @return
     */
    Integer getAmountInInvestment(Integer userId);
}
