package com.group8.dao.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * className:TestDao
 * descriptive:
 * author:荣恒
 * createTime:2018/12/7 14:22
 */
@Component
public interface TestDao {
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
