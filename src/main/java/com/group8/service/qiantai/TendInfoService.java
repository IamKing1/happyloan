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
	List<Map> getLoanList();

	/**
	 * 获取借款金额,期数
	 * @return
	 */
	List<Map> getLoanInfo();

	/**
	 * 获取投标人列表-昵称,钱数,时间
	 * @return
	 */
	List<Map> getGaveList();
}
