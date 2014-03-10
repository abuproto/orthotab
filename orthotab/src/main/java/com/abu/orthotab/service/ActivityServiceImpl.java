package com.abu.orthotab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abu.orthotab.dao.ActivityDao;
import com.abu.orthotab.domain.Activity;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;
	
	@Override
	@Transactional
	public Long createActivity(Activity activity) {
		return activityDao.createActivity(activity);
	}

}
