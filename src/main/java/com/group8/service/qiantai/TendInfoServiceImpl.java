package com.group8.service.qiantai;

import com.group8.dao.qiantai.TendInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:TendInfoServiceImpl
 * descriptive:
 * author:荣恒
 * createTime:2018/12/14 17:03
 */

@Service
public class TendInfoServiceImpl implements TendInfoService {
	@Autowired
	private TendInfoDao tendInfoDao;
	@Override
	public List<Map> getLoanList(Integer tendid) {
		return tendInfoDao.getLoanList(tendid);
	}

	@Override
	public List<Map> getLoanInfo() {
		return null;
	}

	@Override
	public List<Map> getGaveList() {
		return null;
	}
}
