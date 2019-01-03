package com.group8.service.qiantai;

import java.util.List;
import java.util.Map;

/**
 * className:TendInfoService
 * descriptive:
 * author:荣恒
 * createTime:2018/12/14 17:03
 */


public interface TendInfoService {
	/**
	 * 获取借款人信息
	 * @return
	 */
	List<Map> getLoanList(Map tendid);

	/**
	 * 获取借款金额,期数
	 * @return
	 */
	List<Map> getLoanInfo(Map tendid);

	/**
	 * 获取投标人列表-昵称,钱数,时间
	 * @return
	 */
	List<Map> getGaveList(Map map);
	/**
	 * 获取投标人的总数
	 * @return
	 */
	Integer getGaveCount(Integer tendid);


	/**
	 * 个人设置页面的邮箱更新
	 * @param map
	 * @return
	 */
	Integer updateEmail(Map map);

}
