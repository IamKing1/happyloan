package com.group8.service.test;

import com.group8.dao.test.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:TestServiceImpl
 * descriptive:
 * author:荣恒
 * createTime:2018/12/7 14:25
 */

@Service

public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testDao;

	@Override
	public List<Map> getTestList() {
		return testDao.getTestList();
	}

	@Override
	public int updateTest(Map map) {
		return testDao.updateTest(map);
	}
}
