package com.group8.dao.qiantai;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:TendInfoDao
 * descriptive:
 * author:荣恒
 * createTime:2018/12/14 16:53
 */

@Component
public interface TendInfoDao {
	/**
	 * 获取借款人信息
	 * @return
	 */
	List<Map> getLoanList(Integer tendid);

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
