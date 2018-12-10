package com.group8.service.test;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:TestService
 * descriptive:
 * author:荣恒
 * createTime:2018/12/7 14:25
 */

public interface TestService {
	/**
	 * 获取test列表
	 * @return
	 */
	List<Map> getTestList();

	/**
	 * 更新test
	 * @param map
	 * @return
	 */
	int updateTest(Map map);
}
